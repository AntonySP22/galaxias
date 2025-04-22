    package sv.edu.udb.controller.request;

    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import lombok.Data;
    import java.time.LocalDate;

    @Data
    public class EmpleadoRequest {
        /**
         * Es una plantilla de como se espera recibir los datos
         */
        @NotBlank(message = "El nombre del empleado es obligatorio")
        private String nombre;

        @NotBlank(message = "El apellido del empleado es obligatorio")
        private String apellido;

        private String cargo;
        private Double salario;

        @NotNull(message = "La fecha de contratación es obligatoria")
        private LocalDate fechaContratacion;

        @NotNull(message = "El ID del departamento es obligatorio")
        private Long departamentoId;
    }