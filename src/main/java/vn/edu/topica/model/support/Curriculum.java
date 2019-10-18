package vn.edu.topica.model.support;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true, value = {"url"})
public class Curriculum {

  @Id
  @Field(value = "_id")
  private String id;

  private int status;

  private String type;

  private int order;

  @Field(value = "chapter_index")
  private int chapterIndex;

  @Field(value = "lecture_index")
  private int lectureIndex;

  @Field(value = "object_index")
  private int objectIndex;

  private String title;

  private String description;

  private int duration;

  @Field(value = "asset_type")
  private String assetType;

  private String url;

  @Field(value = "use_cdn")
  private boolean useCdn;

  @Field(value = "not_protected")
  private boolean notProtected;

  private boolean previewable;

  @Field(value = "is_vn")
  private boolean isVn;

  @Field(value = "documents")
  private List<Document> documents = null;
}
