package util;

public class Serial {
    // Serial: (1 / 1)^2 + (1 / 3)^4 - (2 / 5)^6 - (3 / 7)^8 + (5 / 9)^10 + (8 / 11)^12 ...
    public static double potencia(double base, int exponente) {
        double resultado = 1;
        for (int i = 1; i <= exponente; i++) {
            resultado = resultado * base;
        }
        return resultado;
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1, b = 1, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // Método para calcular la serie completa
    public static double calcularSerie(int numTerminos) {
        double resultado = 0;
        int signo = 1;

        System.out.print("\n");
        for (int i = 1; i <= numTerminos; i++) {
            int numerador = fibonacci(i);
            int denominador = 2 * i - 1;
            int exponente = 2 * i;

            double termino = potencia((double) numerador / denominador, exponente);

            if (signo == 1) {
                System.out.printf("+ (%.0f / %d)^%d ", (double) numerador, denominador, exponente);
                resultado += termino; // Sumamos el término al resultado
            } else {
                System.out.printf("- (%.0f / %d)^%d ", (double) numerador, denominador, exponente);
                resultado -= termino;
            }

            if (i % 2 == 0) {
                signo = 1;
            } else {
                signo = -1;
            }
        }

        return resultado;
    }
}