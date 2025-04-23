package sv.edu.udb.repository.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor



public class Galaxia {
    /**
     * Antes era el Post
     * Clave primaria del galaxia
     * y auto incremento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    /** Columna con datos obligatorios */
    @Column(nullable = false)
    private String nombreD;

    /** Columna con datos opcionales */
    @Column
    private String descripcion;

    /**
     * *@OneToMany = da la relacion que hay (un dep tiene varios sisPlanetas)
     * mappedBY = establece la relacion con la clase SisPlaneta en el campo galaxia
     * cascade = CascadeType.ALL = asocia las operaciones de depertamento a sus sisPlanetas
     * orphanRemoval = true = si un empleado no tiene galaxia de elimina el empleado
     * */
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SisPlaneta> sisPlanetas = new ArrayList<>();
}