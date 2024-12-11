package util;

public class AguaPotable {
    public static final float TASA_RECOLECCION_BASURA = 0.75f;
    public static final float TASA_PROCESAMIENTO_DE_DATOS = 0.5f;

    // Método para calcular el cargo por el servicio de agua potable según el consumo
    public static float montoTotalPagar(int consumo) {
        float cargo = 0;

        if (consumo <= 15) {
            cargo = 3;
        } else if (consumo > 15 && consumo <= 25) {
            cargo = 3 + (consumo - 15) * 0.1f;
        } else if (consumo > 25 && consumo <= 40) {
            cargo = 3 + (10 * 0.1f) + (consumo - 25) * 0.2f;
        } else if (consumo > 40 && consumo <= 60) {
            cargo = 3 + (10 * 0.1f) + (15 * 0.2f) + (consumo - 40) * 0.3f;
        } else {
            cargo = 3 + (10 * 0.1f) + (15 * 0.2f) + (20 * 0.3f) + (consumo - 60) * 0.35f;
        }
        return cargo;
    }

    // Método para calcular el impuesto de alcantarillado
    public static float calcularImpuestoAlcantarillado(float cargoServicioAgua) {
        return cargoServicioAgua * 0.35f;
    }

    // Método para calcular el cargo total
    public static double calcularCargoTotal(float cargoServicioAgua, float impuestoAlcantarillado, float tasaRecoleccionBasura, float tasaCostoProcesamiento) {
        return cargoServicioAgua + impuestoAlcantarillado + tasaRecoleccionBasura + tasaCostoProcesamiento;
    }

    // Método para aplicar el descuento según el consumo, edad y discapacidad
    public static double aplicarDescuento(float cargoTotal, float consumo, boolean esTercerEdad, float porcentajeDiscapacidad) {
        if (consumo <= 15 && esTercerEdad) {
            return cargoTotal * 0.5;  // Descuento del 50% si es tercera edad y consumo <= 15
        } else if (consumo > 15) {
            return cargoTotal * 0.7;  // Descuento del 30% si el consumo es mayor a 15
        } else if (porcentajeDiscapacidad > 0) {  // Aplica descuento según el porcentaje de discapacidad
            return cargoTotal * (1 - porcentajeDiscapacidad);
        } else {
            return cargoTotal;  // Sin descuento si no cumple ninguna de las condiciones anteriores
        }
    }

    // Método para calcular la tasa por procesamiento de datos
    public static double calcularTasaCostoProcesamiento() {
        return TASA_PROCESAMIENTO_DE_DATOS;
    }
}