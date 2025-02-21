package dev.Zerphyis.planinha.controllers;

import dev.Zerphyis.planinha.entity.login.DataLogin;
import dev.Zerphyis.planinha.entity.login.Login;
import dev.Zerphyis.planinha.entity.login.ResponseLogin;
import dev.Zerphyis.planinha.repositorys.RepositoryLogin;
import dev.Zerphyis.planinha.security.ServiceToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ControllerAuth {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RepositoryLogin repository;
    @Autowired
    private ServiceToken tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DataLogin data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.name(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken(data.name());

        return ResponseEntity.ok(new ResponseLogin(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid DataLogin data){
        if(this.repository.findByName(data.name()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Login newLogin = new Login(data.name(), encryptedPassword);

        this.repository.save(newLogin);

        return ResponseEntity.ok().build();
    }
}
