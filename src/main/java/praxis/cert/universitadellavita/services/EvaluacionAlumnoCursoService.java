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

    public List<EvaluacionAlumnoCurso> buscarAlumnosPorEspecialidadIdCursoId(Long especialidadId, Long cursoId) {
        return evaluacionAlumnoCursoRepository.findByAlumnoCursoCursoEspecialidadEspecialidadIdAndAlumnoCursoCursoCursoId(especialidadId, cursoId);
    }

    public List<EvaluacionAlumnoCurso> buscarAlumnosPorEspecialidadId(Long especialidadId) {
        return evaluacionAlumnoCursoRepository.findByAlumnoCursoCursoEspecialidadEspecialidadId(especialidadId);
    }

    public List<EvaluacionAlumnoCurso> buscarAlumnosPorCursoId(Long cursoId) {
        return evaluacionAlumnoCursoRepository.findByAlumnoCursoCursoCursoId(cursoId);
    }

    public List<EvaluacionAlumnoCurso> obtenerTodosLosAlumnos() {
        return evaluacionAlumnoCursoRepository.findAll();
    }

    public Double obtenerPromedioNotas(Long alumnoCursoId) {
        // Buscar todas las evaluaciones del alumno
        List<EvaluacionAlumnoCurso> evaluaciones = evaluacionAlumnoCursoRepository.findByAlumnoCurso_CursoId(alumnoCursoId);

        // Verificar si el alumno tiene evaluaciones
        if (evaluaciones.isEmpty()) {
            return 0.0;  // Retorna 0.0 si no tiene evaluaciones
        }

        // Sumar todas las notas
        double sumaNotas = evaluaciones.stream()
                .mapToDouble(EvaluacionAlumnoCurso::getNota)
                .sum();

        // Calcular el promedio
        return sumaNotas / evaluaciones.size();
    }
}