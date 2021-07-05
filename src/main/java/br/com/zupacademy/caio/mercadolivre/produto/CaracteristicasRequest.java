package br.com.zupacademy.caio.mercadolivre.produto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CaracteristicasRequest {
    @JsonProperty
    @NotBlank
    private String nome;
    @JsonProperty
    @NotBlank
    private String descricao;

    public CaracteristicasRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Caracteristicas toCaracteristica() {
        return new Caracteristicas(this.nome, this.descricao);
    }
}
