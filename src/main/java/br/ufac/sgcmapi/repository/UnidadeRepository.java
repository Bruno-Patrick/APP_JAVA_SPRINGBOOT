package br.ufac.sgcmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Long>{

    @Query("SELECT u FROM Unidade u" +
    " WHERE endereco LIKE %?1%" +
    " OR nome LIKE %?1%")

    List<Unidade> findByAll(String termoBusca);
    
}
