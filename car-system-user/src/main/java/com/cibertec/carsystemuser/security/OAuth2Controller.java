package com.cibertec.carsystemuser.security;

import com.cibertec.carsystemuser.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository usuarioRepository;

    @GetMapping("/loginSuccess")
    public String loginSuccess(OAuth2AuthenticationToken token) {
        String email = token.getPrincipal().getAttribute("email");
        String name = token.getPrincipal().getAttribute("name");

        // Registro o autenticación del usuario
        userService.registerOrLoginOAuthUser(email, name);

        // Generar y devolver el JWT
        String jwtToken = userService.generateToken(email);

        return "Login successful. JWT Token: " + jwtToken;
    }

    @GetMapping("/logout")
    public String logout() {
        return "Logout successful.";
    }

    @GetMapping("getAll")
    public ResponseEntity<Object> getAllUsuarios(){
        return ResponseEntity.ok(this.usuarioRepository.findAll());
    }

}
