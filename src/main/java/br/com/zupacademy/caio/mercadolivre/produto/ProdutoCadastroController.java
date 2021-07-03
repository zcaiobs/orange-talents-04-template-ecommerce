package br.com.zupacademy.caio.mercadolivre.produto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProdutoCadastroController {

    final private ProdutoRepository produtoRepository;

    ProdutoCadastroController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping(value = "/produtos", consumes = "application/json")
    public ResponseEntity<?> cadastrar(@Valid @RequestBody ProdutoRequest produtoRequest, UriComponentsBuilder uri) {
        var result = produtoRepository.save(produtoRequest.toProduto());
        var isUri = uri.path("/api/produtos/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(isUri).build();
    }
}
