package com.luancomputacao.mr_xavier_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "knowledge")
@EntityListeners(AuditingEntityListener.class)
public class Knowledge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @JsonInclude
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Subject subject;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "knowledges")
    @JsonBackReference("knowledges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<Question> questions;

    public Knowledge() {
    }

    public Knowledge(Subject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
        Knowledge knowledge = (Knowledge) o;
        return Objects.equals(getSubject(), knowledge.getSubject()) &&
                Objects.equals(getName(), knowledge.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject(), getName());
    }


    @Override
    public String toString() {
        return "Knowledge{" +
                "subject=" + subject +
                ", name='" + name + '\'' +
                '}';
    }
}
