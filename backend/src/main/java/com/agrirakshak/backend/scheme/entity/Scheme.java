package com.agrirakshak.backend.scheme.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "government_schemes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 2000)
    private String description;

    private String eligibility;

    private String state;

    private String website;
}