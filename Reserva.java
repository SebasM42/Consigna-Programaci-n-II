import java.time.LocalDate;

class Reserva {
    private String cliente;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Habitacion habitacion;


    public Reserva(String cliente, LocalDate fechaEntrada, LocalDate fechaSalida, Habitacion habitacion) {
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.habitacion = habitacion;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    @Override
    public String toString() {
        return "Reserva de " + cliente + " para la habitación " + habitacion.getNumero() +
                " del " + fechaEntrada + " al " + fechaSalida;
    }
}