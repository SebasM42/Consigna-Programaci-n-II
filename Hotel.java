import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Hotel {
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel() {
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public Habitacion buscarHabitacionPorNumero(int numero) {
        return habitaciones.stream()
                .filter(h -> h.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    public boolean verificarDisponibilidad(int numero) {
        Habitacion habitacion = buscarHabitacionPorNumero(numero);
        return habitacion != null && habitacion.isDisponible();
    }

    public boolean crearReserva(String cliente, LocalDate fechaEntrada, LocalDate fechaSalida, int numeroHabitacion) {
        Habitacion habitacion = buscarHabitacionPorNumero(numeroHabitacion);
        if (habitacion != null && habitacion.isDisponible()) {
            Reserva reserva = new Reserva(cliente, fechaEntrada, fechaSalida, habitacion);
            reservas.add(reserva);
            habitacion.setDisponible(false); // Marcar la habitación como ocupada
            return true;
        }
        return false;
    }

    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
        } else {
            reservas.forEach(System.out::println);
        }
    }

    public void mostrarHabitaciones() {
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
        } else {
            habitaciones.forEach(System.out::println);
        }
    }
}