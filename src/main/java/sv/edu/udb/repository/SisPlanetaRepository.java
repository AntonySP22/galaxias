package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.udb.repository.domain.SisPlaneta;

@Repository
/**
 * SisPlanetaRepository es una interfaz que extiende JpaRepository para realizar operaciones CRUD en la entidad SisPlaneta.
 */
public interface SisPlanetaRepository extends JpaRepository<SisPlaneta, Long> {
}