package praxis.cert.universitadellavita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.Entities.AlumnoCurso;
import praxis.cert.universitadellavita.Entities.Curso;
import praxis.cert.universitadellavita.repositories.AlumnoCursoRepository;
import praxis.cert.universitadellavita.repositories.CursoRepository;
import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerCursosPorEspecialidad(Long especialidadId) {
        return cursoRepository.findByEspecialidad_EspecialidadId(especialidadId);
    }

    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    public List<Curso> obtenerCursosPorCursoId(long cursoId) {
        return cursoRepository.findByCursoId(cursoId);
    }

    public List<Curso> obtenerCursosPorEspecialidadIdYCursoId(Long especialidadId, Long cursoId) {
        return cursoRepository.findByEspecialidad_EspecialidadIdAndCursoId(especialidadId, cursoId);
    }

    public List<Curso> obtenerCursosPorEspecialidadId(Long especialidadId) {
        return cursoRepository.findByEspecialidad_EspecialidadId(especialidadId);
    }
}
