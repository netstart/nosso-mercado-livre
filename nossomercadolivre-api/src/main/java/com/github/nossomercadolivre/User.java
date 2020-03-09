package com.github.nossomercadolivre;

import com.github.nossomercadolivre.exception.InvalidPasswordException;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @CreatedDate
    @NotNull
    @Column(updatable = false, nullable = false)
    private Instant createdDate = Instant.now();

    @NotNull
    @NotEmpty
    @Email
    @Size(min = 5, max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String login;

    /**
     * Password encrypted
     */
    @NotEmpty
    @NotNull
    @Size(min = 6, max = 200)
    @Column(nullable = false, length = 200)
    private String password;

    @Deprecated
    /**
     * Just to frameworks
     */
    private User() {
    }

    public User(Instant createdDate, String login, String password) {
        this.createdDate = createdDate;
        this.login = login;
        this.password(password);
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    @Deprecated
    /**
     * This atribute can't be modified
     */
    private void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    protected void setPassword(@NotEmpty @NotNull @Min(6) String password) {
        this.password = password;
    }

    public User changePassword(String newClearPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (!passwordEncoder.matches(newClearPassword, this.getPassword())) {
            throw new InvalidPasswordException();
        }

        this.password(passwordEncoder, newClearPassword);

        return this;
    }

    public User password(String newClearPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return password(passwordEncoder, newClearPassword);
    }

    public User password(BCryptPasswordEncoder passwordEncoder, String newClearPassword) {
        this.setPassword(passwordEncoder.encode(newClearPassword));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, login, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
