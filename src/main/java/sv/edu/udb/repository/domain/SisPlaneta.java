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
    public class SisPlaneta {
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
         * *@ManyToOne: Varios sisPlanetas pueden estar en el mismo galaxia.
         * fetch = FetchType.LAZY: El galaxia solo se carga si se accede explícitamente.
         * *@JoinColumn(name = "departamento_id"): Clave foránea en la tabla de SisPlaneta.
         */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "departamento_id")
        private Galaxia galaxia;
    }