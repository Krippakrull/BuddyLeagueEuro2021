package io.krippakrull.github.buddyleague_euro_2021.repositories;

import io.krippakrull.github.buddyleague_euro_2021.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
