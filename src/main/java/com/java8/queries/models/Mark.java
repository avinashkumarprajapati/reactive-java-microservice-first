package com.java8.queries.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mark {
    private Integer id;
    private Integer studentId;
    private Integer score;
    private String subject;
}
