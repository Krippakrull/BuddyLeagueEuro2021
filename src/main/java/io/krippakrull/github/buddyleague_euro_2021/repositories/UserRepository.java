package io.krippakrull.github.buddyleague_euro_2021.repositories;

import io.krippakrull.github.buddyleague_euro_2021.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
