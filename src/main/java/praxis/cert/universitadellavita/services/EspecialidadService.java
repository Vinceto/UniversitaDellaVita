package praxis.cert.universitadellavita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praxis.cert.universitadellavita.Entities.Especialidad;
import praxis.cert.universitadellavita.repositories.EspecialidadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    // Obtener todas las especialidades
    public List<Especialidad> obtenerEspecialidades() {
        return especialidadRepository.findAll();
    }

    // Buscar especialidad por ID
    public Optional<Especialidad> obtenerEspecialidadPorId(Long id) {
        return especialidadRepository.findById(id);
    }

    // Guardar o actualizar una especialidad
    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    // Eliminar una especialidad por ID
    public void eliminarEspecialidad(Long id) {
        especialidadRepository.deleteById(id);
    }
}