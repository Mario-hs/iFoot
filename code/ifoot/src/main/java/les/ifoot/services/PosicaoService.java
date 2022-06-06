package les.ifoot.services;

import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.ifoot.model.Posicao;
import les.ifoot.repositories.PosicaoRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class PosicaoService {
    // @Autowired
    // private PosicaoRepository repository;

    // public Posicao findById(Integer id) {
    // return repository.findById(id).get();
    // }

    // public List<Posicao> findAll() {
    // return repository.findAll();
    // }

    // public Posicao insert(Posicao obj) {
    // return repository.save(obj);
    // }

    // public Posicao update(Posicao obj) {
    // findById(obj.getId());
    // return repository.save(obj);
    // }

    // public void delete(Integer id) {
    // findById(id);
    // repository.deleteById(id);
    // }

    @Autowired
    private PosicaoRepository repository;

    public Posicao findById(final Integer id) {
        try {
            Posicao obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Posicao.class.getName());
        }
    }

    public Collection<Posicao> findAll() {
        return repository.findAll();
    }

    public Posicao insert(final Posicao obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Posicao não foi(foram) preenchido(s)");
        }
    }

    public Posicao update(final Posicao obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Posicao não foi(foram) preenchido(s)");
        }
    }

    public void delete(final Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir uma posicao com um jogador cadastrado com essa posição!");
        }
    }

}
