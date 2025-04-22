package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
//import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.DepartamentoRequest;
import sv.edu.udb.controller.response.DepartamentoResponse;
import sv.edu.udb.repository.DepartamentoRepository;
import sv.edu.udb.repository.domain.Departamento;
import sv.edu.udb.service.DepartamentoService;
import sv.edu.udb.service.mapper.DepartamentoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {

    // Inyecta el repositorio de departamento para acceder a la base de datos
    @NotNull
    private final DepartamentoRepository departamentoRepository;

    // Inyecta el mapper de departamento para transformar entre entidades y DTOs
    @NotNull
    private final DepartamentoMapper departamentoMapper;

    // Implementa la lógica para obtener todos los departamentos
    @Override
    public List<DepartamentoResponse> findAll() {
        // Utiliza el mapper para transformar la lista de entidades a una lista de DTOs
        return departamentoMapper.toDepartamentoResponseList(departamentoRepository.findAll());
    }

    // Implementa la lógica para guardar un nuevo departamento
    @Override
    public DepartamentoResponse save(final DepartamentoRequest departamentoRequest) {
        // Utiliza el mapper para transformar el DTO a una entidad
        Departamento departamento = departamentoMapper.toDepartamento(departamentoRequest);
        // Guarda el departamento en la base de datos y lo transforma a DTO
        return departamentoMapper.toDepartamentoResponse(departamentoRepository.save(departamento));
    }

    @Override
    public DepartamentoResponse findById(Long id) {
        return departamentoMapper.toDepartamentoResponse(
                departamentoRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado con ID: " + id))
        );
    }

    // Implementa la lógica para actualizar un departamento
   @Override
   public DepartamentoResponse update(Long id, DepartamentoRequest departamentoRequest) {
       Departamento departamento = departamentoRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

       departamento.setNombreD(departamentoRequest.getNombreD());
       departamento.setDescripcion(departamentoRequest.getDescripcion());

       // Guarda el departamento actualizado en la base de datos
       departamentoRepository.save(departamento);

       // Retorna el departamento actualizado
       return new DepartamentoResponse(departamento.getId(), departamento.getNombreD(), departamento.getDescripcion());
   }
}