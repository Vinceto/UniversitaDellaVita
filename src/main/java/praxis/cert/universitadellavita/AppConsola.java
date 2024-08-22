package praxis.cert.universitadellavita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import praxis.cert.universitadellavita.services.ValidacionNotasService;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class AppConsola implements CommandLineRunner {

    @Autowired
    private ValidacionNotasService validacionNotasService;

    public static void main(String[] args) {
        SpringApplication.run(AppConsola.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese ID de alumno:");
            Long alumnoId = scanner.nextLong();

            if (alumnoId <= 0) {
                System.out.println("ID de alumno no es válido.");
                return;
            }

            System.out.println("Ingrese ID de curso:");
            Long cursoId = scanner.nextLong();

            if (cursoId <= 0) {
                System.out.println("ID de curso no es válido.");
                return;
            }

            if (!validacionNotasService.existeAlumno(alumnoId)) {
                System.out.println("El alumno con ID " + alumnoId + " no existe.");
                return;
            }

            if (!validacionNotasService.existeCurso(cursoId)) {
                System.out.println("El curso con ID " + cursoId + " no existe.");
                return;
            }

            boolean aprueba = validacionNotasService.apruebaCurso(alumnoId, cursoId);

            if (aprueba) {
                System.out.println("El alumno aprueba el curso.");
            } else {
                System.out.println("El alumno no aprueba el curso.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Error: Entrada inválida. Por favor, ingrese un número válido.");
        } catch (Exception e) {
            System.err.println("Error: Ocurrió un problema inesperado. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}