package com.luancomputacao.mr_xavier_backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "proposta_de_invalidacao")
@EntityListeners(AuditingEntityListener.class)
public class PropostaDeInvalidacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "id_question", referencedColumnName = "id", updatable = false, nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "id_professor", referencedColumnName = "id", updatable = false, nullable = false)
    private Professor professor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "id_moderador", referencedColumnName = "id")
    private Professor moderador;

    @Column(name = "criado_em", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date dataPostagem;

    @Column(name = "analisado_em", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date dataAnalise;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "justificativa", nullable = false)
    private String justificativa;

    @Column(name = "proposta", nullable = false)
    private String proposta;


    public PropostaDeInvalidacao() {
    }

    public PropostaDeInvalidacao(Question question, Professor professor, Professor moderador) {
        this.question = question;
        this.professor = professor;
        this.moderador = moderador;
        this.status = false;
    }

    public PropostaDeInvalidacao(Question question, Professor professor, String justificativa, String proposta) {
        this.question = question;
        this.professor = professor;
        this.justificativa = justificativa;
        this.proposta = proposta;
        this.status = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getModerador() {
        return moderador;
    }

    public void setModerador(Professor moderador) {
        this.moderador = moderador;
    }

    public Date getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(Date dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropostaDeInvalidacao that = (PropostaDeInvalidacao) o;
        return Objects.equals(getQuestion(), that.getQuestion()) &&
                Objects.equals(getProfessor(), that.getProfessor()) &&
                Objects.equals(getModerador(), that.getModerador()) &&
                Objects.equals(getDataPostagem(), that.getDataPostagem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion(), getProfessor(), getModerador(), getDataPostagem());
    }

    @Override
    public String toString() {
        return "PropostaDeInvalidacao{" +
                "question=" + question +
                ", professor=" + professor +
                ", moderador=" + moderador +
                ", dataAnalise=" + dataAnalise +
                ", dataPostagem=" + dataPostagem +
                ", status=" + status +
                ", justificativa='" + justificativa + '\'' +
                ", proposta='" + proposta + '\'' +
                '}';
    }
}
