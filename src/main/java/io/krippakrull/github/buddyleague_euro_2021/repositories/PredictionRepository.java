package io.krippakrull.github.buddyleague_euro_2021.repositories;

import io.krippakrull.github.buddyleague_euro_2021.models.Game;
import io.krippakrull.github.buddyleague_euro_2021.models.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {
    List<Prediction> findByUserId(Long id);
}
