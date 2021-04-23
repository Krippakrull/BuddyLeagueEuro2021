package io.krippakrull.github.buddyleague_euro_2021.repositories;

import io.krippakrull.github.buddyleague_euro_2021.models.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {
}
