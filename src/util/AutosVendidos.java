package util;


public class AutosVendidos {
    private final static float SUELDO_AL_MES = 2500.00f;
    private final float COMISION_POR_AUTOMOVIL = 250.00f;
    private final float UTILIDAD = 0.05f;
    
    public float calcularComision(int TotalAutos, double valorVentas) {
        return TotalAutos * COMISION_POR_AUTOMOVIL;
    }

    public float calcularUtilidad(double valorVentas) {
        return (float) (valorVentas * UTILIDAD);
    }

    public float calcularMontoFinal(double comisionTotal, double utilidadTotal) {
        return (float) (SUELDO_AL_MES + comisionTotal + utilidadTotal);
    }
    
    public static void emitirReporte(
        int totalAutos, 
        double valorTotalVentas, 
        double comisionTotal, 
        double utilidadTotal, 
        double montoTotalPagar
    ) {
            // Imprimir encabezado del reporte
            System.out.println("\n--- Reporte Mensual de Ventas ---");
            
            // Mostrar número total de autos vendidos
            System.out.println("Número total de autos vendidos: " + totalAutos);
            
            // Mostrar valor total de ventas con formato de moneda
            System.out.printf("Valor total de ventas: $%.2f%n", valorTotalVentas);
            
            // Mostrar sueldo base con formato de moneda
            System.out.printf("Sueldo base: $%.2f%n", SUELDO_AL_MES);
        
        // Mostrar comisión total por autos con formato de moneda
        System.out.printf("Comisión total por autos: $%.2f%n", comisionTotal);
        
        // Mostrar utilidad total con formato de moneda
        System.out.printf("Utilidad total (5%%): $%.2f%n", utilidadTotal);
        
        // Mostrar monto total a pagar con formato de moneda
        System.out.printf("Monto total a pagar: $%.2f%n", montoTotalPagar);
    }
}