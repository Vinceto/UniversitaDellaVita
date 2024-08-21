package praxis.cert.universitadellavita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import praxis.cert.universitadellavita.Entities.AsistenciaAlumnoCurso;

import java.util.Date;
import java.util.List;

@Repository
public interface AsistenciaAlumnoCursoRepository extends JpaRepository<AsistenciaAlumnoCurso, Long> {
    List<AsistenciaAlumnoCurso> findByFechaAndAsisteFalse(Date fecha);
}
