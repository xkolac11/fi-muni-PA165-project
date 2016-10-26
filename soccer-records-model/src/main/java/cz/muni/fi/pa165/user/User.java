package cz.muni.fi.pa165.user;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author Filip Prochazka <filip@prochazka.su>
 */
@Entity
@Table(name = "users")
public class User
{

    @Id
    @Column(nullable = false)
    @Type(type="uuid-char")
    @NotNull
    private UUID id;

    @Column(nullable = false)
    @NotNull
    private String passwordHash;

    @Column(nullable = false, unique = true)
    @NotNull
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private UserRole role;

    public User(String email, String passwordHash)
    {
        this.id = UUID.randomUUID();
        this.role = UserRole.USER;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    /**
     * @deprecated Hibernate internal
     */
    public User()
    {
    }

    public UUID getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public UserRole getRole()
    {
        return role;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

}