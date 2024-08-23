package praxis.cert.universitadellavita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.Entities.AlumnoCurso;
import praxis.cert.universitadellavita.repositories.AlumnoCursoRepository;

import java.util.List;

@Service
public class AlumnoCursoService {
    @Autowired
    private AlumnoCursoRepository alumnoCursoRepository;

    public List<AlumnoCurso> obtenerAlumnosPorCursoId(Long cursoId) {
        return alumnoCursoRepository.findByCurso_CursoId(cursoId);
    }
}
