package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.SisPlanetaRequest;
import sv.edu.udb.controller.response.SisPlanetaResponse;
import sv.edu.udb.repository.GalaxiaRepository;
import sv.edu.udb.repository.SisPlanetaRepository;
import sv.edu.udb.repository.domain.Galaxia;
import sv.edu.udb.repository.domain.SisPlaneta;
import sv.edu.udb.service.SisPlanetaService;
import sv.edu.udb.service.mapper.SisPlanetaMapper;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SisPlanetaServiceImpl implements SisPlanetaService {

    // Inyecta el repositorio de empleado para acceder a la base de datos
    private final SisPlanetaRepository sisPlanetaRepository;
    private final GalaxiaRepository galaxiaRepository;
    private final SisPlanetaMapper sisPlanetaMapper;

    // Busca todos los sisPlanetas
    @Override
    public List<SisPlanetaResponse> findAll() {
        return sisPlanetaMapper.toEmpleadoResponseList(sisPlanetaRepository.findAll());
    }

    // Guarda un empleado
    @Override
    public SisPlanetaResponse save(SisPlanetaRequest sisPlanetaRequest) {
        return sisPlanetaMapper.toEmpleadoResponse(
                sisPlanetaRepository.save(sisPlanetaMapper.toEmpleado(sisPlanetaRequest))
        );
    }

    // Busca un empleado por ID
    @Override
    public SisPlanetaResponse findById(Long id) {
        return sisPlanetaMapper.toEmpleadoResponse(
                sisPlanetaRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("SisPlaneta no encontrado con ID: " + id))
        );
    }

    @Override
    @Transactional
    public void deleteEmpleado(Long id) {
        // Busca el sisPlaneta
        SisPlaneta sisPlaneta = sisPlanetaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SisPlaneta no encontrado"));

        // Obtiene su galaxia
        Galaxia galaxia = sisPlaneta.getGalaxia();
        // Eliminar sisPlaneta y galaxia
        sisPlanetaRepository.delete(sisPlaneta);
        galaxiaRepository.delete(galaxia);
    }

    public SisPlanetaResponse update(Long id, SisPlanetaRequest sisPlanetaRequest) {
        // Buscar sisPlaneta por ID
        SisPlaneta sisPlaneta = sisPlanetaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SisPlaneta no encontrado con ID: " + id));
        // Mapear datos
        sisPlanetaMapper.updateEmpleadoFromRequest(sisPlanetaRequest, sisPlaneta);

        // Buscar y asignar nuevo galaxia si se proporciona un ID válido
        if (sisPlanetaRequest.getDepartamentoId() != null) {
            Galaxia galaxia = galaxiaRepository.findById(sisPlanetaRequest.getDepartamentoId())
                    .orElseThrow(() -> new EntityNotFoundException("Galaxia no encontrado con ID: " + sisPlanetaRequest.getDepartamentoId()));
            sisPlaneta.setGalaxia(galaxia);
        }

        return sisPlanetaMapper.toEmpleadoResponse(sisPlanetaRepository.save(sisPlaneta));
    }

}
