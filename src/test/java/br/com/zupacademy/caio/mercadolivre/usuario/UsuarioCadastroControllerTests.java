package br.com.zupacademy.caio.mercadolivre.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UsuarioCadastroControllerTests {

	@Autowired
	UsuarioRepository usuarioRepository;

	@LocalServerPort
	private int port;

	@BeforeEach
	void setup() {
		usuarioRepository.deleteAll();
	}

	@Test
	@DisplayName("Deve cadastrar um novo usuário.")
	void cadastro() {
		var email = "teste1@email.com";
		var senha = "123456";
		TestRestTemplate client = new TestRestTemplate();
		HttpEntity<UsuarioRequest> request = new HttpEntity<>(new UsuarioRequest(email, senha));
		var result = client.exchange("http://localhost:"+port+"/api/usuarios", HttpMethod.POST, request, String.class);

		var usuario = usuarioRepository.findByEmail(email);

		Assertions.assertTrue(usuario.isPresent());
		Assertions.assertTrue(new BCryptPasswordEncoder().matches(senha, usuario.get().getPassword()));
		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
	}
}
