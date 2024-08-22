package praxis.cert.universitadellavita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.Entities.Curso;
import praxis.cert.universitadellavita.repositories.CursoRepository;
import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerCursosPorEspecialidad(Long especialidadId) {
        return cursoRepository.findByEspecialidadEspecialidadId(especialidadId);
    }

    public Object obtenerCursos() {
        return cursoRepository.findAll();
    }
}
