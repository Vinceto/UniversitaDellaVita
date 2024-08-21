package praxis.cert.universitadellavita.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.Entities.AsistenciaAlumnoCurso;
import praxis.cert.universitadellavita.repositories.AsistenciaAlumnoCursoRepository;
import java.util.Date;
import java.util.List;

@Service
public class AsistenciaService {
    @Autowired
    private AsistenciaAlumnoCursoRepository asistenciaAlumnoCursoRepository;

    public List<AsistenciaAlumnoCurso> obtenerInasistenciasPorFecha(Date fecha) {
        return asistenciaAlumnoCursoRepository.findByFechaAndAsisteFalse(fecha);
    }
}
