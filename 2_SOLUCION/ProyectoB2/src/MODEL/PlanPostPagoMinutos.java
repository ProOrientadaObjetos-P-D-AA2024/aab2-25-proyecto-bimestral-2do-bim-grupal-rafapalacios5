
package MODEL;

public class PlanPostPagoMinutos extends PlanMovil{
    public int minutosNacionales;
    public double costoMinutoNacional;
    public int minutosInternacionales;
    public double costoMinutoInternacional;

    public PlanPostPagoMinutos(String numero, String correo, String tipoPlan, double pagoMensual, int minutosNacionales, double costoMinutoNacional, int minutosInternacionales, double costoMinutoInternacional) {
        super(numero, correo, tipoPlan, pagoMensual);
        this.minutosNacionales = minutosNacionales;
        this.costoMinutoNacional = costoMinutoNacional;
        this.minutosInternacionales = minutosInternacionales;
        this.costoMinutoInternacional = costoMinutoInternacional;
    }

    public int getMinutosNacionales() {
        return minutosNacionales;
    }

    public void setMinutosNacionales(int minutosNacionales) {
        this.minutosNacionales = minutosNacionales;
    }

    public double getCostoMinutoNacional() {
        return costoMinutoNacional;
    }

    public void setCostoMinutoNacional(double costoMinutoNacional) {
        this.costoMinutoNacional = costoMinutoNacional;
    }

    public int getMinutosInternacionales() {
        return minutosInternacionales;
    }

    public void setMinutosInternacionales(int minutosInternacionales) {
        this.minutosInternacionales = minutosInternacionales;
    }

    public double getCostoMinutoInternacional() {
        return costoMinutoInternacional;
    }

    public void setCostoMinutoInternacional(double costoMinutoInternacional) {
        this.costoMinutoInternacional = costoMinutoInternacional;
    }

    
    @Override
    public double calcularPagoMensual() {
        double monto = (minutosNacionales * costoMinutoNacional) + (minutosInternacionales * costoMinutoInternacional);
        return aplicarIVA(monto);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nMinutos Nacionales: %d\nCosto Minuto Nacional: $%.2f\nMinutos Internacionales: %d\nCosto Minuto Internacional: $%.2f",
                minutosNacionales, costoMinutoNacional, minutosInternacionales, costoMinutoInternacional);
    }

    
    
}
