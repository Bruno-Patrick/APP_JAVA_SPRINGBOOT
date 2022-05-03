package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Convenio;
import br.ufac.sgcmapi.model.EStatusConvenio;
import br.ufac.sgcmapi.repository.ConvenioRepository;

@Service
public class ConvenioService implements ICrudService<Convenio>{

    private final ConvenioRepository repo;

    @Autowired
    public ConvenioService(ConvenioRepository repo){
        this.repo = repo;
    }

    @Override
    public List<Convenio> getAll() {
        List<Convenio> registros = repo.findAll();
        return registros;
    }

    @Override
    public Convenio getById(Long id) {
        Convenio registro = repo.findById(id).orElse(null);
        return registro;
    }

    @Override
    public List<Convenio> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public Convenio save(Convenio objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        Convenio registro = repo.getById(id);
        registro.setStatus(EStatusConvenio.ENCERRADO);
        repo.save(registro);
    }
    
}
