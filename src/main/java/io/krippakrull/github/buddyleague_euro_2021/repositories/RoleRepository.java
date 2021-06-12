package io.krippakrull.github.buddyleague_euro_2021.repositories;

import io.krippakrull.github.buddyleague_euro_2021.models.ERole;
import io.krippakrull.github.buddyleague_euro_2021.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
