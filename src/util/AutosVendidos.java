package util;

public class AutosVendidos {
    private final static float SUELDO_AL_MES = 2500.00f;    
    private final float COMISION_POR_AUTOMOVIL = 250.00f;    
    private final float UTILIDAD = 0.05f;
    
    // Método para calcular la comisión total, basado en el número de autos vendidos
    public float calcularComision(int TotalAutos, double valorVentas) {
        return TotalAutos * COMISION_POR_AUTOMOVIL;
    }

    // Método para calcular la utilidad, que es un 5% del valor de ventas
    public float calcularUtilidad(double valorVentas) {
        return (float) (valorVentas * UTILIDAD);
    }

    // Método para calcular el monto final a pagar, que incluye el sueldo base, la comisión y la utilidad
    public float calcularMontoFinal(double comisionTotal, double utilidadTotal) {
        return (float) (SUELDO_AL_MES + comisionTotal + utilidadTotal);
    }
    
    // Método estático para emitir un reporte con los detalles de ventas y sueldos
    public static void emitirReporte(
        int totalAutos, 
        double valorTotalVentas, 
        double comisionTotal, 
        double utilidadTotal, 
        double montoTotalPagar
    ) {
        System.out.println("\n--- Reporte Mensual de Ventas ---");
        
        // Mostrar número total de autos vendidos
        System.out.println("Número total de autos vendidos: " + totalAutos);
        
        // Mostrar valor total de ventas
        System.out.printf("Valor total de ventas: $%.2f%n", valorTotalVentas);
        
        // Mostrar sueldo base 
        System.out.printf("Sueldo base: $%.2f%n", SUELDO_AL_MES);
    
        // Mostrar comisión total por autos
        System.out.printf("Comisión total por autos: $%.2f%n", comisionTotal);
        
        // Mostrar utilidad total
        System.out.printf("Utilidad total (5%%): $%.2f%n", utilidadTotal);
        
        // Mostrar monto total a pagar
        System.out.printf("Monto total a pagar: $%.2f%n", montoTotalPagar);
    }
}