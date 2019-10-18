package vn.edu.topica.model.support;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "lectures")
public class Lecture {

    @Field(value = "status")
    private int status;

}
