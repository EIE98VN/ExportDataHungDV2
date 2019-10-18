package vn.edu.topica.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "payments")
public class JackfruitPayment {
    @Id
    @Field(value = "_id")
    private String id;

    @Field(value = "user_id")
    private String userId;

    @Field(value = "course_id")
    private String courseId;

    @Field(value = "status")
    private String status;

    @Field(value = "created_at")
    private Date createdAt;

    @Field(value = "email")
    private String email;
}
