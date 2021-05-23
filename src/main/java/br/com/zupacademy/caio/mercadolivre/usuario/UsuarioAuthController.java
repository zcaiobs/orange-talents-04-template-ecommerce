package br.com.zupacademy.caio.mercadolivre.usuario;

import br.com.zupacademy.caio.mercadolivre.security.TokenJwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UsuarioAuthController {

    Logger log = LoggerFactory.getLogger(UsuarioAuthController.class);

    AuthenticationManager authenticationManager;
    TokenJwt tokenJwt;

    UsuarioAuthController(AuthenticationManager authenticationManager, TokenJwt tokenJwt) {
        this.authenticationManager = authenticationManager;
        this.tokenJwt = tokenJwt;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody @Valid UsuarioAuthRequest usuarioAuthRequest) {
        UsernamePasswordAuthenticationToken uat = usuarioAuthRequest.converter();
        try {
            var authentication = authenticationManager.authenticate(uat);
            var token = tokenJwt.gerarToken(authentication);
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException ex) {
            log.error(ex.getMessage(), ex.getCause());
        }
        return ResponseEntity.badRequest().build();
    }
}
