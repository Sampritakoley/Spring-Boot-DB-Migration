package com.example.SpringDbMigration.Db.SecondaryDB.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Message {

    @Id
    Long id;
    String title;
    String content;
    LocalDateTime createdAt;
}