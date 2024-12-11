package util;

import java.util.Scanner;

public class LlamadaInternacional {

    // ZONA: America del Norte
    private static final int AMERICA_DEL_NORTE_CLAVE = 12;
    private static final float AMERICA_DEL_NORTE_PRECIO_MINUTO = 2.75f;

    // ZONA: America Central
    private static final int AMERICA_CENTRAL_CLAVE = 15;
    private static final float AMERICA_CENTRAL_PRECIO_MINUTO = 1.89f;

    // ZONA: America del Sur
    private static final int AMERICA_DEL_SUR_CLAVE = 18;
    private static final float AMERICA_DEL_SUR_PRECIO_MINUTO = 1.60f;

    // ZONA: Europa
    private static final int EUROPA_CLAVE = 19;
    private static final float EUROPA_PRECIO_MINUTO = 3.5f;

    // ZONA: Asia
    private static final int ASIA_CLAVE = 23;
    private static final float ASIA_PRECIO_MINUTO = 4.5f;

    // ZONA: Africa
    private static final int AFRICA_CLAVE = 25;
    private static final float AFRICA_PRECIO_MINUTO = 3.1f;

    // ZONA: Oceania
    private static final int OCEANIA_CLAVE = 29;
    private static final float OCEANIA_PRECIO_MINUTO = 3.0f;

    // ZONA: Resto del mundo
    private static final int RESTO_DEL_MUNDO_CLAVE = 31;
    private static final float RESTO_DEL_MUNDO_PRECIO_MINUTO = 6.0f;

    public static Zona obtenerZonaDesdeEntrada(String entrada, Scanner scanner) {
        while (true) {
            String entradaNormalizada = entrada.replace(" ", "_");

            if (entradaNormalizada.equalsIgnoreCase("AMERICA_DEL_NORTE")) {
                return Zona.AMERICA_DEL_NORTE;
            } else if (entradaNormalizada.equalsIgnoreCase("AMERICA_CENTRAL")) {
                return Zona.AMERICA_CENTRAL;
            } else if (entradaNormalizada.equalsIgnoreCase("AMERICA_DEL_SUR")) {
                return Zona.AMERICA_DEL_SUR;
            } else if (entradaNormalizada.equalsIgnoreCase("EUROPA")) {
                return Zona.EUROPA;
            } else if (entradaNormalizada.equalsIgnoreCase("ASIA")) {
                return Zona.ASIA;
            } else if (entradaNormalizada.equalsIgnoreCase("AFRICA")) {
                return Zona.AFRICA;
            } else if (entradaNormalizada.equalsIgnoreCase("OCEANIA")) {
                return Zona.OCEANIA;
            } else if (entradaNormalizada.equalsIgnoreCase("RESTO_DEL_MUNDO")) {
                return Zona.RESTO_DEL_MUNDO;
            } else {
                System.out.println("Zona de destino no válida. Por favor, intente de nuevo:");
                entrada = scanner.nextLine();
            }
        }
    }

    public float calcularPrecioTotal(Zona zona, int minutos) {
        return zona.getPrecioMinuto() * minutos;
    }

    public enum Zona {
        AMERICA_DEL_NORTE(AMERICA_DEL_NORTE_CLAVE, AMERICA_DEL_NORTE_PRECIO_MINUTO),
        AMERICA_CENTRAL(AMERICA_CENTRAL_CLAVE, AMERICA_CENTRAL_PRECIO_MINUTO),
        AMERICA_DEL_SUR(AMERICA_DEL_SUR_CLAVE, AMERICA_DEL_SUR_PRECIO_MINUTO),
        EUROPA(EUROPA_CLAVE, EUROPA_PRECIO_MINUTO),
        ASIA(ASIA_CLAVE, ASIA_PRECIO_MINUTO),
        AFRICA(AFRICA_CLAVE, AFRICA_PRECIO_MINUTO),
        OCEANIA(OCEANIA_CLAVE, OCEANIA_PRECIO_MINUTO),
        RESTO_DEL_MUNDO(RESTO_DEL_MUNDO_CLAVE, RESTO_DEL_MUNDO_PRECIO_MINUTO);

        private final int clave;
        private final float precioMinuto;

        Zona(int clave, float precioMinuto) {
            this.clave = clave;
            this.precioMinuto = precioMinuto;
        }

        public int getClave() {
            return clave;
        }

        public float getPrecioMinuto() {
            return precioMinuto;
        }
    }
}
