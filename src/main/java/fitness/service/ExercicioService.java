package fitness.service;

import fitness.model.Exercicio;
import fitness.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {
    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public Exercicio criarExercicio (Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public List<Exercicio> listarExercicio () {
        return exercicioRepository.findAll();
    }

    public Exercicio atualizarExercicio (Long id, Exercicio exercicioAtualizado) {
        return exercicioRepository.findById(id)
                .map(exercicio -> {
                    exercicio.setNome(exercicioAtualizado.getNome());
                    exercicio.setDescricao(exercicioAtualizado.getDescricao());
                    exercicio.setFicha(exercicioAtualizado.getFicha()); // verificar se e necessario esse tipo de atualização, pois o exercicio em questão ja estara vinculado a uma ficha atraves do id, na minha cabeça ele ja vai aparecer atualizado automaticamente em todas as fichas.

                    return exercicioRepository.save(exercicio);
                })

                .orElseThrow(() -> new RuntimeException("Exercicio não encontrada com o ID: " + id));
    }

    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }
}
