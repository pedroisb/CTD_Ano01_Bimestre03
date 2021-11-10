package model;

import java.sql.Date;
import java.time.LocalDate;

public class Dentista {

    private Integer id; //Primary Key
    private String matricula;
    private String nome;
    private String sobrenome;


    //construtora sem id
    public Dentista(String matricula, String nome, String sobrenome) {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    //construtora com id
    public Dentista(Integer id, String matricula, String nome, String sobrenome) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    //getters, setters e toString
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }
}
