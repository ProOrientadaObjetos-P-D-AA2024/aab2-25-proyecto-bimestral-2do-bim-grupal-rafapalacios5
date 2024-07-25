
package MODEL;

public class PlanPostPagoMinutosMegasEconomico extends PlanMovil{
    public int minutos;
    public double costoMinutos;
    public double gigas;
    public double costoGigas;
    public double descuento;

    public PlanPostPagoMinutosMegasEconomico(String numero, String correo, String tipoPlan, double pagoMensual, int minutos, double costoMinutos, double gigas, double costoGigas, double descuento) {
        super(numero, correo, tipoPlan, pagoMensual);
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
        this.gigas = gigas;
        this.costoGigas = costoGigas;
        this.descuento = descuento;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public double getCostoMinutos() {
        return costoMinutos;
    }

    public void setCostoMinutos(double costoMinutos) {
        this.costoMinutos = costoMinutos;
    }

    public double getGigas() {
        return gigas;
    }

    public void setGigas(double gigas) {
        this.gigas = gigas;
    }

    public double getCostoGigas() {
        return costoGigas;
    }

    public void setCostoGigas(double costoGigas) {
        this.costoGigas = costoGigas;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double calcularPagoMensual() {
        double monto = (minutos * costoMinutos) + (gigas * costoGigas);
        monto -= monto * (descuento / 100);
        return aplicarIVA(monto);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nMinutos: %d\nCosto Minutos: $%.2f\nGigas: %.2f\nCosto Gigas: $%.2f\nDescuento: %.2f%%",
                minutos, costoMinutos, gigas, costoGigas, descuento);
    }
     
}
