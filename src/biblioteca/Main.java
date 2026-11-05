package biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        ReservaFacade fachada = new ReservaFacade(
                new RepositorioSalasMemoria(),
                new RepositorioReservasMemoria());

        fachada.realizarReserva(
                new Estudiante("E001", "Laura"),
                LocalDate.now().plusDays(7),
                LocalTime.of(14, 0),
                2,
                4,
                new SeleccionPorCapacidad())
                .ifPresent(System.out::println);
    }
}