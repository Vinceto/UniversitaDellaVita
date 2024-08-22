package praxis.cert.universitadellavita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.repositories.AlumnoRepository;
import praxis.cert.universitadellavita.repositories.CursoRepository;
import praxis.cert.universitadellavita.repositories.EvaluacionAlumnoCursoRepository;

@Service
public class ValidacionNotasServiceImpl implements ValidacionNotasService {

    private final EvaluacionAlumnoCursoRepository evaluacionAlumnoCursoRepository;
    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public ValidacionNotasServiceImpl(EvaluacionAlumnoCursoRepository evaluacionAlumnoCursoRepository,
                                      AlumnoRepository alumnoRepository,
                                      CursoRepository cursoRepository) {
        this.evaluacionAlumnoCursoRepository = evaluacionAlumnoCursoRepository;
        this.alumnoRepository = alumnoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public boolean apruebaCurso(Long alumnoId, Long cursoId) {
        return evaluacionAlumnoCursoRepository
                .findByAlumnoCursoAlumnoAlumnoIdAndAlumnoCursoCursoCursoId(alumnoId, cursoId)
                .stream()
                .anyMatch(evaluacion -> evaluacion.getNota() >= 4.0);
    }


    @Override
    public boolean existeAlumno(Long alumnoId) {
        return alumnoRepository.existsById(alumnoId);
    }

    @Override
    public boolean existeCurso(Long cursoId) {
        return cursoRepository.existsById(cursoId);
    }
}