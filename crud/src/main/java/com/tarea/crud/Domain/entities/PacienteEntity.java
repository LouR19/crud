package com.tarea.crud.Domain.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaNac;
    private String diagnostico;
    private String telefono;
    private String email;
    @OneToMany(mappedBy = "pacienteEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CitasEntity> citas;
    @OneToMany(mappedBy = "pacienteEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PacienteMedicamentoEntity> pacienteMedicamentos;

}
