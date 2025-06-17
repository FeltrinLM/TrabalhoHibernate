package model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Estampa {

    @Id
    private String id_estampa;
    private String nome;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_colecao")
    private Colecao colecao;

    @ManyToMany
    @JoinTable(
            name = "EstampaPeca",
            joinColumns = @JoinColumn(name = "id_estampa"),
            inverseJoinColumns = @JoinColumn(name = "peca_id")
    )
    private List<Peca> pecas = new ArrayList<>();

    // Getters e setters
    public String getId_estampa() {
        return id_estampa;
    }

    public void setId_estampa(String id_estampa) {
        this.id_estampa = id_estampa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }
}
