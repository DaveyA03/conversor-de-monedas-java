import java.util.Scanner;

public class Exchanger {
    private final Divisa[] monedas;

    public Exchanger(Divisa[] monedas) {
        this.monedas = monedas;
    }


    public void conversion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cuánto dinero desea convertir? ");
        double cantidad = Double.parseDouble(scanner.nextLine());

        double tasaCambio = 0;

        // segun la tasa de cambio se determina la opcion

        switch (opcion) {
            case 1: // Dólar => Sol peruano
                tasaCambio = monedas[0].getTasaDeCambio();
                break;
            case 2: // Sol peruano => Dólar
                tasaCambio = 1 / monedas[0].getTasaDeCambio();
                break;
            case 3: // Dólar => Peso argentino
                tasaCambio = monedas[1].getTasaDeCambio();
                break;
            case 4: // Peso argentino => Dólar
                tasaCambio = 1 / monedas[1].getTasaDeCambio();
                break;
            case 5: // Dólar => Real brasileño
                tasaCambio = monedas[2].getTasaDeCambio();
                break;
            case 6: // Real brasileño => Dólar
                tasaCambio = 1 / monedas[2].getTasaDeCambio();
                break;
            case 7: // Dólar => Peso colombiano
                tasaCambio = monedas[3].getTasaDeCambio();
                break;
            case 8: // Peso colombiano => Dólar
                tasaCambio = 1 / monedas[3].getTasaDeCambio();
                break;
            case 9: // Dólar => Bs venezolano
                tasaCambio = monedas[4].getTasaDeCambio();
                break;
            case 10: // Bs venezolano => Dólar
                tasaCambio = 1 / monedas[4].getTasaDeCambio();
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        // una sola formula para un dato menor
        double resultado = cantidad * tasaCambio;
        System.out.println("El monto equivalente es: " + resultado + " en la moneda deseada.");
    }
}
