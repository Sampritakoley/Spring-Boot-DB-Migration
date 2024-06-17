package com.example.SpringDbMigration.Db.SecondaryDB.Repo;

import com.example.SpringDbMigration.Db.SecondaryDB.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

}
