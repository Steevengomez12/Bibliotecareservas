package biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private final String codigo;
    private final Estudiante estudiante;
    private final LocalDate fecha;
    private final LocalTime horaInicio;
    private final int duracionHoras;
    private final int cantidadPersonas;
    private final Sala sala;
    private String estado = "Pendiente";
    private final List<ObservadorReserva> observadores = new ArrayList<>();

    Reserva(String codigo, Estudiante estudiante, LocalDate fecha,
            LocalTime horaInicio, int duracionHoras, int cantidadPersonas, Sala sala) {
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracionHoras = duracionHoras;
        this.cantidadPersonas = cantidadPersonas;
        this.sala = sala;
    }

    public String getCodigo() { return codigo; }
    public Estudiante getEstudiante() { return estudiante; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public int getDuracionHoras() { return duracionHoras; }
    public int getCantidadPersonas() { return cantidadPersonas; }
    public Sala getSala() { return sala; }
    public String getNombreEstado() { return estado; }

    public void agregarObservador(ObservadorReserva observador) {
        if (observador != null) observadores.add(observador);
    }

    public void retirarObservador(ObservadorReserva observador) {
        observadores.remove(observador);
    }

    public void confirmar() { cambiarEstado("Confirmada"); }
    public void cancelar() { cambiarEstado("Cancelada"); }
    public void finalizar() { cambiarEstado("Finalizada"); }

    private void cambiarEstado(String nuevoEstado) {
        if (estado.equals("Cancelada") || estado.equals("Finalizada")) {
            throw new IllegalStateException("La reserva ya no admite cambios.");
        }
        if (estado.equals("Confirmada") && nuevoEstado.equals("Confirmada")) {
            throw new IllegalStateException("La reserva ya está confirmada.");
        }
        String anterior = estado;
        estado = nuevoEstado;
        for (ObservadorReserva observador : List.copyOf(observadores)) {
            observador.actualizar(this, anterior, estado);
        }
    }

    @Override
    public String toString() {
        return "Reserva " + codigo + " | " + estudiante.getNombre()
                + " | " + fecha + " " + horaInicio + " | " + sala
                + " | Estado: " + estado;
    }
}