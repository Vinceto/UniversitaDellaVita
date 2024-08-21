package praxis.cert.universitadellavita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import praxis.cert.universitadellavita.Entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}