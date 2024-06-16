package com.example.SpringDbMigration;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Roles {

    @Id
    int id;
    String roleName;

    @ManyToMany(mappedBy = "roles",fetch= FetchType.LAZY)
    private Set<Users> users;
}
