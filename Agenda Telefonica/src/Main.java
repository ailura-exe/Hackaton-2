public class Main {
    public static void main(String[] args) {

        // Crear una agenda telefónica con una capacidad máxima de 100 contactos
        AgendaTelefonica agenda = new AgendaTelefonica(20);

        // Ejemplos de uso de la agenda
        Contacto contacto1 = new Contacto("Juan", "123-456-7890");
        agenda.añadirContacto(contacto1);

        Contacto contacto2 = new Contacto("María", "987-654-3210");
        agenda.añadirContacto(contacto2);

        Contacto contacto3 = new Contacto("Luis", "555-555-5555");
        agenda.añadirContacto(contacto3);

        System.out.println("Lista de contactos:");
        for (Contacto contacto : agenda.listarContactos()) {
            System.out.println(contacto);
        }

        agenda.eliminarContacto(contacto2);

        System.out.println("Lista de contactos después de eliminar a María:");
        for (Contacto contacto : agenda.listarContactos()) {
            System.out.println(contacto);
        }

        Contacto contactoLuis = agenda.buscaContacto("Luis");
        if (contactoLuis != null) {
            System.out.println("Información de Luis: " + contactoLuis);
        }
    
    }
}