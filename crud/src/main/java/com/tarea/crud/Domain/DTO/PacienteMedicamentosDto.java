package com.tarea.crud.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacienteMedicamentosDto {
    private Long id;
    private Long ID;
    private Long medicamentoId;
    private String dosis;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String observaciones;
}
