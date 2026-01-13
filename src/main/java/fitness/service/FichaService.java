package fitness.service;

import fitness.model.Ficha;
import fitness.repository.FichaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaService {
    private final FichaRepository fichaRepository;

    public FichaService(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }

    public Ficha criarFicha (Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    public List<Ficha> listarFichas () {
        return fichaRepository.findAll();
    }

    public Ficha atualizarFicha (Long id, Ficha fichaAtualizada) {
        return fichaRepository.findById(id)

                .map(ficha -> {
                    ficha.setNomeFicha(fichaAtualizada.getNomeFicha());
                    ficha.setDescricaoFicha(fichaAtualizada.getDescricaoFicha());
                    ficha.setAluno(fichaAtualizada.getAluno()); // verificar se e preciso atualizar esse campo, pois provavelmente uma ficha sempre estara vinculado a um aluno pelos seus respectivos id ou uma mesma ficha pode pertence a varios alunos.
                    ficha.setProfessor(fichaAtualizada.getProfessor()); // verificar se um professor pode ser atribuido como co-criador da ficha e um outro professor ser listado como um editor daquela ficha.
                    ficha.setDataCriacao(fichaAtualizada.getDataCriacao()); // verificar se esse campo e necessario ser atualizado, ou simplesmente atualizar com ultima atualização.

                    return fichaRepository.save(ficha);
                })

                .orElseThrow(()-> new RuntimeException ("Ficha não encontrada para o ID: " + id));
    }

    public void deletarFicha(Long id) {
        fichaRepository.deleteById(id);
    }
}
