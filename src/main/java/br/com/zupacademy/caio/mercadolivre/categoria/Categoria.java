package br.com.zupacademy.caio.mercadolivre.categoria;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nome;
    @ManyToOne
    private Categoria principal;

    public Categoria(String nome, Categoria principal) {
        this.nome = nome;
        this.principal = principal;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {

    }
}
