package com.projects.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

import static com.projects.library.model.Status.ONGOING;
import static com.projects.library.model.Type.ANIME;

@Entity
public record Item(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @Column(name = "title")
        @NotBlank
        String title,
        @Column(name = "description")
        String description,
        @Enumerated(EnumType.STRING)
        @NotBlank
        Type itemType,
        @Column(name = "author_studio")
        @NotBlank
        String authorStudio,
        @Column(name = "rating")
        @NotBlank
        Integer rating,
        @Enumerated(EnumType.STRING)
        @NotBlank
        Status status,
        @Column(name = "date_created")
        LocalDateTime dateCreated,
        @Column(name = "date_updated")
        LocalDateTime dateUpdated
){
        @ConstructorProperties({"id", "title", "description", "itemType","authorStudio",
                                "rating", "status", "dateCreated","dateUpdated"})
        public Item{

        }
        public Item(){
                this(null,"name","some description",ANIME,"author",
                        3,ONGOING, LocalDateTime.now(), LocalDateTime.now());
        }

        public Long getId(){
                return id;
        }
}
