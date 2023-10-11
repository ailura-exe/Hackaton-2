import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Crear una agenda telefónica con una capacidad máxima de 20 contactos
        AgendaTelefonica agenda = new AgendaTelefonica(3);
        while (true) {
            System.out.println("*** Menú de Agenda Telefónica ***");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Espacios libres");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del contacto: ");
                    String nombre = scanner.next();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.next();

                    // Verificar si el contacto ya existe en la agenda
                    Contacto nuevoContacto = new Contacto(nombre, telefono);
                    if (!agenda.existeContacto(nuevoContacto)) {
                        agenda.añadirContacto(nuevoContacto);
                    } else {
                        System.out.println("El contacto ya existe en la agenda. No se ha agregado el contacto.");
                    }
                    break;
                case 2:
                    System.out.print("Nombre del contacto a buscar: ");
                    String nombreBuscado = scanner.next();
                    Contacto contactoBuscado = agenda.buscaContacto(nombreBuscado);
                    if (contactoBuscado != null) {
                        System.out.println("Información del contacto: " + contactoBuscado);
                    } else {
                        System.out.println("El contacto no se encontró en la agenda.");
                    }
                    break;
                case 3:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.next();
                    Contacto contactoEliminar = agenda.buscaContacto(nombreEliminar);
                    if (contactoEliminar != null) {
                        agenda.eliminarContacto(contactoEliminar);
                    } else {
                        System.out.println("El contacto no se encontró en la agenda.");
                    }
                    break;
                case 4:
                    System.out.println("Lista de contactos:");
                    for (Contacto contacto : agenda.listarContactos()) {
                        System.out.println(contacto);
                    }
                    break;
                case 5:
                    System.out.println("Espacios libres en la agenda: " + agenda.espaciosLibres());
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}