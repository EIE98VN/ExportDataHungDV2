package vn.edu.topica.model.support;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class InstructorProfile {

  @Field(value = "academic_rank")
  private String academicRank = null;

  @Field(value = "major")
  private String major = null;

  @Field(value = "function")
  private String function = null;

  @Field(value = "work_unit")
  private String workUnit = null;

  @Field(value = "description")
  private List<String> description = null;
}
