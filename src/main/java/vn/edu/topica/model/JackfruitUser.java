package vn.edu.topica.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import vn.edu.topica.constant.UserRole;
import vn.edu.topica.model.support.InstructorProfile;
import vn.edu.topica.model.support.JackfruitCourseOfUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "users")
public class JackfruitUser {

  @Id
  @Field(value = "_id")
  private String id;

  @Field(value = "created_at")
  private Date createdAt;

  @Field(value = "updated_at")
  private Date updatedAt;

  @Field(value = "email")
  @JsonProperty("email")
  private String email;

  @Field(value = "encrypted_password")
  private String encryptedPassword;

  @JsonProperty("role")
  private UserRole role;

  @Field(value = "first_name")
  @JsonProperty("first_name")
  private String firstName;

  @Field(value = "last_name")
  @JsonProperty("last_name")
  private String lastName;

  @Field(value = "avatar")
  private String avatar;

  @Field(value = "name")
  private String name;

  @Field("instructor_profile")
  private InstructorProfile instructorProfile = null;

  private int magentoStoreId;

  private int magentoWebsiteId;

  @Field("job")
  private String job;

  @Field("biography")
  private String biography;

  @Field("courses")
  private List<JackfruitCourseOfUser> jackfruitCourseOfUsers = new ArrayList<>();

  @Field("wishlist")
  private String[] wishList;

  @Field("is_deleted")
  @JsonProperty("is_deleted")
  private Integer isDeleted;


}
