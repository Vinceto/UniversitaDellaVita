package praxis.cert.universitadellavita.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alumnoCursoId;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "alumnoCurso")
    private List<AsistenciaAlumnoCurso> asistencias;
    @OneToMany(mappedBy = "alumno")
    private List<Asistencia> asistencias;

    @OneToMany(mappedBy = "alumnoCurso")
    private List<EvaluacionAlumnoCurso> evaluaciones;
}
