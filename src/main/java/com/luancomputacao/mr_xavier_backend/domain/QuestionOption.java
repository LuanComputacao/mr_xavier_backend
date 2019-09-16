package com.luancomputacao.mr_xavier_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "opcao_de_question")
@EntityListeners(AuditingEntityListener.class)
public class QuestionOption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Question question;

    @Column(name = "texto")
    private String texto;

    @Column(name = "value")
    private Boolean value;

    public QuestionOption() {
    }

    public QuestionOption(Question question, String texto, Boolean value) {
        this.question = question;
        this.texto = texto;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionOption that = (QuestionOption) o;
        return Objects.equals(getTexto(), that.getTexto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTexto());
    }


    @Override
    public String toString() {
        return "QuestionOption{" +
                "texto='" + texto + '\'' +
                '}';
    }
}
