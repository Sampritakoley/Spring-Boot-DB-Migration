package com.example.SpringDbMigration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Message {

    @Id
    Long id;
    String title;
    String content;
    LocalDateTime createdAt;
}
