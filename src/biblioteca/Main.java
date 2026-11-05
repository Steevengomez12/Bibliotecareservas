package biblioteca;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sala> disponibles = List.of(
                new Sala("A", "Sala A", 2),
                new Sala("B", "Sala B", 4),
                new Sala("C", "Sala C", 6),
                new Sala("D", "Sala D", 8)
        );

        EstrategiaSeleccionSala porCapacidad = new SeleccionPorCapacidad();
        System.out.println("Sala para 4 personas: "
                + porCapacidad.seleccionarSala(disponibles, 4).orElse(null));

        EstrategiaSeleccionSala preferida = new SeleccionSalaPreferida("C");
        System.out.println("Sala preferida C: "
                + preferida.seleccionarSala(disponibles, 4).orElse(null));
    }
}