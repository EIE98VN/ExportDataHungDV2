package vn.edu.topica.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.topica.model.JackfruitCourse;
import vn.edu.topica.model.JackfruitPayment;
import vn.edu.topica.model.JackfruitUser;
import vn.edu.topica.model.support.JackfruitCourseOfUser;
import vn.edu.topica.model.support.Lecture;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Slf4j
public class ExportService {

  @Autowired JackFruitCourseService jackFruitCourseService;

  @Autowired JackFruitUserService jackFruitUserService;

  @Autowired JackFruitPaymentService jackFruitPaymentService;

  public String[] execute(String email, String courseCode, String[] record) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    JackfruitUser user = jackFruitUserService.findByEmail(email);
    if (user == null) {
      JackfruitPayment payment = jackFruitPaymentService.findByEmail(email);
      if (payment != null) {
        String userId = payment.getUserId();
        user = jackFruitUserService.findById(userId);
      }
      if (user == null) log.error("User not found: {} ", email);
      return record;
    }
    JackfruitCourse course = jackFruitCourseService.getCourseByCode(courseCode);
    if (course == null) {
      log.error("Course code not found: {} ", courseCode);
      return record;
    }
    String courseId = course.getId();
    int numberOfLectures = course.getNumLecture();
    List<JackfruitCourseOfUser> coursesOfUser = user.getJackfruitCourseOfUsers();
    JackfruitCourseOfUser courseOfUser =
        coursesOfUser.stream().filter(c -> courseId.equals(c.getCourseId())).findAny().orElse(null);
    if (courseOfUser != null) {
      int count = 0;
      for (Lecture lecture : courseOfUser.getLectureList()) {
        if (lecture.getStatus() == 2) count++;
      }
      String updatedDate = formatter.format(courseOfUser.getUpdatedAt());
      log.info("Date: {}, count: {}", updatedDate, count);
      record[40] = updatedDate;
      record[41] = String.valueOf(Math.round(((float) count / numberOfLectures) * 100)) + " %";
    }else{
      log.info("User didn't study this course {}", courseId );
    }
    return record;
  }
}
