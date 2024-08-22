package praxis.cert.universitadellavita.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import praxis.cert.universitadellavita.services.CursoService;
import praxis.cert.universitadellavita.services.EspecialidadService;
import praxis.cert.universitadellavita.services.EvaluacionAlumnoCursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    private EvaluacionAlumnoCursoService evaluacionAlumnoCursoService;

    @GetMapping
    public String buscadorAlumnos(
            @RequestParam(value = "especialidad", required = false) Long especialidadId,
            @RequestParam(value = "curso", required = false) Long cursoId,
            Model model
    ) {
        // Obtener todas las especialidades y cursos
        model.addAttribute("especialidades", especialidadService.obtenerEspecialidades());
        model.addAttribute("cursos", cursoService.obtenerCursos());

        // Filtrar alumnos si se proporcionan parámetros
        if (especialidadId != null && cursoId != null) {
            model.addAttribute("alumnos", evaluacionAlumnoCursoService.buscarAlumnosPorEspecialidadIdCursoId(especialidadId, cursoId));
        } else if (especialidadId != null) {
            model.addAttribute("alumnos", evaluacionAlumnoCursoService.buscarAlumnosPorEspecialidadId(especialidadId));
        } else if (cursoId != null) {
            model.addAttribute("alumnos", evaluacionAlumnoCursoService.buscarAlumnosPorCursoId(cursoId));
        } else {
            model.addAttribute("alumnos", evaluacionAlumnoCursoService.obtenerTodosLosAlumnos());
        }

        return "cursos"; // Asegúrate de que este sea el nombre correcto de la plantilla
    }
}