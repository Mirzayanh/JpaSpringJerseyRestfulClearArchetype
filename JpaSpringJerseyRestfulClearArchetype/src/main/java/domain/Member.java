package domain;

import javax.persistence.*;

/**
 * Created by heno on 7/30/16.
 */
@Entity
@Table(name = "member", catalog = "bib", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Member {
    //private static final long serialVersionUID = 3394395703589149580L;

    private Integer id;
    private Role role;
    private String name;
    private String username;
    private String password;
    private byte status;

    public Member() {
    }

    public Member(Role role, String name, String username, String password,
                  byte status) {
        this.role = role;
        this.name = name;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "username", unique = true, nullable = false, length = 45)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return this.status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

}
