package vn.edu.topica.model.support;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class JackfruitCourseOfUser {

  @Id
  @Field(value = "_id")
  private String id;

  @Field(value = "course_id")
  private String courseId;

  @Field(value = "payment_status")
  private String paymentStatus;

  @Field(value = "updated_at")
  private Date updatedAt;

  @Field(value = "lectures")
  private List<Lecture> lectureList = new ArrayList<>();
}