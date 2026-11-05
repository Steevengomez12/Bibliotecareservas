package biblioteca;

import java.util.List;
import java.util.Optional;

public interface EstrategiaSeleccionSala {
    Optional<Sala> seleccionarSala(List<Sala> salasDisponibles, int cantidadPersonas);
}

