package dio.web_api.controller;

import dio.web_api.model.Usuario;
import dio.web_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public List<Usuario>getUsuarios(){
        return usuarioRepository.listAll();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return usuarioRepository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        usuarioRepository.remove(id);
    }

    @PostMapping()
    public void postUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }

    @PutMapping
    public void putUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
