package com.github.nossomercadolivre;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static com.github.nossomercadolivre.UserDTO.toDTO;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserDTO userDTO) {
        User userNew = new User(Instant.now(), userDTO.getLogin(), userDTO.getPassword());
        return toDTO(userRepository.save(userNew));
    }

    public List<UserDTO> findAll() {
        return toDTO(this.userRepository.findAll());
    }
}
