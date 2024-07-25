
package MODEL;
import java.util.ArrayList;
import java.util.List;
public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String ciudad;
    private String marca;
    private String modelo;
    private String numero;
    private String correo;
    private List<PlanMovil> planes;
    private double pagoMensual;

    public Cliente(String nombre, String apellido, String cedula, String ciudad, String marca, String modelo, String numero, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.marca = marca;
        this.modelo = modelo;
        this.numero = numero;
        this.correo = correo;
        this.planes = new ArrayList<>();
        this.pagoMensual = 0.0;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<PlanMovil> getPlanes() {
        return planes;
    }
    public void setPlanes(List<PlanMovil> planes) {
        this.planes = planes;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }
    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public void agregarPlan(PlanMovil plan) {
        this.planes.add(plan);
        this.pagoMensual += plan.calcularPagoMensual();
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Nombre: %s %s\nCédula: %s\nCiudad: %s\nMarca: %s\nModelo: %s\nNúmero: %s\nCorreo: %s\n",
                nombre, apellido, cedula, ciudad, marca, modelo, numero, correo));
        sb.append("Planes:\n");
        for (PlanMovil plan : planes) {
            sb.append(plan.toString()).append("\n");
        }
        sb.append(String.format("Pago Mensual Total: $%.2f", pagoMensual));
        return sb.toString();
    }
    
}
