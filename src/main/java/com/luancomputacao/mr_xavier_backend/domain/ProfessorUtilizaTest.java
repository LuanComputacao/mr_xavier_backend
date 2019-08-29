package com.luancomputacao.mr_xavier_backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "professor_utiliza_test")
@EntityListeners(AuditingEntityListener.class)
public class ProfessorUtilizaTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_professor", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Professor professor;

    @JoinColumn(name = "id_test", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Test test;

    @Column(name = "data_utilizacao", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date dataUtilizacao;

    public ProfessorUtilizaTest() {
    }

    public ProfessorUtilizaTest(Professor professor, Test test) {
        this.professor = professor;
        this.test = test;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Date getDataUtilizacao() {
        return dataUtilizacao;
    }

    public void setDataUtilizacao(Date dataUtilizacao) {
        this.dataUtilizacao = dataUtilizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorUtilizaTest that = (ProfessorUtilizaTest) o;
        return Objects.equals(getProfessor(), that.getProfessor()) &&
                Objects.equals(getTest(), that.getTest()) &&
                Objects.equals(getDataUtilizacao(), that.getDataUtilizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfessor(), getTest(), getDataUtilizacao());
    }

    @Override
    public String toString() {
        return "ProfessorUtilizaTest{" +
                "professor=" + professor +
                ", test=" + test +
                ", dataUtilizacao=" + dataUtilizacao +
                '}';
    }
}
