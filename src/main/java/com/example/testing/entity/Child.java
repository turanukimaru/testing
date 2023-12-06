package com.example.testing.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long childId;
    @Column
    private String name;
}
