package vn.edu.topica.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import vn.edu.topica.model.JackfruitCourse;
import vn.edu.topica.model.JackfruitUser;

@Service
@Slf4j
public class JackFruitUserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public JackfruitUser findByEmail(String email){
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query, JackfruitUser.class);
    }

    public JackfruitUser findById(String id){
        return mongoTemplate.findById(id, JackfruitUser.class);
    }
}
