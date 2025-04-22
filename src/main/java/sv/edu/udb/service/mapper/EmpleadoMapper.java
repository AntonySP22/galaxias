package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import sv.edu.udb.controller.request.EmpleadoRequest;
import sv.edu.udb.controller.response.EmpleadoResponse;
import sv.edu.udb.repository.domain.Empleado;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DepartamentoMapper.class})
public interface EmpleadoMapper {
    // Convierte un EmpleadoRequest a un Empleado, mapeando el departamentoId al id del departamento
    @Mapping(source = "departamentoId", target = "departamento.id")
    Empleado toEmpleado(EmpleadoRequest empleadoRequest);

    // Convierte un Empleado a un EmpleadoResponse
    EmpleadoResponse toEmpleadoResponse(Empleado empleado);

    // Convierte una lista de Empleados a una lista de EmpleadoResponse
    List<EmpleadoResponse> toEmpleadoResponseList(List<Empleado> empleados);

    // Actualiza un Empleado con los datos de un EmpleadoRequest
    void updateEmpleadoFromRequest(EmpleadoRequest empleadoRequest, @MappingTarget Empleado empleado);
}