
package CONTROLER;
import MODEL.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConeccionDBClientes {
    
    public void agregarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, apellido, cedula, ciudad, marca, modelo, numero, correo, pagoMensual) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = establecerConeccion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getCedula());
            pstmt.setString(4, cliente.getCiudad());
            pstmt.setString(5, cliente.getMarca());
            pstmt.setString(6, cliente.getModelo());
            pstmt.setString(7, cliente.getNumero());
            pstmt.setString(8, cliente.getCorreo());
            pstmt.setDouble(9, cliente.getPagoMensual());
            pstmt.executeUpdate();
        }
    }

    public Cliente obtenerCliente(String cedula) {
        String sql = "SELECT * FROM clientes WHERE cedula = ?";
        Cliente cliente = null;

        try (Connection conn = establecerConeccion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cedula);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente(rs.getString("nombre"), rs.getString("apellido"), rs.getString("cedula"),
                        rs.getString("ciudad"), rs.getString("marca"), rs.getString("modelo"),
                        rs.getString("numero"), rs.getString("correo"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    public void actualizarClienteCorreo(String cedula, String correo) {
        String sql = "UPDATE clientes SET correo = ? WHERE cedula = ?";

        try (Connection conn = establecerConeccion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            pstmt.setString(2, cedula);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarClienteNumero(String cedula, String numero) {
        String sql = "UPDATE clientes SET numero = ? WHERE cedula = ?";

        try (Connection conn = establecerConeccion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numero);
            pstmt.setString(2, cedula);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarClienteCiudad(String cedula, String ciudad) {
        String sql = "UPDATE clientes SET ciudad = ? WHERE cedula = ?";

        try (Connection conn = establecerConeccion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ciudad);
            pstmt.setString(2, cedula);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarCliente(String cedula) {
        String sql = "DELETE FROM clientes WHERE cedula = ?";

        try (Connection conn = establecerConeccion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cedula);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM clientes";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conn = establecerConeccion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("nombre"), rs.getString("apellido"), rs.getString("cedula"),
                        rs.getString("ciudad"), rs.getString("marca"), rs.getString("modelo"),
                        rs.getString("numero"), rs.getString("correo"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }
}
