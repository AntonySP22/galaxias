package sv.edu.udb.repository.domain;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.time.LocalDate;

    @Getter
    @Setter
    @Entity
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class Empleado {
        /**
         * Antes era el PostComment
         * Clave primaria del empleado
         * y auto incremento
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;

        @Column(nullable = false)
        private String nombre;

        @Column(nullable = false)
        private String apellido;

        @Column
        private String cargo;

        @Column
        private Double salario;

        @Column(nullable = false)
        private LocalDate fechaContratacion;
        /**
         * *@ManyToOne: Varios empleados pueden estar en el mismo departamento.
         * fetch = FetchType.LAZY: El departamento solo se carga si se accede explícitamente.
         * *@JoinColumn(name = "departamento_id"): Clave foránea en la tabla de Empleado.
         */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "departamento_id")
        private Departamento departamento;
    }