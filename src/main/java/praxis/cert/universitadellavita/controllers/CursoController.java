package praxis.cert.universitadellavita.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import praxis.cert.universitadellavita.services.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoService.obtenerCursosPorEspecialidad(null));
        return "cursos";
    }
}
