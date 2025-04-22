package sv.edu.udb.service;

import sv.edu.udb.controller.request.DepartamentoRequest;
import sv.edu.udb.controller.response.DepartamentoResponse;

import java.util.List;

public interface DepartamentoService {
    // Obtiene todos los departamentos
    List<DepartamentoResponse> findAll();

    // Guarda un departamento
    DepartamentoResponse save(DepartamentoRequest departamentoRequest);
    DepartamentoResponse findById(Long id);

    // Actualiza un departamento
    DepartamentoResponse update(Long id, DepartamentoRequest departamentoRequest);
}