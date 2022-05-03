package br.ufac.sgcmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.Convenio;

public interface ConvenioRepository extends JpaRepository<Convenio, Long>{

    @Query("SELECT c FROM Convenio c" +
    " WHERE ativo LIKE %?1%" +
    " OR cnpj LIKE %?1%" +
    " OR email LIKE %?1%" +
    " OR nome LIKE %?1%" +
    " OR razao_social LIKE %?1%" +
    " OR representante LIKE %?1%" +
    " OR telefone LIKE %?1%")

    List<Convenio> findByAll(String termoBusca);
    
}
