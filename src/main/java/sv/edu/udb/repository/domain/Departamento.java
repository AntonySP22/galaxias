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



public class Departamento {
    /**
     * Antes era el Post
     * Clave primaria del departamento
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
     * *@OneToMany = da la relacion que hay (un dep tiene varios empleados)
     * mappedBY = establece la relacion con la clase Empleado en el campo departamento
     * cascade = CascadeType.ALL = asocia las operaciones de depertamento a sus empleados
     * orphanRemoval = true = si un empleado no tiene departamento de elimina el empleado
     * */
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empleado> empleados = new ArrayList<>();
}