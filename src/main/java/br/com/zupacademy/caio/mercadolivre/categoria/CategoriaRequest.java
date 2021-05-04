package br.com.zupacademy.caio.mercadolivre.categoria;

import br.com.zupacademy.caio.mercadolivre.validator.ExistsValue;
import br.com.zupacademy.caio.mercadolivre.validator.UniqueValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CategoriaRequest {

    @NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private final String nome;
    @PositiveOrZero @ExistsValue(domainClass = Categoria.class, fieldName = "id")
    private final Long principalId;

    public String getNome() {
        return nome;
    }

    public Long getPrincipalId() {
        return principalId;
    }

    public CategoriaRequest(String nome, Long principalId) {
        this.nome = nome;
        this.principalId = principalId;
    }

    public Categoria toCategoria(CategoriaRepository categoriaRepository) {
        return categoriaRepository
                .findById(this.principalId)
                .map(categoria -> new Categoria(this.nome, categoria))
                .orElseGet(() -> new Categoria(this.nome));
    }
}
