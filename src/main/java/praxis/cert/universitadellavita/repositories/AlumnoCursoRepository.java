package praxis.cert.universitadellavita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import praxis.cert.universitadellavita.Entities.AlumnoCurso;

@Repository
public interface AlumnoCursoRepository extends JpaRepository<AlumnoCurso, Long> {
}
