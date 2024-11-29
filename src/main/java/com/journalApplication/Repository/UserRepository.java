package com.journalApplication.Repository;

import com.journalApplication.Entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntry, ObjectId> {
    void deleteByUserName(String name);

    UserEntry findByUserName(String username);
}
