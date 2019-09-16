package com.luancomputacao.mr_xavier_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "grade ")
@EntityListeners(AuditingEntityListener.class)
public class Grade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @JsonProperty("code")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "grade")
    @JsonBackReference
    private Collection<Question> questions;


    @OneToMany(mappedBy = "grade")
    @JsonBackReference
    private Collection<Test> tests;


    public Grade() {
    }

    public Grade(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade that = (Grade) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Grade{" +
                "name='" + name + '\'' +
                '}';
    }
}
