package com.tarea.crud.Service.impl;

import com.tarea.crud.Domain.entities.CitasEntity;
import com.tarea.crud.Repository.CitasRepository;
import com.tarea.crud.Service.CitasService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasServiceImpl implements CitasService {
    private final CitasRepository citasRepository;

    public CitasServiceImpl(CitasRepository citasRepository) {
        this.citasRepository = citasRepository;
    }

    @Override
    public CitasEntity createCitas(CitasEntity citaEntity) {
        return citasRepository.save(citaEntity);
    }

    @Override
    public List<CitasEntity> getAllCitas() {
        return (List<CitasEntity>) citasRepository.findAll();
    }

    @Override
    public CitasEntity getCitaById(Long id) {
        return citasRepository.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    @Override
    public CitasEntity updateCitas(Long id, CitasEntity citaEntity) {
        CitasEntity existingCita = getCitaById(id);
        existingCita.setFecha(citaEntity.getFecha());
        existingCita.setHora(citaEntity.getHora());
        existingCita.setDescripcion(citaEntity.getDescripcion());
        return citasRepository.save(existingCita);
    }

    @Override
    public void deleteCitas(Long id) {
        citasRepository.deleteById(id);
    }
}
