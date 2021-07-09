package com.example.Doc.Dog;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="dog")
@Data
public class DogModel {
    @Id
     @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    private String nome;
    private String origem;
    private Integer idade;

    public DogModel() {
    }

    public DogModel(Long id, String nome, String origem, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.origem = origem;
        this.idade = idade;
    }

    public DogModel(String nome, String origem, Integer idade) {
        this.nome = nome;
        this.origem = origem;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
