import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Lista (arreglo vacío) para almacenar las notas
    private static final ArrayList<String> NOTAS = new ArrayList<>();

    // Creamos una instancia de Scanner para leer la entrada del usuario
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Iniciamos la aplicación mostrando el menú
        menu();
    }

    // CREATE
    // Función para agregar una nota
    public static void agregarNota() {
        System.out.println("\nWrite your note: ");
        String nota = scanner.nextLine();
        // Agregamos la nota al arreglo
        NOTAS.add(nota);
        System.out.println("Note added successfully");
        menu();
    }

    // READ
    // Función para ver todas las notas
    public static void verNotas() {
        if (NOTAS.isEmpty()) {
            System.out.println("There's no notes to show");
        } else {
            System.out.println("\nYour notes:");
            for (int i = 0; i < NOTAS.size(); i++) {
                System.out.println((i + 1) + ". " + NOTAS.get(i));
            }
        }
        menu();
    }

    // UPDATE
    // Función para editar una nota
    public static void editarNota() {
        if (NOTAS.isEmpty()) {
            System.out.println("There's no notes to edit");
            menu();
            return;
        }

        System.out.println("Insert the number of the note you want to edit: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 1 || index > NOTAS.size()) {
            System.out.println("Invalid number of note");
            editarNota();
            return;
        }

        System.out.println("Write the new version of the note: ");
        String nuevaNota = scanner.nextLine();
        // Actualizamos la nota en el arreglo
        NOTAS.set(index - 1, nuevaNota);
        System.out.println("Note updated successfully");
        menu();
    }

    // DELETE
    // Función para eliminar una nota
    public static void eliminarNota() {
        if (NOTAS.isEmpty()) {
            System.out.println("There's no notes to delete");
            menu();
            return;
        }

        System.out.println("Insert the number of the note you want to delete: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 1 || index > NOTAS.size()) {
            System.out.println("Invalid number of note");
            eliminarNota();
            return;
        }

        // Eliminamos la nota del arreglo
        NOTAS.remove(index - 1);
        System.out.println("Note successfully deleted");
        menu();
    }

    // Función para mostrar el menú y leer la opción del usuario
    public static void menu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add note");
        System.out.println("2. Show notes");
        System.out.println("3. Edit note");
        System.out.println("4. Delete note");
        System.out.println("5. Quit");

        System.out.print("Select an option: ");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                agregarNota();
                break;
            case "2":
                verNotas();
                break;
            case "3":
                editarNota();
                break;
            case "4":
                eliminarNota();
                break;
            case "5":
                System.out.println("Goodbye!");
                scanner.close();
                break;
            default:
                System.out.println("Invalid option");
                menu();
                break;
        }
    }
}
