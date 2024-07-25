
package MODEL;
import java.util.Random;
public class Factura {
    public String idFactura;
    public Cliente cliente;
    public static String datosTelefonica = "Telecomunicaciones UTPL\nDirección: Calle Paris \nTeléfono: 0933466212";
    public double monto;
    public int id;

    public Factura(String idFactura, Cliente cliente) {
        this.idFactura = idFactura;
        this.cliente = cliente;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static String getDatosTelefonica() {
        return datosTelefonica;
    }

    public static void setDatosTelefonica(String datosTelefonica) {
        Factura.datosTelefonica = datosTelefonica;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void imprimirFactura() {
        System.out.println("ID Factura: " + idFactura);
        System.out.println(datosTelefonica);
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Cédula: " + cliente.getCedula());
        System.out.println("Ciudad: " + cliente.getCiudad());
        System.out.println("Marca: " + cliente.getMarca());
        System.out.println("Modelo: " + cliente.getModelo());
        System.out.println("Número: " + cliente.getNumero());
        System.out.println("Correo: " + cliente.getCorreo());
        System.out.println("Planes:");
        for (PlanMovil plan : cliente.getPlanes()) {
            System.out.println(" - " + plan.getClass().getSimpleName() + ": $" + plan.calcularPagoMensual());
        }
        System.out.println("Total Mensual: $" + cliente.getPagoMensual());
    }

    
}
