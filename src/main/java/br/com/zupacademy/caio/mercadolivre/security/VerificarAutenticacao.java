package br.com.zupacademy.caio.mercadolivre.security;

import br.com.zupacademy.caio.mercadolivre.usuario.Usuario;
import br.com.zupacademy.caio.mercadolivre.usuario.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class VerificarAutenticacao implements UserDetailsService {

    UsuarioRepository usuarioRepository;

    VerificarAutenticacao(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = usuarioRepository.findByEmail(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Usuario não encontrado");
    }
}
