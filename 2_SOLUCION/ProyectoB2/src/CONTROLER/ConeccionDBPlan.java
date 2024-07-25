
package CONTROLER;
import MODEL.PlanMovil;
import MODEL.PlanPostPagoMegas;
import MODEL.PlanPostPagoMinutos;
import MODEL.PlanPostPagoMinutosMegas;
import MODEL.PlanPostPagoMinutosMegasEconomico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ConeccionDBPlan {
    private Connection conn;

    public ConeccionDBPlan() {
        conn = establecerConeccion.connect();
    }

    public void insertarPlan(PlanMovil plan, int clienteId) throws SQLException {
        String sql = "INSERT INTO planes (cliente_id, tipo_plan, minutos, costo_minutos, gigas, costo_gigas, descuento, tarifa_base, minutos_internacionales, costo_minuto_internacional) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clienteId);
            pstmt.setString(2, plan.getTipoPlan());
            pstmt.setInt(3, plan instanceof PlanPostPagoMinutos ? ((PlanPostPagoMinutos) plan).getMinutosNacionales() : 0);
            pstmt.setDouble(4, plan instanceof PlanPostPagoMinutos ? ((PlanPostPagoMinutos) plan).getMinutosNacionales() : 0.0);
            pstmt.setDouble(5, plan instanceof PlanPostPagoMegas ? ((PlanPostPagoMegas) plan).getGigas() : 0.0);
            pstmt.setDouble(6, plan instanceof PlanPostPagoMegas ? ((PlanPostPagoMegas) plan).getCostoGigas() : 0.0);
            pstmt.setDouble(7, plan instanceof PlanPostPagoMinutosMegasEconomico ? ((PlanPostPagoMinutosMegasEconomico) plan).getDescuento() : 0.0);
            pstmt.setDouble(8, plan instanceof PlanPostPagoMegas ? ((PlanPostPagoMegas) plan).getTarifaBase() : 0.0);
            pstmt.setInt(9, plan instanceof PlanPostPagoMinutosMegas ? ((PlanPostPagoMinutosMegas) plan).getMinutos() : 0);
            pstmt.setDouble(10, plan instanceof PlanPostPagoMinutosMegas ? ((PlanPostPagoMinutosMegas) plan).getCostoMinutos() : 0.0);
            pstmt.executeUpdate();
        }
    }

    public List<PlanMovil> obtenerPlanesPorCliente(int clienteId) throws SQLException {
        List<PlanMovil> planes = new ArrayList<>();
        String sql = "SELECT * FROM planes WHERE cliente_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clienteId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                
            }
        }
        return planes;
    }

    public void actualizarPlan(PlanMovil plan) throws SQLException {
        String sql = "UPDATE planes SET tipo_plan = ?, minutos = ?, costo_minutos = ?, gigas = ?, costo_gigas = ?, descuento = ?, tarifa_base = ?, minutos_internacionales = ?, costo_minuto_internacional = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Asigna los valores adecuados de acuerdo al tipo de plan
            pstmt.setString(1, plan.getTipoPlan());
            pstmt.setInt(2, plan instanceof PlanPostPagoMinutos ? ((PlanPostPagoMinutos) plan).getMinutosInternacionales() : 0);
            pstmt.setDouble(3, plan instanceof PlanPostPagoMinutos ? ((PlanPostPagoMinutos) plan).getCostoMinutoInternacional() : 0.0);
            pstmt.setDouble(4, plan instanceof PlanPostPagoMegas ? ((PlanPostPagoMegas) plan).getGigas() : 0.0);
            pstmt.setDouble(5, plan instanceof PlanPostPagoMegas ? ((PlanPostPagoMegas) plan).getCostoGigas() : 0.0);
            pstmt.setDouble(6, plan instanceof PlanPostPagoMinutosMegasEconomico ? ((PlanPostPagoMinutosMegasEconomico) plan).getDescuento() : 0.0);
            pstmt.setDouble(7, plan instanceof PlanPostPagoMegas ? ((PlanPostPagoMegas) plan).getTarifaBase() : 0.0);
            pstmt.setInt(8, plan instanceof PlanPostPagoMinutosMegas ? ((PlanPostPagoMinutosMegas) plan).getMinutos(): 0);
            pstmt.setDouble(9, plan instanceof PlanPostPagoMinutosMegas ? ((PlanPostPagoMinutosMegas) plan).getCostoMinutos(): 0.0);
            pstmt.setInt(10, plan.getId());
            pstmt.executeUpdate();
        }
    }

    public void eliminarPlan(int planId) throws SQLException {
        String sql = "DELETE FROM planes WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, planId);
            pstmt.executeUpdate();
        }
    }
}
