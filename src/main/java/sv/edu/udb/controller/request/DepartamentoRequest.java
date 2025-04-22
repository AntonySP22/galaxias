package sv.edu.udb.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartamentoRequest {
    /**
     * Es una plantilla de como se espera recibir los datos
     */
    @NotBlank(message = "El nombre del departamento es obligatorio")
    private String nombreD;
    private String descripcion;
}