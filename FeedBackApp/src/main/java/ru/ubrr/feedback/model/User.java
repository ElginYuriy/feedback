package ru.ubrr.feedback.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Class represents user objects
 *
 * @author Yuriy Elgin
 * @version 1.0.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    @Column(name = "user_name", length = 20)
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Transient
    private String confirmUserPassword;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "create_date")
    private Date creationDate;
    @Column(name = "last_visit")
    private Date lastVisitDate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_map", joinColumns = @JoinColumn(name = "user_id"),
                                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> userRoles;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "themeAuthor")
    private Set<Theme> themes;

    public User() {
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getConfirmUserPassword() {
        return confirmUserPassword;
    }

    public void setConfirmUserPassword(String confirmUserPassword) {
        this.confirmUserPassword = confirmUserPassword;
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
