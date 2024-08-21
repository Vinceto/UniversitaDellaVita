package praxis.cert.universitadellavita.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.Entities.Evaluacion;
import praxis.cert.universitadellavita.repositories.EvaluacionRepository;

import java.util.List;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> obtenerTodasLasEvaluaciones() {
        return evaluacionRepository.findAll();
    }
}
