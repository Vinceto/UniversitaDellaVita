package praxis.cert.universitadellavita.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import praxis.cert.universitadellavita.services.AlumnoService;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", alumnoService.obtenerTodosLosAlumnos());
        return "alumnos";
    }
}
