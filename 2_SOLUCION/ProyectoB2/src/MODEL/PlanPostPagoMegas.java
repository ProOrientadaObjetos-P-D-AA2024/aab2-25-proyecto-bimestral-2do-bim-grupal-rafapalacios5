
package MODEL;

public class PlanPostPagoMegas extends PlanMovil {
    public double gigas;
    public double costoGigas;
    public double tarifaBase;

    public PlanPostPagoMegas(String numero, String correo, String tipoPlan, double pagoMensual, double gigas, double costoGigas, double tarifaBase) {
        super(numero, correo, tipoPlan, pagoMensual);
        this.gigas = gigas;
        this.costoGigas = costoGigas;
        this.tarifaBase = tarifaBase;
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

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    @Override
    public double calcularPagoMensual() {
        double monto = (gigas * costoGigas) + tarifaBase;
        return aplicarIVA(monto);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nGigas: %.2f\nCosto Gigas: $%.2f\nTarifa Base: $%.2f",
                gigas, costoGigas, tarifaBase);
    }
    
}
