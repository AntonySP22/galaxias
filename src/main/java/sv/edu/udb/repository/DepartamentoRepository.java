package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.udb.repository.domain.Departamento;

@Repository
/**
 * DepartamentoRepository es una interfaz que extiende JpaRepository para realizar operaciones CRUD en la entidad Departamento.
 */
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}