package dio.web_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Bem-vindo a minha API Web Spring boot";
    }

    @GetMapping("/users")
    public String users(){
        return "Authorized User";
    }

    @GetMapping("/managers")
    public String managers(){
        return "Authorized manager";
    }
}
