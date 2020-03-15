package com.github.nossomercadolivre;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.Instant;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(updatable = false, nullable = false)
    private Instant createdDate;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    /**
     * Password encrypted
     */
    @NotBlank
    @Size(min = 6, max = 200)
    @Column(nullable = false, length = 200)
    private String password;

    /**
     * Just to frameworks
     */
    @Deprecated
    protected User() {
    }

    /**
     * @param email            email used to identify user
     * @param newClearPassword password without any encryption
     */
    public User(final String email, final String newClearPassword) {
        this.email = email;
        this.password(newClearPassword);
        this.createdDate = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    /**
     * @return encrypted password
     */
    public String getPassword() {
        return password;
    }

    private void setPassword(@NotEmpty @NotNull @Min(6) final String encryptedPassword) {
        this.password = encryptedPassword;
    }

    /**
     * @param newClearPassword without encoder or any encrypt
     * @return
     */
    private User password(final String newClearPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.setPassword(passwordEncoder.encode(newClearPassword));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", login='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
