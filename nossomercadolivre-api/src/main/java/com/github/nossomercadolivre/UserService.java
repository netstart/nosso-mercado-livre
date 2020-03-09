package com.github.nossomercadolivre;

import static com.github.nossomercadolivre.UserDTO.toDTO;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserDTO userDTO) {
        User userNew = new User(userDTO.getEmail(), userDTO.getPassword());
        User userSaved = userRepository.save(userNew);
        return toDTO(userSaved);
    }

    public List<UserDTO> findAll() {
        return toDTO(this.userRepository.findAll());
    }
}
