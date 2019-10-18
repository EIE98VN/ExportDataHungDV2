package vn.edu.topica.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import vn.edu.topica.model.support.Curriculum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "courses")
public class JackfruitCourse {

  @Id
  @Field(value = "_id")
  private String id;

  @Field(value = "created_at")
  private Date createdAt;

  @Field(value = "updated_at")
  private Date updatedAt;

  @Field(value = "name")
  @JsonProperty("name")
  private String name;

  @Field(value = "lang")
  private String lang;

  @Field(value = "price")
  @JsonProperty("price")
  private Integer price;

  @Field(value = "old_price")
  @JsonProperty("old_price")
  private Integer oldPrice;

  @Field(value = "alias_name")
  @JsonProperty("slug")
  private String aliasName;

  @Field(value = "sub_title")
  @JsonProperty("sub_title")
  private String subTitle;

  @Field(value = "level")
  @JsonProperty("level")
  private String level;

  @Field(value = "image")
  @JsonProperty("image")
  private String image;

  @Field(value = "intro_link")
  private String introLink;

  @Field(value = "intro_image")
  private String introImage;

  @Field(value = "description_editor")
  private String description;

  @Field(value = "short_description_editor")
  private String shortDescriptionEditor;

  @Field(value = "num_lecture")
  private Integer numLecture;

  @Field(value = "duration")
  private Integer duration;

  @Field(value = "requirement")
  private List<String> requirement = new ArrayList<>();

  @Field(value = "benefit")
  private List<String> benefit = new ArrayList<>();

  @Field(value = "audience")
  private List<String> audience = new ArrayList<>();

  @Field(value = "labels_order")
  private List<String> labelsOrder = new ArrayList<>();

  private List<String> related = new ArrayList<>();

  @Field(value = "enabled_logo")
  private Boolean enabledLogo;

  @Field(value = "version")
  private String version;

  @Field(value = "current_version")
  private String currentVersion;

  @Field(value = "version_review")
  private String versionReview;

  @Field(value = "fake_average_rating")
  private Float fakeAverageRating;

  @Field(value = "fake_students")
  private Integer fakeStudents;

  @Field(value = "fake_num_rate")
  private Integer fakeNumRate;

  @Field(value = "fake_enabled")
  private Boolean fakeEnabled;

  @Field(value = "type")
  private String type;

  @Field(value = "note")
  private String note;

  @Field(value = "code")
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private String code;

  @Field(value = "instructor_code")
  private String instructorCode;

  @Field(value = "category_ids")
  private List<String> categoryIds = new ArrayList<>();

  @Field(value = "curriculums")
  private List<Curriculum> curriculums = new ArrayList<>();

  @Field(value = "user_id")
  private String userId;

  @Field(value = "enabled")
  private Boolean enabled;

  @Field(value = "rating")
  @JsonProperty("rating")
  private Double rating;

  @Field(value = "num_rate")
  @JsonProperty("num_rate")
  private int numRate;

  private String imageRaw;

  private int magentoAttributeSetId;

  private List<Integer> magentoCategoryIds;

  @Field(value = "promo_price")
  @JsonProperty("promo_price")
  private Integer promoPrice;

  public String getCode() {
    if(code != null){
      return code.trim();
    }

    return null;
  }

  public void setCode(String code) {
    if(code != null){
      this.code = code.trim();
    }
  }

}
