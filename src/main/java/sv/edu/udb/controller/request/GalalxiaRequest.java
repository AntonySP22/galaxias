package sv.edu.udb.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GalalxiaRequest {
    /**
     * Es una plantilla de como se espera recibir los datos
     */
    @NotBlank(message = "El nombre del galaxia es obligatorio")
    private String nombreD;
    private String descripcion;
}