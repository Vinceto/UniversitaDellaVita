package praxis.cert.universitadellavita.services;

public interface ValidacionNotasService {
    boolean apruebaCurso(Long alumnoId, Long cursoId);

    boolean existeAlumno(Long alumnoId);

    boolean existeCurso(Long cursoId);
}
