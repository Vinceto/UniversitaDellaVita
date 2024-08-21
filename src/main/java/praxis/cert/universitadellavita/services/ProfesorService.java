package praxis.cert.universitadellavita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.Entities.Profesor;
import praxis.cert.universitadellavita.repositories.ProfesorRepository;
import java.util.List;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> obtenerTodosLosProfesores() {
        return profesorRepository.findAll();
    }
}
