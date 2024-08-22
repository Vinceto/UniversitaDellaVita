package praxis.cert.universitadellavita.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import praxis.cert.universitadellavita.Entities.EvaluacionAlumnoCurso;

import java.util.List;

@Repository
public interface EvaluacionAlumnoCursoRepository extends JpaRepository<EvaluacionAlumnoCurso, Long> {
    List<EvaluacionAlumnoCurso> findByAlumnoCursoAlumnoAlumnoIdAndAlumnoCursoCursoCursoId(Long alumnoId, Long cursoId);
    // Buscar alumnos por especialidad y curso
    List<EvaluacionAlumnoCurso> findByAlumnoCursoCursoEspecialidadEspecialidadIdAndAlumnoCursoCursoCursoId(Long especialidadId, Long cursoId);

    // Buscar alumnos por especialidad
    List<EvaluacionAlumnoCurso> findByAlumnoCursoCursoEspecialidadEspecialidadId(Long especialidadId);

    // Buscar alumnos por curso
    List<EvaluacionAlumnoCurso> findByAlumnoCursoCursoCursoId(Long cursoId);
}