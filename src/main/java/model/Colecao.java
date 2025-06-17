package model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Colecao {

    @Id
    private String id_colecao;
    private String nome;
    private Date data_inicio;
    private Date data_fim;

    @OneToMany(mappedBy = "colecao", cascade = CascadeType.ALL)
    private List<Estampa> estampas = new ArrayList<>();

    // Getters e setters
    public String getId_colecao() {
        return id_colecao;
    }

    public void setId_colecao(String id_colecao) {
        this.id_colecao = id_colecao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public List<Estampa> getEstampas() {
        return estampas;
    }

    public void setEstampas(List<Estampa> estampas) {
        this.estampas = estampas;
    }
}
