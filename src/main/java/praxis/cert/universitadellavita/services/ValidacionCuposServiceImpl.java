package praxis.cert.universitadellavita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.repositories.CursoRepository;

@Service
public class ValidacionCuposServiceImpl implements ValidacionCuposService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public boolean necesitaNuevaSeccion(Long cursoId) {
        int cantidadAlumnos = cursoRepository.findById(cursoId).map(curso -> curso.getAlumnos().size()).orElse(0);
        return cantidadAlumnos > 25;
    }
}