package les.ifoot.services;

// import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.ReservaIndividual;
import les.ifoot.repositories.ReservaIndividualRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class ReservaIndividualService {
    @Autowired
    private ReservaIndividualRepository repository;

    public ReservaIndividual findById(Integer id) {
        try {
            ReservaIndividual obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + ReservaIndividual.class.getName());
        }
    }

    public Collection<ReservaIndividual> findAll() {
        return repository.findAll();
    }

    public ReservaIndividual insert(ReservaIndividual obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da ReservaIndividual não foi(foram) preenchido(s)");
        }
    }

    public ReservaIndividual update(ReservaIndividual obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da ReservaIndividual não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma ReservaIndividual vinculada a Itens de Empréstimos!");
        }
    }

}
