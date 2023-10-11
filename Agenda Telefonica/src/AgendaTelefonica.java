import java.util.ArrayList;
import java.util.List;
class AgendaTelefonica {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    public AgendaTelefonica(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        contactos = new ArrayList<>();
    }

    // Método para verificar si un contacto existe en la agenda
    public boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }

    // Método para listar todos los contactos en la agenda
    public List<Contacto> listarContactos() {
        return contactos;
    }

    // Método para buscar un contacto por nombre
    public Contacto buscaContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null; // No se encontró ningún contacto con ese nombre.
    }

    // Método para eliminar un contacto de la agenda
    public boolean eliminarContacto(Contacto contacto) {
        if (contactos.remove(contacto)) {
            System.out.println("Contacto eliminado: " + contacto);
            return true;
        } else {
            System.out.println("No se encontró ningún contacto con ese nombre. No se ha eliminado ningún contacto.");
            return false;
        }
    }

    // Método para verificar si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    // Método para obtener la cantidad de espacios libres en la agenda
    public int espaciosLibres() {
        return capacidadMaxima - contactos.size();
    }

    // Método para añadir un nuevo contacto a la agenda
    public boolean añadirContacto(Contacto contacto) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena. No se puede agregar más contactos.");
            return false;
        } else if (existeContacto(contacto)) {
            System.out.println("Ya existe un contacto con ese nombre. No se ha agregado el contacto.");
            return false;
        } else {
            contactos.add(contacto);
            System.out.println("Contacto agregado: " + contacto);
            return true;
        }
    }
}