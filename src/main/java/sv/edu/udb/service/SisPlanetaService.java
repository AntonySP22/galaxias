package sv.edu.udb.service;

import sv.edu.udb.controller.request.SisPlanetaRequest;
import sv.edu.udb.controller.response.SisPlanetaResponse;

import java.util.List;

public interface SisPlanetaService {
    // Obtiene todos los sisPlanetas
    List<SisPlanetaResponse> findAll();

    // Guarda un empleado
    SisPlanetaResponse save(SisPlanetaRequest sisPlanetaRequest);

    // Busca un empleado por ID
    SisPlanetaResponse findById(Long id);

    // Elimina un empleado y su galaxia
    void deleteEmpleado(Long id);

    // Actualiza un empleado
    SisPlanetaResponse update(Long id, SisPlanetaRequest sisPlanetaRequest);
}