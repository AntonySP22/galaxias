package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.EmpleadoRequest;
import sv.edu.udb.controller.response.EmpleadoResponse;
import sv.edu.udb.service.EmpleadoService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    // Endpoint para obtener todos los empleados
    @GetMapping
    public List<EmpleadoResponse> findAllEmpleados() {
        return empleadoService.findAll();
    }

    // Endpoint  para guardar un nuevo empleado
    @PostMapping
    @ResponseStatus(CREATED)
    public EmpleadoResponse saveEmpleado(@Valid @RequestBody final EmpleadoRequest request) {
        return empleadoService.save(request);
    }

    // endpoint  buscar empleado por ID (Punto 3 del desafío)
    @GetMapping("/{id}")
    public EmpleadoResponse findEmpleadoById(@PathVariable Long id) {
        return empleadoService.findById(id);
    }

    // Endpoint para eliminar empleado y su departamento
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
    }

    // Endpoint para actualizar un empleado
    @PutMapping("/{id}")
    public EmpleadoResponse updateEmpleado(@PathVariable Long id, @Valid @RequestBody final EmpleadoRequest request) {
        return empleadoService.update(id, request);
    }
}