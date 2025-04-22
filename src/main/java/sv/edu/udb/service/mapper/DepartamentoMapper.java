package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import sv.edu.udb.controller.request.DepartamentoRequest;
import sv.edu.udb.controller.response.DepartamentoResponse;
import sv.edu.udb.repository.domain.Departamento;

import java.util.List;

@Mapper(componentModel = "spring") //Indica que es un componente de Spring
public interface DepartamentoMapper {

    // Convierte un DepartamentoRequest a un Departamento
    Departamento toDepartamento(DepartamentoRequest departamentoRequest);

    // Convierte un Departamento a un DepartamentoResponse
    DepartamentoResponse toDepartamentoResponse(Departamento departamento);

    // Convierte una lista de Departamentos a una lista de DepartamentoResponse
    List<DepartamentoResponse> toDepartamentoResponseList(List<Departamento> departamentos);

    // Actualiza un Departamento con los datos de un DepartamentoRequest
    void updateDepartamentoFromRequest(DepartamentoRequest departamentoRequest, @MappingTarget Departamento departamento);
}