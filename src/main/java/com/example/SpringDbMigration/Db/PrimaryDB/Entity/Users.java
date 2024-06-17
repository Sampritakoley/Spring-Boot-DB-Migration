package com.example.SpringDbMigration.Db.PrimaryDB.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
