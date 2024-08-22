package praxis.cert.universitadellavita.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "evaluacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluacionId;

    private String evaluacionDescripcion;

    @OneToMany(mappedBy = "evaluacion")
    private List<EvaluacionAlumnoCurso> evaluaciones;
}