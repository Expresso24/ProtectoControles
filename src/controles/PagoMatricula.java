package controles;

public class PagoMatricula {
    private String carrera;
    private String turno;
    private String metodoPago;

    public PagoMatricula(String carrera, String turno, String metodoPago) {
        this.carrera = carrera;
        this.turno = turno;
        this.metodoPago = metodoPago;
    }

    public double calcularPago() {
        double precioBase = obtenerPrecioBase();
        double recargoTurno = obtenerRecargoTurno();
        double subtotal = precioBase + recargoTurno;
        double total = aplicarMetodoPago(subtotal);
        return total;
    }

    private double obtenerPrecioBase() {
        switch (carrera) {
            case "Desarrollo de Software":
                return 1000;
            case "Diseño Electrónico":
                return 500;
            case "Mecatrónica":
                return 800;
            case "Industrial":
                return 300;
            default:
                throw new IllegalArgumentException("Carrera no válida");
        }
    }

    private double obtenerRecargoTurno() {
        switch (turno) {
            case "Matutino":
                return 500;
            case "Vespertino":
                return 250;
            default:
                return 1;
        }
    }

        private double aplicarMetodoPago(double subtotal) {
        double iva = subtotal * 0.16;
        double total = subtotal + iva;

        if (metodoPago.equals("Tarjeta")) {
            double comision = total * 0.10;
            total += comision;
        }

        return total;
    }
}
