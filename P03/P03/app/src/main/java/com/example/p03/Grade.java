package com.example.p03;

import java.io.Serializable;

public class Grade implements Serializable {
    String grade;
    String code;

    public Grade(String grade, String code) {
        this.grade = grade;
        this.code = code;
    }

    public String getGrade() {
        return grade;
    }

    public String getCode() {
        return code;
    }
}
