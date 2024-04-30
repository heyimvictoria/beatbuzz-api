package org.launchcode.repository;

import java.util.Optional;

import org.launchcode.models.ERole;
import org.launchcode.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
