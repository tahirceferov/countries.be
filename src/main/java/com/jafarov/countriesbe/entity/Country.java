package com.jafarov.countriesbe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Country {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;
    private String code;
    private String name;

    private String nativeName;
    private int phone;
    private String capital;
    private String continent;
    private String currency;
    private String language;
    private String flag;
}
