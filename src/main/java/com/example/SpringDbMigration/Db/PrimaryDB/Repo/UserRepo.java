package com.example.SpringDbMigration.Db.PrimaryDB.Repo;

import com.example.SpringDbMigration.Db.PrimaryDB.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
}
