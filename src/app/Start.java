package app;

import java.util.Scanner;
import modelo.producto;
import modelo.ProductoDAO;

public class Start {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductoDAO dao = new ProductoDAO();

        int opcion;

        do {
            System.out.println("****************************************************");
            System.out.println("GESTOR DE PRODUCTOS");
            System.out.println("****************************************************");
            System.out.println("1) Crear un producto");
            System.out.println("2) Listar todos los productos");
            System.out.println("3) Modificar un producto");
            System.out.println("4) Borrar un producto");
            System.out.println("0) Salir del programa");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

            case 1:
                crearProducto(sc, dao);
                break;

            case 2:
                listarProductos(dao);
                break;

            case 3:
                modificarProducto(sc, dao);
                break;

            case 4:
                borrarProducto(sc, dao);
                break;

            case 0:
                System.out.println("Saliendo del programa...");
                break;

            default:
                System.out.println("Opción no válida");
                break;
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void crearProducto(Scanner sc, ProductoDAO dao) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        float precio = sc.nextFloat();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        producto p = new producto(nombre, precio, cantidad);
        boolean ok = dao.crearProducto(p);

        if (ok) System.out.println("Producto creado correctamente");
        else System.out.println("Error al crear el producto");
    }

    private static void listarProductos(ProductoDAO dao) {
        var lista = dao.listarProductos();

        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay productos en la base de datos");
            return;
        }

        System.out.println("****************************************************");
        System.out.println("LISTADO DE PRODUCTOS");
        System.out.println("****************************************************");

        for (producto p : lista) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Precio: " + p.getPrecio());
            System.out.println("Cantidad: " + p.getCantidad());
            System.out.println("----------------------------------------------------");
        }
    }

    private static void modificarProducto(Scanner sc, ProductoDAO dao) {
        System.out.print("ID del producto a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nuevo precio: ");
        float precio = sc.nextFloat();

        System.out.print("Nueva cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        producto p = new producto(id, nombre, precio, cantidad);
        boolean ok = dao.modificarProducto(p);

        if (ok) System.out.println("Producto modificado correctamente");
        else System.out.println("Error al modificar el producto");
    }

    private static void borrarProducto(Scanner sc, ProductoDAO dao) {
        System.out.print("ID del producto a borrar: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean ok = dao.borrarProducto(id);

        if (ok) System.out.println("Producto borrado correctamente");
        else System.out.println("Error al borrar el producto");
    }
}
