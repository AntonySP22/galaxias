package sv.edu.udb.service;

import sv.edu.udb.controller.request.EmpleadoRequest;
import sv.edu.udb.controller.response.EmpleadoResponse;
import java.util.List;

public interface EmpleadoService {
    // Obtiene todos los empleados
    List<EmpleadoResponse> findAll();

    // Guarda un empleado
    EmpleadoResponse save(EmpleadoRequest empleadoRequest);

    // Busca un empleado por ID
    EmpleadoResponse findById(Long id);

    // Elimina un empleado y su departamento
    void deleteEmpleado(Long id);

    // Actualiza un empleado
    EmpleadoResponse update(Long id, EmpleadoRequest empleadoRequest);
}