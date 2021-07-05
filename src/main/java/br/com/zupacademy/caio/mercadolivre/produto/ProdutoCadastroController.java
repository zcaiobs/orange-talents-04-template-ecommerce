package br.com.zupacademy.caio.mercadolivre.produto;

import br.com.zupacademy.caio.mercadolivre.security.TokenJwt;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ProdutoCadastroController {

    final private ProdutoRepository produtoRepository;

    ProdutoCadastroController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping(value = "/produtos", consumes = "application/json")
    public ResponseEntity<?> cadastrar(@Valid @RequestBody ProdutoRequest produtoRequest,
                                       UriComponentsBuilder uri,
                                       @RequestHeader("Authorization") String token,
                                       TokenJwt tokenJwt
                                       ) {
        var user = tokenJwt.getIdUsuario(token.substring(7, token.length()));
        System.out.println(user);
        var result = produtoRepository.save(produtoRequest.toProduto());
        var isUri = uri.path("/api/produtos/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(isUri).build();
    }
}
