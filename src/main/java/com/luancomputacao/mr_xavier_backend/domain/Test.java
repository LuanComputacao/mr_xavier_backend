package com.luancomputacao.mr_xavier_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "test")
@EntityListeners(AuditingEntityListener.class)
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    private Professor autor;

    @Column(name = "criado_em", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date criadoEm;

    @Column(name = "atualizado_em")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date atualizadoEm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "id_grade", referencedColumnName = "id")
    private Grade grade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "id_subject", referencedColumnName = "id")
    private Subject subject;

    @ManyToMany
    @JoinTable(
            name = "questions_de_test",
            joinColumns = {@JoinColumn(name = "question_id")},
            inverseJoinColumns = {@JoinColumn(name = "test_id")}
    )
    @JsonBackReference("tests")
    private Collection<Question> questions;

    @OneToMany(mappedBy = "test")
    @JsonBackReference
    private Collection<ProfessorUtilizaTest> professorUtilizaTests;

    public Test() {
    }

    public Test(String descricao, Professor autor, Grade grade, Subject subject, Collection<Question> questions) {
        this.descricao = descricao;
        this.autor = autor;
        this.grade = grade;
        this.subject = subject;
        this.questions = questions;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getAutor() {
        return autor;
    }

    public void setAutor(Professor autor) {
        this.autor = autor;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(Date atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public Collection<ProfessorUtilizaTest> getProfessorUtilizaTests() {
        return professorUtilizaTests;
    }

    public void setProfessorUtilizaTests(Collection<ProfessorUtilizaTest> professorUtilizaTests) {
        this.professorUtilizaTests = professorUtilizaTests;
    }
}
