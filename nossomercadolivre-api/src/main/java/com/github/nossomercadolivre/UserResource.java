package com.github.nossomercadolivre;

import static com.github.nossomercadolivre.UserDTO.toDTO;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserResource {


    private static UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity<UserDTO> createCategory(@Valid @RequestBody UserDTO userDTO) {
        User userNew = new User(userDTO.email, userDTO.password);
        User userSaved = userRepository.save(userNew);
        return ok(toDTO(userSaved));
    }
}
