package fitness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nomeFicha;
    private String descricaoFicha;
    private Usuario aluno;
    private Usuario professor;
    private LocalDate dataCriacao;

    protected Ficha() {}

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getNomeFicha () {
        return nomeFicha;
    }

    public void setNomeFicha (String nomeFicha) {
        this.nomeFicha = nomeFicha;
    }

    public String getDescricaoFicha () {
        return descricaoFicha;
    }

    public void setDescricaoFicha (String descricaoFicha) {
        this.descricaoFicha = descricaoFicha;
    }

    public Usuario getAluno () {
        return aluno;
    }

    public void setAluno (Usuario aluno) {
        this.aluno = aluno;
    }

    public Usuario getProfessor () {
        return professor;
    }

    public void setProfessor (Usuario professor) {
        this.professor = professor;
    }

    public LocalDate getDataCriacao () {
        return dataCriacao;
    }

    public void setDataCriacao (LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
