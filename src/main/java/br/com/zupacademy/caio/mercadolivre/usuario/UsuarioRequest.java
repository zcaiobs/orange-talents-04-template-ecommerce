package br.com.zupacademy.caio.mercadolivre.usuario;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioRequest {
    @NotBlank @Email
    private final String login;
    @NotBlank @Length(min = 6)
    private final String senha;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public UsuarioRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario toUsuario() {
        return new Usuario(this.login, this.senha);
    }
}
