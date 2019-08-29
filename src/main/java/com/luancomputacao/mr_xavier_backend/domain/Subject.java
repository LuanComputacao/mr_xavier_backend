package com.luancomputacao.mr_xavier_backend.domain;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "subject")
@EntityListeners(AuditingEntityListener.class)
@JsonRootName(value = "subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    @Length(max = 128)
    private String nome;

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Collection<Knowledge> knowledges;

    @OneToMany(mappedBy = "subject")
    @JsonBackReference
    private Collection<Question> questoes;

    @OneToMany(mappedBy = "subject")
    @JsonBackReference
    private Collection<Test> tests;

    public Subject() {
    }

    public Subject(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Knowledge> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(Collection<Knowledge> knowledges) {
        this.knowledges = knowledges;
    }

    public Collection<Question> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(Collection<Question> questoes) {
        this.questoes = questoes;
    }

    public Collection<Test> getTests() {
        return tests;
    }

    public void setTests(Collection<Test> tests) {
        this.tests = tests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject that = (Subject) o;
        return Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    @Override
    public String toString() {
        return "Subject{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
