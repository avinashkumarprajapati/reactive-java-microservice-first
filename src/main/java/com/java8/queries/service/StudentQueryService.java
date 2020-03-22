package com.java8.queries.service;

import com.java8.queries.models.Mark;
import com.java8.queries.models.Student;

import java.util.List;
import java.util.stream.Collectors;

public  class StudentQueryService {

    public static List<Student> findTopStudents(List<Student> studentList, Integer howManyFromTop) {
        List<Student> students = studentList.stream()
                .sorted((s1, s2) -> {
                    Double avg1 = s1.getMarks()
                            .stream()
                            .collect(Collectors.averagingDouble(Mark::getScore));
                    Double avg2 = s2.getMarks()
                            .stream()
                            .collect(Collectors.averagingDouble(Mark::getScore));
                    return (avg1 > avg2) ? -1 : (avg1 < avg2) ? 1 : 0; // in descending
                })
                .limit(howManyFromTop)
                .collect(Collectors.toList());
        return students;
    }
}


