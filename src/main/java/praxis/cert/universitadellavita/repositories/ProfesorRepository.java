package praxis.cert.universitadellavita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import praxis.cert.universitadellavita.Entities.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
