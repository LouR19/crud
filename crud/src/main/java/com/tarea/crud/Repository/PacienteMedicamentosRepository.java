package com.tarea.crud.Repository;

import com.tarea.crud.Domain.entities.PacienteMedicamentoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteMedicamentosRepository extends CrudRepository<PacienteMedicamentoEntity, Long> {
    List<PacienteMedicamentoEntity> findByPacienteEntityId(Long id);
}