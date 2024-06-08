package com.projects.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Entity
public record Item(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id,
        @Column("title")
        @NotBlank
        String title,
        @Column("description")
        String description,
        @Column("itemType")
        @NotBlank
        Type itemType,
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
