package sv.edu.udb.controller.response;

import lombok.Data;
import lombok.AllArgsConstructor;
//import java.util.List;

@Data
@AllArgsConstructor
public class GalaxiaResponse {
    /**
     * Es una el orden/formato en como se enviaran los datos al ser consultados
     */
    private Long id;
    private String nombreD;
    private String descripcion;
}