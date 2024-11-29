package com.journalApplication.Repository;
//
import com.journalApplication.Entity.ConfigJournalAppEntity;
import com.journalApplication.Entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository  extends MongoRepository<ConfigJournalAppEntity, ObjectId> {


}
