import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // Agregar habitaciones
        hotel.agregarHabitacion(new Habitacion(101, "Simple", 50.0));
        hotel.agregarHabitacion(new Habitacion(102, "Doble", 80.0));
        hotel.agregarHabitacion(new Habitacion(103, "Suite", 150.0));


        // Mostrar habitaciones
        System.out.println("Habitaciones disponibles:");
        hotel.mostrarHabitaciones();


        // Crear reservas
        System.out.println("\nCreando reservas...");
        if (hotel.crearReserva("Carlos", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 5), 101)) {
            System.out.println("Reserva creada exitosamente.");
        } else {
            System.out.println("No se pudo crear la reserva.");
        }

        if (hotel.crearReserva("Ana", LocalDate.of(2023, 10, 3), LocalDate.of(2023, 10, 7), 102)) {
            System.out.println("Reserva creada exitosamente.");
        } else {
            System.out.println("No se pudo crear la reserva.");
        }

        // Intentar reservar una habitación ocupada
        if (hotel.crearReserva("Luis", LocalDate.of(2023, 10, 6), LocalDate.of(2023, 10, 10), 101)) {
            System.out.println("Reserva creada exitosamente.");
        } else {
            System.out.println("No se pudo crear la reserva. Habitación ocupada.");
        }

        // Mostrar reservas
        System.out.println("\nReservas actuales:");
        hotel.mostrarReservas();

        // Verificar disponibilidad
        System.out.println("\nVerificando disponibilidad de la habitación 101:");
        System.out.println(hotel.verificarDisponibilidad(101) ? "Disponible" : "Ocupada");
    }
}