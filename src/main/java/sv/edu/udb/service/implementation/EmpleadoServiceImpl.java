package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.EmpleadoRequest;
import sv.edu.udb.controller.response.EmpleadoResponse;
import sv.edu.udb.repository.EmpleadoRepository;
import sv.edu.udb.repository.domain.Empleado;
import sv.edu.udb.service.EmpleadoService;
import sv.edu.udb.service.mapper.EmpleadoMapper;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.DepartamentoRepository;
import sv.edu.udb.repository.domain.Departamento;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    // Inyecta el repositorio de empleado para acceder a la base de datos
    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;
    private final EmpleadoMapper empleadoMapper;

    // Busca todos los empleados
    @Override
    public List<EmpleadoResponse> findAll() {
        return empleadoMapper.toEmpleadoResponseList(empleadoRepository.findAll());
    }

    // Guarda un empleado
    @Override
    public EmpleadoResponse save(EmpleadoRequest empleadoRequest) {
        return empleadoMapper.toEmpleadoResponse(
                empleadoRepository.save(empleadoMapper.toEmpleado(empleadoRequest))
        );
    }

    // Busca un empleado por ID
    @Override
    public EmpleadoResponse findById(Long id) {
        return empleadoMapper.toEmpleadoResponse(
                empleadoRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado con ID: " + id))
        );
    }

    @Override
    @Transactional
    public void deleteEmpleado(Long id) {
        // Busca el empleado
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));

        // Obtiene su departamento
        Departamento departamento = empleado.getDepartamento();
        // Eliminar empleado y departamento
        empleadoRepository.delete(empleado);
        departamentoRepository.delete(departamento);
    }

    public EmpleadoResponse update(Long id, EmpleadoRequest empleadoRequest) {
        // Buscar empleado por ID
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado con ID: " + id));
        // Mapear datos
        empleadoMapper.updateEmpleadoFromRequest(empleadoRequest, empleado);

        // Buscar y asignar nuevo departamento si se proporciona un ID válido
        if (empleadoRequest.getDepartamentoId() != null) {
            Departamento departamento = departamentoRepository.findById(empleadoRequest.getDepartamentoId())
                    .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado con ID: " + empleadoRequest.getDepartamentoId()));
            empleado.setDepartamento(departamento);
        }

        return empleadoMapper.toEmpleadoResponse(empleadoRepository.save(empleado));
    }

}
