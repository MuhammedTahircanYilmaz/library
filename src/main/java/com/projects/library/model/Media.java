package com.projects.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "media")
public class Media {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "media_id")
        private Long mediaId;

        @Column(name = "username")
        @NotBlank
        private String username;

        @Column(name = "user_id")
        @NotBlank
        private Long userID;

        @Column(name = "title")
        @NotBlank
        private String title;

        @Column(name = "description")
        private String description;

        @Enumerated(EnumType.STRING)
        @NotBlank
        private Type itemType;

        @Column(name = "author_studio")
        @NotBlank
        private String authorStudio;

        @Column(name = "rating")
        private Integer rating;

        @Enumerated(EnumType.STRING)
        @NotBlank
        private Status status;

        @Column(name = "date_created")
        private LocalDateTime dateCreated;

        @Column(name = "date_updated")
        private LocalDateTime dateUpdated;
}
