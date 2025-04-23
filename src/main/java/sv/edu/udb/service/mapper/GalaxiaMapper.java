package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import sv.edu.udb.controller.request.GalalxiaRequest;
import sv.edu.udb.controller.response.GalaxiaResponse;
import sv.edu.udb.repository.domain.Galaxia;

import java.util.List;

@Mapper(componentModel = "spring") //Indica que es un componente de Spring
public interface GalaxiaMapper {

    // Convierte un GalalxiaRequest a un Galaxia
    Galaxia toDepartamento(GalalxiaRequest galalxiaRequest);

    // Convierte un Galaxia a un GalaxiaResponse
    GalaxiaResponse toDepartamentoResponse(Galaxia galaxia);

    // Convierte una lista de Departamentos a una lista de GalaxiaResponse
    List<GalaxiaResponse> toDepartamentoResponseList(List<Galaxia> galaxias);

    // Actualiza un Galaxia con los datos de un GalalxiaRequest
    void updateDepartamentoFromRequest(GalalxiaRequest galalxiaRequest, @MappingTarget Galaxia galaxia);
}