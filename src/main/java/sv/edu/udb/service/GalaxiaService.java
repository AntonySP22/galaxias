package sv.edu.udb.service;

import sv.edu.udb.controller.request.GalalxiaRequest;
import sv.edu.udb.controller.response.GalaxiaResponse;

import java.util.List;

public interface GalaxiaService {
    // Obtiene todos los departamentos
    List<GalaxiaResponse> findAll();

    // Guarda un galaxia
    GalaxiaResponse save(GalalxiaRequest galalxiaRequest);
    GalaxiaResponse findById(Long id);

    // Actualiza un galaxia
    GalaxiaResponse update(Long id, GalalxiaRequest galalxiaRequest);
}