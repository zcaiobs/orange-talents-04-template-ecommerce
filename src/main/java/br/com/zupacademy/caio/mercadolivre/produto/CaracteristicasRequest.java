package br.com.zupacademy.caio.mercadolivre.produto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaracteristicasRequest {
    @JsonProperty
    private String nome;
    @JsonProperty
    private String descricao;

    public CaracteristicasRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Caracteristicas toCaracteristica() {
        return new Caracteristicas(this.nome, this.descricao);
    }
}
