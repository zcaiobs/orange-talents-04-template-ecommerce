package br.com.zupacademy.caio.mercadolivre.usuario;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import javax.validation.constraints.NotBlank;

public class UsuarioAuthRequest {
    @NotBlank
    private final String email;
    @NotBlank
    private final String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public UsuarioAuthRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(this.email, this.senha);
    }
}
