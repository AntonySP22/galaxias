package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import sv.edu.udb.controller.request.SisPlanetaRequest;
import sv.edu.udb.controller.response.SisPlanetaResponse;
import sv.edu.udb.repository.domain.SisPlaneta;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GalaxiaMapper.class})
public interface SisPlanetaMapper {
    // Convierte un SisPlanetaRequest a un SisPlaneta, mapeando el departamentoId al id del galaxia
    @Mapping(source = "departamentoId", target = "galaxia.id")
    SisPlaneta toEmpleado(SisPlanetaRequest sisPlanetaRequest);

    // Convierte un SisPlaneta a un SisPlanetaResponse
    SisPlanetaResponse toEmpleadoResponse(SisPlaneta sisPlaneta);

    // Convierte una lista de Empleados a una lista de SisPlanetaResponse
    List<SisPlanetaResponse> toEmpleadoResponseList(List<SisPlaneta> sisPlanetas);

    // Actualiza un SisPlaneta con los datos de un SisPlanetaRequest
    void updateEmpleadoFromRequest(SisPlanetaRequest sisPlanetaRequest, @MappingTarget SisPlaneta sisPlaneta);
}