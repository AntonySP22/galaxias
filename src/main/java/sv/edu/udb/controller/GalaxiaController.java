package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.GalalxiaRequest;
import sv.edu.udb.controller.response.GalaxiaResponse;
import sv.edu.udb.service.GalaxiaService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "departamentos")


public class GalaxiaController {
    // Inyecta el servicio de galaxia para realizar operaciones relacionadas con los departamentos
    private final GalaxiaService galaxiaService;

    // Endpoint para obtener todos los departamentos
    @GetMapping
    public List<GalaxiaResponse> findAllDepartamentos() {
        // Llama al servicio para obtener todos los departamentos
        return galaxiaService.findAll();
    }

    // Endpoint para guardar un nuevo galaxia
    @PostMapping
    @ResponseStatus(CREATED) // Establece el código de estado de la respuesta como 201 (CREATED)
    public GalaxiaResponse saveDepartamento(@Valid @RequestBody final GalalxiaRequest request) {
        // Llama al servicio para guardar el galaxia
        return galaxiaService.save(request);
    }

    // Endpoint para buscar un galaxia por ID
    @GetMapping("/{id}")
    public GalaxiaResponse findDepartamentoById(@PathVariable Long id) {
        return galaxiaService.findById(id);
    }

    // Endpoint para actualizar un galaxia
    @PutMapping("/{id}")
    public GalaxiaResponse updateDepartamento(@PathVariable Long id, @Valid @RequestBody final GalalxiaRequest request) {
        return galaxiaService.update(id, request);
    }

}