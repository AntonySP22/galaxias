package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.SisPlanetaRequest;
import sv.edu.udb.controller.response.SisPlanetaResponse;
import sv.edu.udb.service.SisPlanetaService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "empleados")
public class SisPlanetaController {
    private final SisPlanetaService sisPlanetaService;

    // Endpoint para obtener todos los sisPlanetas
    @GetMapping
    public List<SisPlanetaResponse> findAllEmpleados() {
        return sisPlanetaService.findAll();
    }

    // Endpoint  para guardar un nuevo empleado
    @PostMapping
    @ResponseStatus(CREATED)
    public SisPlanetaResponse saveEmpleado(@Valid @RequestBody final SisPlanetaRequest request) {
        return sisPlanetaService.save(request);
    }

    // endpoint  buscar empleado por ID (Punto 3 del desafío)
    @GetMapping("/{id}")
    public SisPlanetaResponse findEmpleadoById(@PathVariable Long id) {
        return sisPlanetaService.findById(id);
    }

    // Endpoint para eliminar empleado y su galaxia
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteEmpleado(@PathVariable Long id) {
        sisPlanetaService.deleteEmpleado(id);
    }

    // Endpoint para actualizar un empleado
    @PutMapping("/{id}")
    public SisPlanetaResponse updateEmpleado(@PathVariable Long id, @Valid @RequestBody final SisPlanetaRequest request) {
        return sisPlanetaService.update(id, request);
    }
}