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
    @Column(name = "alumno_id")
    private Long alumnoId;

    private String alumnoNombre;
    private String alumnoApellido;
    private String alumnoEmail;

    @OneToMany(mappedBy = "alumno")
    private List<AlumnoCurso> cursos;
}