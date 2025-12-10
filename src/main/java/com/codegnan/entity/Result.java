package com.codegnan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Student student;

    @ManyToOne(optional = false)
    private Subject subject;

    @Min(value = 0, message = "Marks must be >= 0")
    @Max(value = 100, message = "Marks must be <= 100")
    private Integer marks;

    // Simple grade field (you can generate based on marks if you want)
    private String grade;
}
