package praxis.cert.universitadellavita.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "especialidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long especialidadId;

    private String especialidadDescripcion;

    @OneToMany(mappedBy = "especialidad")
    private List<Curso> cursos;
}
