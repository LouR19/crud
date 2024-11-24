package com.tarea.crud.Service;

import com.tarea.crud.Domain.entities.PacienteMedicamentoEntity;

import java.util.List;

public interface PacienteMedicamentosService {
    PacienteMedicamentoEntity createPacienteMedicamento(PacienteMedicamentoEntity pacienteMedicamentoEntity);
    List<PacienteMedicamentoEntity> getAllPacienteMedicamentos();
    PacienteMedicamentoEntity getPacienteMedicamentoById(Long id);
    PacienteMedicamentoEntity updatePacienteMedicamento(Long id, PacienteMedicamentoEntity pacienteMedicamentoEntity);
    void deletePacienteMedicamento(Long id);
    List<PacienteMedicamentoEntity> obtenerMedicamentosPorPaciente(Long ID);
}
