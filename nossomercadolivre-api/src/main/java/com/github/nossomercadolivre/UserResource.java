package com.github.nossomercadolivre;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserDTO> createCategory(@Valid @RequestBody UserDTO userDTO) {
        return ok(userService.save(userDTO));
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAll() {
        return ok(userService.findAll());
    }
}


