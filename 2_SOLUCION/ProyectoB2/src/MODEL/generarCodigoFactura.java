
package MODEL;
public class generarCodigoFactura {
    private static final String PREFIJO = "123477737"; // Parte fija del código
    private static int contador = 1; // Contador para los últimos dígitos

    public static String generarCodigoFactura() {
        // Asegurarse de que el contador tenga siempre 3 dígitos
        String codigo = PREFIJO + String.format("%03d", contador);
        contador++;
        return codigo;
    }
}
