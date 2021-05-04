package br.com.zupacademy.caio.mercadolivre.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CategoriaCadastroController {

    CategoriaRepository categoriaRepository;

    CategoriaCadastroController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping("/categorias")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        categoriaRepository.save(categoriaRequest.toCategoria(categoriaRepository));
        return ResponseEntity.ok().build();
    }
}
