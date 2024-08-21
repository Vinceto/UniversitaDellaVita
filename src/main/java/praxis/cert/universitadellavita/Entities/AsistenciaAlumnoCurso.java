package praxis.cert.universitadellavita.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "asistencia_alumno_curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaAlumnoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asistenciaId;

    private Date fecha;
    private Boolean asiste;

    @ManyToOne
    @JoinColumn(name = "alumno_curso_id")
    private AlumnoCurso alumnoCurso;
}
