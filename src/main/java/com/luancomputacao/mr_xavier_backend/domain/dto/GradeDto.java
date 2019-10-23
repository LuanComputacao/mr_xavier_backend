package com.luancomputacao.mr_xavier_backend.domain.dto;

import java.io.Serializable;

public class GradeDto implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
