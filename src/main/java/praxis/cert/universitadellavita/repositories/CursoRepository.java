package praxis.cert.universitadellavita.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import praxis.cert.universitadellavita.Entities.Curso;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByEspecialidad_EspecialidadId(Long especialidadId);
    List<Curso> findByCursoId(Long cursoId);
    List<Curso> findByEspecialidad_EspecialidadIdAndCursoId(Long especialidadId, Long cursoId);
}