package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.EStatusPaciente;
import br.ufac.sgcmapi.model.Paciente;
import br.ufac.sgcmapi.repository.PacienteRepository;

@Service
public class PacienteService implements ICrudService<Paciente>{

    private final PacienteRepository repo;

    @Autowired
    public PacienteService(PacienteRepository repo){
        this.repo = repo;
    }

    @Override
    public List<Paciente> getAll() {
        List<Paciente> registros = repo.findAll();
        return registros;
    }

    @Override
    public Paciente getById(Long id) {
        Paciente registro = repo.findById(id).orElse(null);
        return registro;
    }

    @Override
    public List<Paciente> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public Paciente save(Paciente objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        Paciente registro = repo.getById(id);
        registro.setStatus(EStatusPaciente.NAOSEI);
        repo.save(registro);
    }
    
}
