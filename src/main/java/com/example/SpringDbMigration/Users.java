package com.example.SpringDbMigration;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Entity
@Data
public class Users {
    @Id
    int id;
    String username;
    String password;
    String email;
    @ManyToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = {
                    @JoinColumn(name="user_id",referencedColumnName = "id")
            },inverseJoinColumns = {
            @JoinColumn(name = "role_id",referencedColumnName = "id")
    })
    private Set<Roles> roles;
}
