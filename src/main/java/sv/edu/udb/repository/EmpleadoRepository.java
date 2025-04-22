package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.udb.repository.domain.Empleado;

@Repository
/**
 * EmpleadoRepository es una interfaz que extiende JpaRepository para realizar operaciones CRUD en la entidad Empleado.
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}