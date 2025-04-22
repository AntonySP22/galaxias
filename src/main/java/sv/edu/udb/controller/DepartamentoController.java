package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.DepartamentoRequest;
import sv.edu.udb.controller.response.DepartamentoResponse;
import sv.edu.udb.service.DepartamentoService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "departamentos")


public class DepartamentoController {
    // Inyecta el servicio de departamento para realizar operaciones relacionadas con los departamentos
    private final DepartamentoService departamentoService;

    // Endpoint para obtener todos los departamentos
    @GetMapping
    public List<DepartamentoResponse> findAllDepartamentos() {
        // Llama al servicio para obtener todos los departamentos
        return departamentoService.findAll();
    }

    // Endpoint para guardar un nuevo departamento
    @PostMapping
    @ResponseStatus(CREATED) // Establece el código de estado de la respuesta como 201 (CREATED)
    public DepartamentoResponse saveDepartamento(@Valid @RequestBody final DepartamentoRequest request) {
        // Llama al servicio para guardar el departamento
        return departamentoService.save(request);
    }

    // Endpoint para buscar un departamento por ID
    @GetMapping("/{id}")
    public DepartamentoResponse findDepartamentoById(@PathVariable Long id) {
        return departamentoService.findById(id);
    }

    // Endpoint para actualizar un departamento
    @PutMapping("/{id}")
    public DepartamentoResponse updateDepartamento(@PathVariable Long id, @Valid @RequestBody final DepartamentoRequest request) {
        return departamentoService.update(id, request);
    }

}