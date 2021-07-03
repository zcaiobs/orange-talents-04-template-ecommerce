package br.com.zupacademy.caio.mercadolivre.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoRequest {
    @NotBlank
    @JsonProperty
    private String nome;
    @Positive
    @JsonProperty
    private BigDecimal valor;
    @Min(value = 0)
    @JsonProperty
    private Integer quantidadeDisponivel;
    @NotNull
    @JsonProperty
    private List<CaracteristicasRequest> caracteristicas;
    @NotBlank @Length(max = 1000)
    @JsonProperty
    private String descricao;
    @NotNull
    @JsonProperty
    private Long categoriaId;
    @JsonProperty
    private final LocalDateTime criadoEm = LocalDateTime.now();

    public Produto toProduto() {
        var caracteristicas = this.caracteristicas.stream()
                .map(CaracteristicasRequest::toCaracteristica)
                .collect(Collectors.toList());

        return new Produto(this.nome, this.valor, this.quantidadeDisponivel, caracteristicas,
                this.descricao, this.categoriaId, this.criadoEm);
    }


}
