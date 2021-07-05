package br.com.zupacademy.caio.mercadolivre.produto;

import br.com.zupacademy.caio.mercadolivre.usuario.Usuario;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "produto_tb")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column(nullable = false)
    private Integer quantidadeDisponivel;
    @OneToMany(cascade = CascadeType.PERSIST)
    @Column(nullable = false)
    private List<Caracteristicas> caracteristicas;
    @Column(nullable = false, length = 1000)
    private String descricao;
    @Column(nullable = false)
    private Long categoriaId;
    @Column(nullable = false)
    private LocalDateTime criadoEm;

    public Produto(String nome, BigDecimal valor, Integer quantidadeDisponivel,
                   List<Caracteristicas> caracteristicas, String descricao,
                   Long categoriaId, LocalDateTime criadoEm) {
        this.nome = nome;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.caracteristicas = caracteristicas;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
        this.criadoEm = criadoEm;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }
}
