package br.com.zupacademy.caio.mercadolivre.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Caracteristicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    public Caracteristicas(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Caracteristicas() {
    }
}
