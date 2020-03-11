package com.github.nossomercadolivre;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.github.nossomercadolivre.UserDTO.toDTO;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/user")
public class UserResource {


    private static UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity<UserDTO> createCategory(@Valid @RequestBody UserDTO userDTO) {
        User userSaved = userRepository.save(userDTO.toModel());
        return ok(toDTO(userSaved));
    }
}
