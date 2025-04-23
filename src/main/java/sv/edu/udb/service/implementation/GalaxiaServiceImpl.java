package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
//import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.GalalxiaRequest;
import sv.edu.udb.controller.response.GalaxiaResponse;
import sv.edu.udb.repository.GalaxiaRepository;
import sv.edu.udb.repository.domain.Galaxia;
import sv.edu.udb.service.GalaxiaService;
import sv.edu.udb.service.mapper.GalaxiaMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GalaxiaServiceImpl implements GalaxiaService {

    // Inyecta el repositorio de galaxia para acceder a la base de datos
    @NotNull
    private final GalaxiaRepository galaxiaRepository;

    // Inyecta el mapper de galaxia para transformar entre entidades y DTOs
    @NotNull
    private final GalaxiaMapper galaxiaMapper;

    // Implementa la lógica para obtener todos los departamentos
    @Override
    public List<GalaxiaResponse> findAll() {
        // Utiliza el mapper para transformar la lista de entidades a una lista de DTOs
        return galaxiaMapper.toDepartamentoResponseList(galaxiaRepository.findAll());
    }

    // Implementa la lógica para guardar un nuevo galaxia
    @Override
    public GalaxiaResponse save(final GalalxiaRequest galalxiaRequest) {
        // Utiliza el mapper para transformar el DTO a una entidad
        Galaxia galaxia = galaxiaMapper.toDepartamento(galalxiaRequest);
        // Guarda el galaxia en la base de datos y lo transforma a DTO
        return galaxiaMapper.toDepartamentoResponse(galaxiaRepository.save(galaxia));
    }

    @Override
    public GalaxiaResponse findById(Long id) {
        return galaxiaMapper.toDepartamentoResponse(
                galaxiaRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Galaxia no encontrado con ID: " + id))
        );
    }

    // Implementa la lógica para actualizar un galaxia
   @Override
   public GalaxiaResponse update(Long id, GalalxiaRequest galalxiaRequest) {
       Galaxia galaxia = galaxiaRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Galaxia no encontrado"));

       galaxia.setNombreD(galalxiaRequest.getNombreD());
       galaxia.setDescripcion(galalxiaRequest.getDescripcion());

       // Guarda el galaxia actualizado en la base de datos
       galaxiaRepository.save(galaxia);

       // Retorna el galaxia actualizado
       return new GalaxiaResponse(galaxia.getId(), galaxia.getNombreD(), galaxia.getDescripcion());
   }
}