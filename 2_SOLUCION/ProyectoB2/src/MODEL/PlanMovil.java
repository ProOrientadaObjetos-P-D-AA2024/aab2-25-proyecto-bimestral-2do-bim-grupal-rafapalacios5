
package MODEL;

public abstract class PlanMovil {
    public int id;
    public String numero;
    public String correo;
    public String tipoPlan;
    public double pagoMensual;
    public double IVA;

    public PlanMovil(String numero, String correo, String tipoPlan, double pagoMensual) {
        this.numero = numero;
        this.correo = correo;
        this.tipoPlan = tipoPlan;
        this.pagoMensual = pagoMensual;
        this.IVA = 0.15; 
    }

    public abstract double calcularPagoMensual();

    protected double aplicarIVA(double monto) {
        return monto * (1 + IVA);
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

    public String getTipoPlan() {
        return tipoPlan;
    }
    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }
    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public double getIVA() {
        return IVA;
    }
    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return String.format("Tipo de Plan: %s\nNúmero: %s\nCorreo: %s\nPago Mensual: $%.2f",
                tipoPlan, numero, correo, calcularPagoMensual());
    }
    
}
