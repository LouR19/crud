package com.tarea.crud.Mappers.Impl;

import com.tarea.crud.Domain.DTO.PacienteMedicamentosDto;
import com.tarea.crud.Domain.entities.PacienteMedicamentoEntity;
import com.tarea.crud.Mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PacienteMedicamentosMapper implements Mapper<PacienteMedicamentoEntity, PacienteMedicamentosDto> {
    private final ModelMapper modelMapper;

    public PacienteMedicamentosMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PacienteMedicamentosDto mapTo(PacienteMedicamentoEntity pacienteMedicamentoEntity) {
        return modelMapper.map(pacienteMedicamentoEntity, PacienteMedicamentosDto.class);
    }

    @Override
    public PacienteMedicamentoEntity mapFrom(PacienteMedicamentosDto pacienteMedicamentosDto) {
        return modelMapper.map(pacienteMedicamentosDto, PacienteMedicamentoEntity.class);
    }
}
