package com.br.cars.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TB_CARS")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int ano;
    @Column(nullable = false)
    private double valorTabelaFipe;

    public CarModel() {
    }

    public CarModel(String nome, int ano, double valorTabelaFipe) {
        this.nome = nome;
        this.ano = ano;
        this.valorTabelaFipe = valorTabelaFipe;
    }

    @JsonIgnore
    public UUID getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public double getValorTabelaFipe() {
        return valorTabelaFipe;
    }
}
