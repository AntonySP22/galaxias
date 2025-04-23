package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.udb.repository.domain.Galaxia;

@Repository
/**
 * GalaxiaRepository es una interfaz que extiende JpaRepository para realizar operaciones CRUD en la entidad Galaxia.
 */
public interface GalaxiaRepository extends JpaRepository<Galaxia, Long> {
}