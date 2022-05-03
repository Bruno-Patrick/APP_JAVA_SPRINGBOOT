package br.ufac.sgcmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    @Query("SELECT pa FROM Paciente pa" +
    " WHERE cep LIKE %?1%" +
    " OR cidade LIKE %?1%" +
    " OR data_nascimento LIKE %?1%" +
    " OR email LIKE %?1%" +
    " OR endereco LIKE %?1%" +
    " OR estado LIKE %?1%" +
    " OR grupo_sanguineo LIKE %?1%" +
    " OR nome LIKE %?1%" +
    " OR sexo LIKE %?1%" +
    " OR telefone LIKE %?1%")

    List<Paciente> findByAll(String termoBusca);
    
}
