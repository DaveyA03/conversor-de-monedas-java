import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        //Menú de la applicacion
        while (continuar) {
            System.out.println("*************************************");
            System.out.println("**      Conversor de Monedas       **");
            System.out.println("*************************************");
            System.out.println("  1)   Dólar => Sol peruano");
            System.out.println("  2)   Sol peruano => Dólar");
            System.out.println("  3)   Dólar => Peso argentino");
            System.out.println("  4)   Peso argentino => Dólar");
            System.out.println("  5)   Dólar => Real brasileño");
            System.out.println("  6)   Real brasileño => Dólar");
            System.out.println("  7)   Dólar => Peso colombiano");
            System.out.println("  8)   Peso colombiano => Dólar");
            System.out.println("  9)   Dólar => Bs venezolano");
            System.out.println(" 10)   Bs venezolano => Dólar");
            System.out.println(" 11)   Salir");
            System.out.print("Elija una opción válida: ");

            //Opciones
            int opcion = Integer.parseInt(scanner.nextLine());
            //Output
            if (opcion == 11) {
                continuar = false;
                int hora = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY);
                if (hora < 12) {
                    System.out.println("Feliz  dia, hasta pronto!");
                } else {
                    System.out.println("Feliz Tarde , hasta pronto!");
                }
                break;
            }

            // API  de consulta
            Solicitud apiConsulta = new Solicitud();
            Divisa[] monedas = apiConsulta.obtenerMonedas();

            //  Crear instancia exchanger
            Exchanger conversor = new Exchanger(monedas);
            conversor.conversion(opcion);

            //  Parte para continuar la conversion
            System.out.print("¿Le gustaria contiuar haciendo otras conversiones? (si/no): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("si")) {
                continuar = false;
                int hora = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY);
                if (hora < 12) {
                    System.out.println("Buenos día!");
                } else {
                    System.out.println("Buenas tardes");
                }
            }
        }

        scanner.close();
    }
}
