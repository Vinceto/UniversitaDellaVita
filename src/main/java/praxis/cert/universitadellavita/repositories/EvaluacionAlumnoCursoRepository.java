package praxis.cert.universitadellavita.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import praxis.cert.universitadellavita.Entities.EvaluacionAlumnoCurso;

@Repository
public interface EvaluacionAlumnoCursoRepository extends JpaRepository<EvaluacionAlumnoCurso, Long> {
}