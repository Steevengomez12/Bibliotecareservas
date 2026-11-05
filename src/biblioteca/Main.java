package biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReservaFacade fachada = new ReservaFacade(
                new RepositorioSalasMemoria(),
                new RepositorioReservasMemoria(),
                List.of(new NotificadorEstudiante(), new RegistroEventos()));
        Reserva reserva = fachada.realizarReserva(
                new Estudiante("E001", "Laura"), LocalDate.now().plusDays(7),
                LocalTime.of(14, 0), 2, 4, new SeleccionPorCapacidad()).orElseThrow();
        System.out.println(reserva);
        reserva.cancelar();
        System.out.println(reserva);
    }
}