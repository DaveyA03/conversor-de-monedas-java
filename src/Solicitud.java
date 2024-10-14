import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Solicitud {
    private final String API_KEY = "fb50ce026a9f0a7371c20783";
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/";

    public Divisa[] obtenerMonedas() {
        Divisa[] monedas = new Divisa[5];

        try {
            String urlString = URL_BASE + API_KEY + "/latest/USD"; // USD es la divisa base
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

          // Se utiliza json
            String jsonResponse = response.toString();
            String[] monedasCodigos = {"PEN", "ARS", "BRL", "COP", "VES"};
            for (int i = 0; i < monedasCodigos.length; i++) {
                double tasaDeCambio = parseTasaDeCambio(jsonResponse, monedasCodigos[i]);

                monedas[i] = new Divisa(monedasCodigos[i], tasaDeCambio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monedas;
    }

    private double parseTasaDeCambio(String jsonResponse, String moneda)
    {
        // Aquí se puede usar una librería JSON como Gson para procesar la respuesta.

        String key = "\"" + moneda + "\":";
        int index = jsonResponse.indexOf(key);

        if (index != -1) {

            int startIndex = index + key.length();
            int endIndex = jsonResponse.indexOf(",", startIndex);
            String tasaString = jsonResponse.substring(startIndex, endIndex);

            return Double.parseDouble(tasaString);
        }
        return 0;
    }
}
