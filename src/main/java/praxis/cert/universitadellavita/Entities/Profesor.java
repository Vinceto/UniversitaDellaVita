package praxis.cert.universitadellavita.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "profesor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profesorId;

    private String profesorNombre;
    private String profesorApellido;
    private String profesorEmail;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;
}
