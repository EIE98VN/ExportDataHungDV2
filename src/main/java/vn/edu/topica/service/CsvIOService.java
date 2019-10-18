package vn.edu.topica.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CsvIOService {

  @Autowired ExportService exportService;

  public void write() {
    try {

      Reader reader =
          Files.newBufferedReader(
              Paths.get("C:\\Users\\EIE\\Desktop\\Topica\\CSV\\src\\main\\resources\\test.csv"));
      CSVReader csvReader = new CSVReader(reader);
      FileWriter outputfile =
          new FileWriter("C:\\Users\\EIE\\Desktop\\Topica\\CSV\\src\\main\\resources\\output.csv");

      // create CSVWriter object file writer object as parameter
      CSVWriter writer = new CSVWriter(outputfile);

      String[] nextRecord;
      int row = 1;
      while ((nextRecord = csvReader.readNext()) != null) {
        String email = nextRecord[0].replaceAll("\\s+","");
        String code = nextRecord[11].replaceAll("\\s+","");
        if(email.contains("â€‹")){
          email = email.substring(0, email.length()-3);
        }
        if (row == 1) {
          writer.writeNext(nextRecord);
          row++;
          continue;
        }
        String[] newRecord = exportService.execute(email, code, nextRecord);
        writer.writeNext(newRecord);
        row++;
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
