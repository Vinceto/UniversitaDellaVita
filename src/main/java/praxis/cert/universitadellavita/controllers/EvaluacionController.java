package praxis.cert.universitadellavita.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import praxis.cert.universitadellavita.services.EvaluacionService;

@Controller
@RequestMapping("/evaluaciones")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public String listarEvaluaciones(Model model) {
        model.addAttribute("evaluaciones", evaluacionService.obtenerTodasLasEvaluaciones());
        return "evaluaciones";
    }
}
