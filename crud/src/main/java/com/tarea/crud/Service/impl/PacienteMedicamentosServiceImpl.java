package com.tarea.crud.Service.impl;

import com.tarea.crud.Domain.entities.PacienteMedicamentoEntity;
import com.tarea.crud.Repository.PacienteMedicamentosRepository;
import com.tarea.crud.Service.PacienteMedicamentosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteMedicamentosServiceImpl implements PacienteMedicamentosService {
    private final PacienteMedicamentosRepository pacienteMedicamentosRepository;

    public PacienteMedicamentosServiceImpl(PacienteMedicamentosRepository pacienteMedicamentoRepository) {
        this.pacienteMedicamentosRepository = pacienteMedicamentoRepository;
    }

    @Override
    public PacienteMedicamentoEntity createPacienteMedicamento(PacienteMedicamentoEntity pacienteMedicamentoEntity) {
        return pacienteMedicamentosRepository.save(pacienteMedicamentoEntity);
    }

    @Override
    public List<PacienteMedicamentoEntity> getAllPacienteMedicamentos() {
        return (List<PacienteMedicamentoEntity>) pacienteMedicamentosRepository.findAll();
    }

    @Override
    public PacienteMedicamentoEntity getPacienteMedicamentoById(Long id) {
        return pacienteMedicamentosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación Paciente-Medicamento no encontrada"));
    }

    @Override
    public PacienteMedicamentoEntity updatePacienteMedicamento(Long id, PacienteMedicamentoEntity pacienteMedicamentoEntity) {
        PacienteMedicamentoEntity existingRelacion = getPacienteMedicamentoById(id);
        existingRelacion.setDosis(pacienteMedicamentoEntity.getDosis());
        existingRelacion.setFechaInicio(pacienteMedicamentoEntity.getFechaInicio());
        existingRelacion.setFechaFin(pacienteMedicamentoEntity.getFechaFin());
        existingRelacion.setObservaciones(pacienteMedicamentoEntity.getObservaciones());

        return pacienteMedicamentosRepository.save(existingRelacion);
    }

    @Override
    public void deletePacienteMedicamento(Long id) {
        pacienteMedicamentosRepository.deleteById(id);
    }

    @Override
    public List<PacienteMedicamentoEntity> obtenerMedicamentosPorPaciente(Long id) {
        return pacienteMedicamentosRepository.findByPacienteEntityId(id);
    }
}
