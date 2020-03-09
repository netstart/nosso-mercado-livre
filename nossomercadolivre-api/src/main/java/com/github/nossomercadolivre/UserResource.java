package com.github.nossomercadolivre;

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

	private final UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@PostMapping()
	public ResponseEntity<UserDTO> createCategory(@Valid @RequestBody UserDTO userDTO) {
		UserDTO userSaved = userService.save(userDTO);
		return ok(userSaved);
	}

	@GetMapping()
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> page = userService.findAll();
		return ok(page);
	}
}
