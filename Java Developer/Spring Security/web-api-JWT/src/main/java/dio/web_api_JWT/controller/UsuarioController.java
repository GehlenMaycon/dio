package dio.web_api_JWT.controller;

import dio.web_api_JWT.model.Usuario;
import dio.web_api_JWT.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public void postUsuario(@RequestBody Usuario usuario){
        usuarioService.criarUsuario(usuario);
    }
}
