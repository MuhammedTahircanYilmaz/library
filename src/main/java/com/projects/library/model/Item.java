package com.projects.library.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

public record Item(
        @Id
        Integer id,
        @Column("title")
        @NotBlank
        String title,
        @Column("description")
        String description,
        @Column("item_type")
        @NotBlank
        Type item_type,
        @Column("author_studio")
        @NotBlank
        String author_studio,
        @Column("rating")
        @NotBlank
        Integer rating,
        @Column("status")
        @NotBlank
        Status status,
        @Column("date_created")
        LocalDateTime date_created,
        @Column("date_updated")
        LocalDateTime date_updated
){

}
