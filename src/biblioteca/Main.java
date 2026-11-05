package biblioteca;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sala> salas = List.of(
                new Sala("A", "Sala A", 2),
                new Sala("B", "Sala B", 4),
                new Sala("C", "Sala C", 6)
        );

        Estudiante estudiante = new Estudiante("E001", "Laura");
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Salas disponibles:");
        salas.forEach(System.out::println);
    }
}
