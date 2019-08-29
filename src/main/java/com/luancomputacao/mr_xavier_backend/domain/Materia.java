package com.luancomputacao.mr_xavier_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "materia")
@EntityListeners(AuditingEntityListener.class)
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @JsonInclude
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Subject subject;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "materias")
    @JsonBackReference("materias")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<Question> questoes;

    public Materia() {
    }

    public Materia(Subject subject, String nome) {
        this.subject = subject;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(getSubject(), materia.getSubject()) &&
                Objects.equals(getNome(), materia.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject(), getNome());
    }


    @Override
    public String toString() {
        return "Materia{" +
                "subject=" + subject +
                ", nome='" + nome + '\'' +
                '}';
    }
}
