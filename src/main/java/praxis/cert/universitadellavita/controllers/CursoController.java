package praxis.cert.universitadellavita.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import praxis.cert.universitadellavita.Entities.Alumno;
import praxis.cert.universitadellavita.Entities.AlumnoCurso;
import praxis.cert.universitadellavita.Entities.AlumnoDTO;
import praxis.cert.universitadellavita.Entities.Curso;
import praxis.cert.universitadellavita.services.AlumnoCursoService;
import praxis.cert.universitadellavita.services.CursoService;
import praxis.cert.universitadellavita.services.EspecialidadService;
import praxis.cert.universitadellavita.services.EvaluacionAlumnoCursoService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    private EvaluacionAlumnoCursoService evaluacionAlumnoCursoService;

    @Autowired
    private AlumnoCursoService alumnoCursoService;

    @GetMapping
    public String buscadorAlumnos(
            @RequestParam(value = "especialidad", required = false) Long especialidadId,
            @RequestParam(value = "curso", required = false) Long cursoId,
            Model model
    ) {
        // Obtener todas las especialidades y cursos
        model.addAttribute("especialidades", especialidadService.obtenerEspecialidades());
        model.addAttribute("cursos", cursoService.obtenerCursos());

        // Lista para almacenar la información de los alumnos
        List<AlumnoDTO> alumnos = new ArrayList<>();

        // Filtrar alumnos según los parámetros proporcionados
        if (especialidadId != null || cursoId != null) {
            List<Curso> cursos;

            if (especialidadId != null && cursoId != null) {
                cursos = cursoService.obtenerCursosPorEspecialidadIdYCursoId(especialidadId, cursoId);
            } else if (especialidadId != null) {
                cursos = cursoService.obtenerCursosPorEspecialidadId(especialidadId);
            } else {
                cursos = cursoService.obtenerCursosPorCursoId(cursoId);
            }

            for (Curso curso : cursos) {
                List<AlumnoCurso> alumnoCursos = alumnoCursoService.obtenerAlumnosPorCursoId(curso.getCursoId());

                for (AlumnoCurso alumnoCurso : alumnoCursos) {
                    Alumno alumno = alumnoCurso.getAlumno();

                    // Calcular promedio de notas para cada alumno
                    Double promedioNotas = evaluacionAlumnoCursoService.obtenerPromedioNotas(alumnoCurso.getAlumnoCursoId());

                    // Crear un objeto DTO que contenga la información requerida
                    AlumnoDTO alumnoDTO = new AlumnoDTO(
                            alumno.getAlumnoNombre(),
                            alumno.getAlumnoApellido(),
                            alumno.getAlumnoEmail(),
                            curso.getCursoDescripcion(),
                            promedioNotas
                    );

                    alumnos.add(alumnoDTO);
                }
            }
        } else {
            // Si no se proporcionan filtros, obtener todos los alumnos
            //alumnos = evaluacionAlumnoCursoService.obtenerTodosLosAlumnos();
        }

        model.addAttribute("alumnos", alumnos);
        return "cursos"; // Asegúrate de que este sea el nombre correcto de la plantilla
    }
}