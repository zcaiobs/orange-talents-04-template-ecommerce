package br.com.zupacademy.caio.mercadolivre.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UsuarioCadastroController {

    private final UsuarioRepository usuarioRepository;

    UsuarioCadastroController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> cadastro(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        usuarioRepository.save(usuarioRequest.toUsuario());
        return ResponseEntity.ok().build();
    }
}
