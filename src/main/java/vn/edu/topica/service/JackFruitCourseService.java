package vn.edu.topica.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import vn.edu.topica.model.JackfruitCourse;

@Service
@Slf4j
public class JackFruitCourseService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public JackfruitCourse getCourseByCode(String code){
        Query query = new Query();
        query.addCriteria(Criteria.where("code").is(code));
        return mongoTemplate.findOne(query, JackfruitCourse.class);
    }


}
