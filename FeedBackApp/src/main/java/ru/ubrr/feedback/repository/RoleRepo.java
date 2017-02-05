package ru.ubrr.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ubrr.feedback.model.Role;

/**
 * @author Yuriy Elgin
 * @version 1.0.
 */
public interface RoleRepo extends JpaRepository<Role, Long> {
}
