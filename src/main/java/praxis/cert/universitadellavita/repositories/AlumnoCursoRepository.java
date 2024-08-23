package praxis.cert.universitadellavita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import praxis.cert.universitadellavita.Entities.AlumnoCurso;

import java.util.List;

@Repository
public interface AlumnoCursoRepository extends JpaRepository<AlumnoCurso, Long> {
    List<AlumnoCurso> findByCurso_CursoId(Long cursoId);
}
