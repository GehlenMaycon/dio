package dio.web_api_JWT.service;

import dio.web_api_JWT.model.Usuario;
import dio.web_api_JWT.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void criarUsuario(Usuario usuario){
        String pass = usuario.getPassword();
        usuario.setPassword(encoder.encode(pass));
        usuarioRepository.save(usuario);
    }

}
