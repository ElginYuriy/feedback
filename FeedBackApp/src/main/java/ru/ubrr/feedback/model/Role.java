package ru.ubrr.feedback.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Class represents role of {@link User}
 * @author Yuriy Elgin
 * @version 1.0
 */

@Entity
@Table(name="roles")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleID;
    @Column(name = "role_name")
    private String roleName;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "userRoles")
    private Set<User> users;

    public Role() {
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


}
