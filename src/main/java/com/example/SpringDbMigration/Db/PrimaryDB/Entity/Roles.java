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
public class Roles {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        int id;
        String roleName;

        @ManyToMany(mappedBy = "roles",fetch= FetchType.LAZY)
        private Set<Users> users;
}
