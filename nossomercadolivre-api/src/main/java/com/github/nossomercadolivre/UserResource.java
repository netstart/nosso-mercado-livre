package com.github.nossomercadolivre;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
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
    public ResponseEntity<UserDTO> createCategory(@Valid @RequestBody UserDTO userDTO) throws URISyntaxException {
        UserDTO userSaved = userService.save(userDTO);
        return ok(userSaved);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> page = userService.findAll();
        return ok(page);
    }
}


