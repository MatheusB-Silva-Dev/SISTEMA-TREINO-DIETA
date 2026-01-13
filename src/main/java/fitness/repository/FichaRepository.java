package fitness.repository;

import fitness.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository <Ficha, Long> {
}
