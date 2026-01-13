package fitness.repository;

import fitness.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository <Exercicio, Long> {
}
