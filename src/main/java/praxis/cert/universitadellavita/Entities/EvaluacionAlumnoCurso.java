package praxis.cert.universitadellavita.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "evaluacion_alumno_curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluacionAlumnoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluacionAlumnoCursoId;

    @ManyToOne
    @JoinColumn(name = "alumno_curso_id")
    private AlumnoCurso alumnoCurso;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id")
    private Evaluacion evaluacion;

    private Double nota;
}
