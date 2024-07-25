package VIEW;
import CONTROLER.ConeccionDBClientes;
import MODEL.Cliente;
import MODEL.Factura;
import MODEL.PlanMovil;
import MODEL.PlanPostPagoMegas;
import MODEL.PlanPostPagoMinutos;
import MODEL.PlanPostPagoMinutosMegas;
import MODEL.PlanPostPagoMinutosMegasEconomico;
import MODEL.generarCodigoFactura;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;


public class GestionarCliente {
    private static ConeccionDBClientes clienteDAO = new ConeccionDBClientes();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSistema de Gestión de Clientes y Facturación de Telecomunicaciones");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Consultar Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Listar Clientes");
            System.out.println("6. Imprimir Factura");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    imprimirFactura();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void agregarCliente() throws SQLException {
        System.out.println("\nAgregar Cliente:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, cedula, ciudad, marca, modelo, numero, correo);

        // Agregar planes al cliente
        System.out.println("\nSeleccionar planes para el cliente:");
        seleccionarPlanes(cliente);

        // Guardar cliente en la base de datos
        clienteDAO.agregarCliente(cliente);
        System.out.println("Cliente agregado exitosamente.");
    }

    private static void consultarCliente() {
        System.out.println("\nConsultar Cliente:");
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        Cliente cliente = clienteDAO.obtenerCliente(cedula);

        if (cliente != null) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Ciudad: " + cliente.getCiudad());
            System.out.println("Marca: " + cliente.getMarca());
            System.out.println("Modelo: " + cliente.getModelo());
            System.out.println("Número: " + cliente.getNumero());
            System.out.println("Correo: " + cliente.getCorreo());
            System.out.println("Planes: ");
            for (PlanMovil plan : cliente.getPlanes()) {
                System.out.println(" - " + plan.getClass().getSimpleName() + ": $" + plan.calcularPagoMensual());
            }
            System.out.println("Pago Mensual Total: $" + cliente.getPagoMensual());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void actualizarCliente() {
        System.out.println("\nActualizar Cliente:");
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        Cliente cliente = clienteDAO.obtenerCliente(cedula);

        if (cliente != null) {
            System.out.println("Seleccione el campo a actualizar:");
            System.out.println("1. Correo");
            System.out.println("2. Número");
            System.out.println("3. Ciudad");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo Correo: ");
                    String nuevoCorreo = scanner.nextLine();
                    clienteDAO.actualizarClienteCorreo(cedula, nuevoCorreo);
                    break;
                case 2:
                    System.out.print("Nuevo Número: ");
                    String nuevoNumero = scanner.nextLine();
                    clienteDAO.actualizarClienteNumero(cedula, nuevoNumero);
                    break;
                case 3:
                    System.out.print("Nueva Ciudad: ");
                    String nuevaCiudad = scanner.nextLine();
                    clienteDAO.actualizarClienteCiudad(cedula, nuevaCiudad);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("Cliente actualizado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void eliminarCliente() {
        System.out.println("\nEliminar Cliente:");
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        Cliente cliente = clienteDAO.obtenerCliente(cedula);

        if (cliente != null) {
            clienteDAO.eliminarCliente(cedula);
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void listarClientes() {
        System.out.println("\nLista de Clientes:");
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido() + " - " + cliente.getCedula());
        }
    }

    private static void imprimirFactura() {
    System.out.println("\nImprimir Factura:");
    System.out.print("Cédula: ");
    String cedula = scanner.nextLine();
    Cliente cliente = clienteDAO.obtenerCliente(cedula);

    if (cliente != null) {
        System.out.println("Factura:");
        System.out.println("Código Único: " + generarCodigoFactura.generarCodigoFactura());
        System.out.println("Datos de Telefonía Móvil: ");
        System.out.println(cliente.toString());
    } else {
        System.out.println("Cliente no encontrado.");
    }
}


    private static void seleccionarPlanes(Cliente cliente) {
        int numPlanes = 0;
        do {
            System.out.println("1. PlanPostPagoMinutosMegasEconomico");
            System.out.println("2. PlanPostPagoMinutos");
            System.out.println("3. PlanPostPagoMegas");
            System.out.println("4. PlanPostPagoMinutosMegas");
            System.out.print("Seleccione el plan (1-4): ");
            int planOpcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            PlanMovil plan = null;
            switch (planOpcion) {
                case 1:
                    System.out.print("Minutos: ");
                    int minutos = scanner.nextInt();
                    System.out.print("Costo Minutos: ");
                    double costoMinutos = scanner.nextDouble();
                    System.out.print("Gigas: ");
                    double gigas = scanner.nextDouble();
                    System.out.print("Costo Gigas: ");
                    double costoGigas = scanner.nextDouble();
                    System.out.print("Descuento (%): ");
                    double descuento = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer
                    plan = new PlanPostPagoMinutosMegasEconomico(cliente.getNumero(), cliente.getCorreo(), "PlanPostPagoMinutosMegasEconomico", 0, minutos, costoMinutos, gigas, costoGigas, descuento);
                    break;
                case 2:
                    System.out.print("Minutos Nacionales: ");
                    int minutosNacionales = scanner.nextInt();
                    System.out.print("Costo Minuto Nacional: ");
                    double costoMinutoNacional = scanner.nextDouble();
                    System.out.print("Minutos Internacionales: ");
                    int minutosInternacionales = scanner.nextInt();
                    System.out.print("Costo Minuto Internacional: ");
                    double costoMinutoInternacional = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer
                    plan = new PlanPostPagoMinutos(cliente.getNumero(), cliente.getCorreo(), "PlanPostPagoMinutos", 0, minutosNacionales, costoMinutoNacional, minutosInternacionales, costoMinutoInternacional);
                    break;
                case 3:
                    System.out.print("Gigas: ");
                    gigas = scanner.nextDouble();
                    System.out.print("Costo Gigas: ");
                    costoGigas = scanner.nextDouble();
                    System.out.print("Tarifa Base: ");
                    double tarifaBase = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer
                    plan = new PlanPostPagoMegas(cliente.getNumero(), cliente.getCorreo(), "PlanPostPagoMegas", 0, gigas, costoGigas, tarifaBase);
                    break;
                case 4:
                    System.out.print("Minutos: ");
                    minutos = scanner.nextInt();
                    System.out.print("Costo Minutos: ");
                    costoMinutos = scanner.nextDouble();
                    System.out.print("Gigas: ");
                    gigas = scanner.nextDouble();
                    System.out.print("Costo Gigas: ");
                    costoGigas = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer
                    plan = new PlanPostPagoMinutosMegas(cliente.getNumero(), cliente.getCorreo(), "PlanPostPagoMinutosMegas", 0, minutos, costoMinutos, gigas, costoGigas);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            if (plan != null) {
                cliente.agregarPlan(plan);
                numPlanes++;
            }

        } while (numPlanes < 2 && deseaAgregarOtroPlan());

    }

    private static boolean deseaAgregarOtroPlan() {
        System.out.print("¿Desea agregar otro plan? (s/n): ");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("s");
    }
}