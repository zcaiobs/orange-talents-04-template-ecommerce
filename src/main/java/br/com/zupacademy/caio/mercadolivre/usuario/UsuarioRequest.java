package br.com.zupacademy.caio.mercadolivre.usuario;

import br.com.zupacademy.caio.mercadolivre.validator.UniqueValue;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioRequest {
    @NotBlank @Email @UniqueValue(domainClass = Usuario.class, fieldName = "email")
    private final String email;
    @NotBlank @Length(min = 6)
    private final String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public UsuarioRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario toUsuario() {
        return new Usuario(this.email, this.senha);
    }
}
