package praxis.cert.universitadellavita.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.Entities.EvaluacionAlumnoCurso;
import praxis.cert.universitadellavita.repositories.EvaluacionAlumnoCursoRepository;
import java.util.List;

@Service
public class EvaluacionAlumnoCursoService {
    @Autowired
    private EvaluacionAlumnoCursoRepository evaluacionAlumnoCursoRepository;

    public List<EvaluacionAlumnoCurso> obtenerEvaluacionesPorCurso(Long cursoId) {
        // lógica para obtener evaluaciones por curso
        return null; // Ejemplo
    }
}
