package com.example.sitspacemanagement.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    int id;
    String name;
    double score;
    String grade;
}
