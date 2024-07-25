
package MODEL;

public class PlanPostPagoMinutosMegas extends PlanMovil{
    public int minutos;
    public double costoMinutos;
    public double gigas;
    public double costoGigas;

    public PlanPostPagoMinutosMegas(String numero, String correo, String tipoPlan, double pagoMensual, int minutos, double costoMinutos, double gigas, double costoGigas) {
        super(numero, correo, tipoPlan, pagoMensual);
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
        this.gigas = gigas;
        this.costoGigas = costoGigas;
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

    @Override
    public double calcularPagoMensual() {
        double monto = (minutos * costoMinutos) + (gigas * costoGigas);
        return aplicarIVA(monto);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nMinutos: %d\nCosto Minutos: $%.2f\nGigas: %.2f\nCosto Gigas: $%.2f",
                minutos, costoMinutos, gigas, costoGigas);
    }
    
}
