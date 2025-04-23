package sv.edu.udb.controller.response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class SisPlanetaResponse {
    /**
     * Es una el orden/formato en como se enviaran los datos al ser consultados
     */
    private Long id;
    private String nombre;
    private String apellido;
    private String cargo;
    private Double salario;
    private LocalDate fechaContratacion;
    private GalaxiaResponse departamento;
}