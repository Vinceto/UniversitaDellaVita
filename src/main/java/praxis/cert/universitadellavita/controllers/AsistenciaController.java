package praxis.cert.universitadellavita.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import praxis.cert.universitadellavita.services.AsistenciaService;

import java.util.Date;

@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping
    public String listarInasistencias(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha, Model model) {
        model.addAttribute("inasistencias", asistenciaService.obtenerInasistenciasPorFecha(fecha));
        return "inasistencias";
    }
}
