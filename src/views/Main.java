package views;

import java.util.Scanner;
import util.AutosVendidos;
import util.LlamadaInternacional;
import util.LlamadaInternacional.Zona;
import util.AguaPotable;
import util.Serial;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Practica N° 4 =======");
        System.out.println("\nOPCIONES:");
        System.out.println("1. Compania de Autos:");
        System.out.println("2. Llamada Telefonica");
        System.out.println("3. Agua Potable:");
        System.out.println("4. Serie");

        System.out.print("\nElija una opcion: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                AutosVendidos auto_vendido = new AutosVendidos();
                int totalAutosVendidos = 0;
                double valorVentas = 0.0;

                System.out.println("\n---------- INFORME ----------");

                while (true) {
                    System.out.print("Ingrese el valor del auto: ");
                    float valor_auto = scanner.nextFloat();

                    if (valor_auto == 0) {
                        break;
                    }
                    totalAutosVendidos++;
                    valorVentas += valor_auto;
                }
                double comisionTotal = auto_vendido.calcularComision(totalAutosVendidos, valorVentas);
                double utilidadTotal = auto_vendido.calcularUtilidad(valorVentas);
                double montoTotalPagar = auto_vendido.calcularMontoFinal(comisionTotal, utilidadTotal);

                AutosVendidos.emitirReporte(
                        totalAutosVendidos,
                        valorVentas,
                        comisionTotal,
                        utilidadTotal,
                        montoTotalPagar);
            case 2:
                System.out.println("\n---------- LLAMADAS INTERNACIONALES ----------");
                System.out.print("Ingrese el continenete destino(Ejemplo: America del Sur):");
                scanner.nextLine();
                LlamadaInternacional llamada = new LlamadaInternacional();
                Zona zonaDestino = LlamadaInternacional.obtenerZonaDesdeEntrada(scanner.nextLine(), scanner);

                System.out.print("Ingrese la cantidad de minutos que realizo la llamada: ");
                int minutos = scanner.nextInt();

                float costoTotal = llamada.calcularPrecioTotal(zonaDestino, minutos);

                System.out.printf("El costo de la llamada de %d minutos a la zona %s es: $%.2f%n", minutos,
                        zonaDestino.name(), costoTotal);
                break;

            case 3:
                System.out.println("\n---------- SISTEMA DE AGUA POTABLE ----------");
                System.out.print("Ingrese el consumo de agua potable en metros cúbicos: ");
                int consumo = scanner.nextInt();

                // Solicitar y obtener la pertenencia a la tercera edad del usuario
                System.out.print("¿Pertenece a la tercera edad? (S/N): ");
                boolean esTercerEdad = scanner.next().equalsIgnoreCase("S");

                // Solicitar y obtener la discapacidad del usuario
                System.out.print("¿Es discapacitado? (S/N): ");
                boolean esDiscapacitado = scanner.next().equalsIgnoreCase("S");

                // Obtener el porcentaje de discapacidad si aplica
                float porcentajeDiscapacidad = 0; // Default sin discapacidad
                if (esDiscapacitado) {
                    System.out.print("Ingrese el porcentaje de discapacidad (0 a 1): ");
                    porcentajeDiscapacidad = scanner.nextFloat(); // El porcentaje es entre 0 y 1 (Ejemplo: 0.5 para
                                                                  // 50%)
                }

                // Calcular el cargo por el servicio de agua potable
                float cargoServicioAgua = AguaPotable.montoTotalPagar(consumo);

                // Calcular el impuesto de alcantarillado
                double impuestoAlcantarillado = AguaPotable.calcularImpuestoAlcantarillado(cargoServicioAgua);

                // Calcular la tasa por recolección de basura
                double tasaRecoleccionBasura = AguaPotable.TASA_RECOLECCION_BASURA;

                // Calcular la tasa por costo de procesamiento de datos
                double tasaCostoProcesamiento = AguaPotable.calcularTasaCostoProcesamiento();

                // Calcular el cargo total a pagar sin descuento
                double cargoTotal = AguaPotable.calcularCargoTotal(cargoServicioAgua, (float) impuestoAlcantarillado,
                        (float) tasaRecoleccionBasura, (float) tasaCostoProcesamiento);

                // Aplicar el descuento correspondiente y calcular el cargo total a pagar con
                // descuento
                double cargoTotalConDescuento = AguaPotable.aplicarDescuento((float) cargoTotal, consumo, esTercerEdad,
                        porcentajeDiscapacidad);

                // Imprimir los resultados
                System.out.printf("\nCargo por servicio de agua potable -----------\n$%.2f%n", cargoServicioAgua);
                System.out.printf("Impuesto de alcantarillado ---------------------\n$%.2f%n", impuestoAlcantarillado);
                System.out.printf("Tasa por recolección de basura ----------------- \n$%.2f%n", tasaRecoleccionBasura);
                System.out.printf("Tasa por costo de procesamiento de datos ------- \n$%.2f%n", tasaCostoProcesamiento);
                System.out.printf("Cargo total a pagar ---------------------------- \n$%.2f%n", cargoTotal);
                System.out.printf("Cargo total a pagar con descuento -------------- \n$%.2f%n", cargoTotalConDescuento);
                break;

            case 4:
                System.out.println("\n---------- SERIAL ----------");
                System.out.print("Ingrese el número de términos que desea generar: ");
                int numTerminos = scanner.nextInt();

                if (numTerminos <= 0) {
                    System.out.println("Por favor, ingrese un número positivo.");
                } else {
                    // Calcular la serie y mostrar los términos
                    double resultadoFinal = Serial.calcularSerie(numTerminos);

                    // Mostrar el resultado final de la serie con 2 decimales
                    System.out.printf("\nEl resultado final de la serie es: %.2f\n", resultadoFinal);
                }
                break;
            default:
                System.out.println("Ingrese la opcion correcta...");
                break;
        }
    }
}
