
package CONTROLER;
import MODEL.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConeccionDBFactura {
    private Connection conn;

    public ConeccionDBFactura(Connection conn) {
        this.conn = conn;
    }
    

    public void insertarFactura(Factura factura) throws SQLException {
        String sql = "INSERT INTO facturas (codigo, cliente_id, monto) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, factura.getIdFactura());
            pstmt.setInt(2, factura.getCliente().getId());
            pstmt.setDouble(3, factura.getMonto());
            pstmt.executeUpdate();
        }
    }

    public List<Factura> obtenerFacturasPorCliente(int clienteId) throws SQLException {
        List<Factura> facturas = new ArrayList<>();
        String sql = "SELECT * FROM facturas WHERE cliente_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clienteId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // Construir el objeto Factura según los datos obtenidos de la base de datos
                // Agregar a la lista de facturas
            }
        }
        return facturas;
    }

    public void actualizarFactura(Factura factura) throws SQLException {
        String sql = "UPDATE facturas SET codigo = ?, cliente_id = ?, monto = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, factura.getIdFactura());
            pstmt.setInt(2, factura.getCliente().getId()); 
            pstmt.setDouble(3, factura.getMonto());
            pstmt.setInt(4, factura.getId());
            pstmt.executeUpdate();
        }
    }

    public void eliminarFactura(int facturaId) throws SQLException {
        String sql = "DELETE FROM facturas WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, facturaId);
            pstmt.executeUpdate();
        }
    }
    
}
