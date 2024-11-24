package com.tarea.crud.controller;

import com.tarea.crud.Domain.DTO.PacienteMedicamentosDto;
import com.tarea.crud.Domain.entities.PacienteMedicamentoEntity;
import com.tarea.crud.Mappers.Impl.PacienteMedicamentosMapper;
import com.tarea.crud.Service.impl.PacienteMedicamentosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes/paciente_medicamento")
public class PacienteMedicamentosController {
    private final PacienteMedicamentosServiceImpl pacienteMedicamentosService;
    private final PacienteMedicamentosMapper pacienteMedicamentosMapper;

    @Autowired
    public PacienteMedicamentosController(PacienteMedicamentosServiceImpl pacienteMedicamentosService, PacienteMedicamentosMapper pacienteMedicamentosMapper) {
        this.pacienteMedicamentosService = pacienteMedicamentosService;
        this.pacienteMedicamentosMapper = pacienteMedicamentosMapper;
    }

    @PostMapping
    public PacienteMedicamentosDto asignarMedicamentoPaciente(@RequestBody PacienteMedicamentosDto dto) {
        PacienteMedicamentoEntity entity = pacienteMedicamentosMapper.mapFrom(dto);
        PacienteMedicamentoEntity createdEntity = pacienteMedicamentosService.createPacienteMedicamento(entity);
        return pacienteMedicamentosMapper.mapTo(createdEntity);
    }

    @GetMapping
    public ResponseEntity<List<PacienteMedicamentosDto>> getAllPacienteMedicamentos() {
        List<PacienteMedicamentoEntity> entities = pacienteMedicamentosService.getAllPacienteMedicamentos();
        List<PacienteMedicamentosDto> dtos = entities.stream().map(pacienteMedicamentosMapper::mapTo).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/paciente/{ID}")
    public ResponseEntity<List<PacienteMedicamentosDto>> getMedicamentosPorPaciente(@PathVariable Long ID) {
        List<PacienteMedicamentoEntity> entities = pacienteMedicamentosService.obtenerMedicamentosPorPaciente(ID);
        List<PacienteMedicamentosDto> dtos = entities.stream().map(pacienteMedicamentosMapper::mapTo).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRelacion(@PathVariable Long id) {
        pacienteMedicamentosService.deletePacienteMedicamento(id);
        return ResponseEntity.noContent().build();
    }
}
