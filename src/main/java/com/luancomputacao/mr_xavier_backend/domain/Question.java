package com.luancomputacao.mr_xavier_backend.domain;

import com.fasterxml.jackson.annotation.*;
import com.luancomputacao.mr_xavier_backend.domain.enums.TipoDeQuestao;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "question")
@EntityListeners(AuditingEntityListener.class)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

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

    @Column(name = "enunciado")
    private String enunciado;

    @Column(name = "espacos")
    private Integer espacos;

    @Column(name = "invalidada")
    private Boolean invalidada;

    @Column(name = "nivel")
    private Float nivel;

    @Column(name = "publica")
    private Boolean publica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor", referencedColumnName = "id", updatable = false, nullable = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonManagedReference
    private Professor autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id", updatable = false, nullable = false)
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Disciplina disciplina;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "id_fase_de_ensino", referencedColumnName = "id", updatable = false, nullable = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private FaseDeEnsino faseDeEnsino;

    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    @JsonProperty("opcoes")
    private Collection<OpcaoDeQuestao> opcoesDeQuestao;

    @OneToMany(mappedBy = "question")
    @JsonBackReference
    @JsonProperty("propostas-de-invalidacao")
    private Collection<PropostaDeInvalidacao> propostasDeInvalidacao;

    @OneToMany(mappedBy = "professor")
    @JsonBackReference
    private Collection<ProfessorUtilizaTeste> professorUtilizaTestes;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_de_question")
    private TipoDeQuestao tipoDeQuestaoEnum;

    @ManyToMany
    @JoinTable(
            name = "materia_de_question",
            joinColumns = {@JoinColumn(name = "question_id")},
            inverseJoinColumns = {@JoinColumn(name = "materia_id")}
    )
    @JsonManagedReference
    private Collection<Materia> materias;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "questoes")
    @JsonBackReference("questoes")
    private Collection<Teste> testes;

    public Question() {

    }

    public Question(
            Professor autor,
            Boolean publica,
            FaseDeEnsino faseDeEnsino,
            Disciplina disciplina,
            Collection<Materia> materias,
            TipoDeQuestao tipoDeQuestaoEnum,
            Float nivel,
            String enunciado) {
        this.autor = autor;
        this.publica = publica;
        this.faseDeEnsino = faseDeEnsino;
        this.disciplina = disciplina;
        this.materias = materias;
        this.tipoDeQuestaoEnum = tipoDeQuestaoEnum;
        this.enunciado = enunciado;
        this.nivel = nivel;
        this.invalidada = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Professor getAutor() {
        return autor;
    }

    public void setAutor(Professor autor) {
        this.autor = autor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Integer getEspacos() {
        return espacos;
    }

    public void setEspacos(Integer espacos) {
        this.espacos = espacos;
    }

    public FaseDeEnsino getFaseDeEnsino() {
        return faseDeEnsino;
    }

    public void setFaseDeEnsino(FaseDeEnsino faseDeEnsino) {
        this.faseDeEnsino = faseDeEnsino;
    }

    public Boolean getInvalidada() {
        return invalidada;
    }

    public void setInvalidada(Boolean invalidada) {
        this.invalidada = invalidada;
    }

    public Collection<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Collection<Materia> materias) {
        this.materias = materias;
    }

    public Float getNivel() {
        return nivel;
    }

    public void setNivel(Float nivel) {
        this.nivel = nivel;
    }

    public Collection<OpcaoDeQuestao> getOpcoesDeQuestao() {
        return opcoesDeQuestao;
    }

    public void setOpcoesDeQuestao(Collection<OpcaoDeQuestao> opcoesDeQuestao) {
        this.opcoesDeQuestao = opcoesDeQuestao;
    }

    public Boolean getPublica() {
        return publica;
    }

    public void setPublica(Boolean publica) {
        this.publica = publica;
    }

    public Enum<TipoDeQuestao> getTipoDeQuestaoEnum() {
        return tipoDeQuestaoEnum;
    }

    public void setTipoDeQuestaoEnum(TipoDeQuestao tipoDeQuestaoEnum) {
        this.tipoDeQuestaoEnum = tipoDeQuestaoEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(getCriadoEm(), question.getCriadoEm()) &&
                Objects.equals(getAutor(), question.getAutor()) &&
                Objects.equals(getDisciplina(), question.getDisciplina()) &&
                Objects.equals(getFaseDeEnsino(), question.getFaseDeEnsino()) &&
                Objects.equals(getPublica(), question.getPublica());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCriadoEm(), getAutor(), getDisciplina(), getFaseDeEnsino(), getPublica());
    }


    @Override
    public String toString() {
        return "Questao{" +
                "criadoEm=" + criadoEm +
                ", atualizadoEm=" + atualizadoEm +
                ", autor=" + autor +
                ", disciplina=" + disciplina +
                ", enunciado='" + enunciado + '\'' +
                ", espacos=" + espacos +
                ", faseDeEnsino=" + faseDeEnsino +
                ", invalidada=" + invalidada +
                ", materias=" + materias +
                ", nivel=" + nivel +
                ", opcoesDeQuestao=" + opcoesDeQuestao +
                ", publica=" + publica +
                ", tipoDeQuestaoEnum=" + tipoDeQuestaoEnum +
                '}';
    }
}
