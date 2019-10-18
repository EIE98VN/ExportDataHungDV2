package vn.edu.topica.model.support;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(staticName = "of")
@Data
public class Document {

  private String link;

  private String title;
}
