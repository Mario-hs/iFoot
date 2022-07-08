package les.ifoot.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import les.ifoot.model.TransferenciaDinheiroEspaco;
import les.ifoot.services.TransferenciaDinheiroEspacoService;
import les.ifoot.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/transferencias_de_dinheiro_espaco")
public class TransferenciaDinheiroEspacoController {
    @Autowired
    private TransferenciaDinheiroEspacoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<TransferenciaDinheiroEspaco>> findAll() {
        Collection<TransferenciaDinheiroEspaco> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TransferenciaDinheiroEspaco> find(@PathVariable Integer id) {
        TransferenciaDinheiroEspaco obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TransferenciaDinheiroEspaco> insert(@Valid @RequestBody TransferenciaDinheiroEspaco obj,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TransferenciaDinheiroEspaco> update(@Valid @RequestBody TransferenciaDinheiroEspaco obj,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
