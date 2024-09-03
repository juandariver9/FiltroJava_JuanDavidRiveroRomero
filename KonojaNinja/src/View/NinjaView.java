package View;

import Model.Ninja;
import Model.NinjaDAO;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class NinjaView {
    private final NinjaDAO ninjaDAO;
    private final Scanner scanner;
    
    public NinjaView() {
        ninjaDAO = new NinjaDAO();
        scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        int option = 0; 
        boolean validInput = false; 

        do {
            System.out.println("\n╔═════════════════════════════════════════════════════════════╗");
            System.out.println("║                                                             ║");
            System.out.println("║                  🌟  MENÚ DE GESTIÓN DE NINJAS              🌟  ║");
            System.out.println("║                                                             ║");
            System.out.println("╠═════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                             ║");
            System.out.println("║    1️⃣.  |  🗂️  Crear Ninja                                     ║");
            System.out.println("║    2️⃣.  |  📄  Ver Ninjas                                      ║");
            System.out.println("║    3️⃣.  |  🔙  Back                                            ║");
            System.out.println("║                                                             ║");
            System.out.println("╚═════════════════════════════════════════════════════════════╝");
            System.out.print("Please choose an option: ");

            while (!validInput) {
                try {
                    option = scanner.nextInt();
                    scanner.nextLine(); 
                    validInput = true;  
                } catch (InputMismatchException e) {
                    System.out.println("Error: Entrada inválida. Debe ser un número entero.");
                    scanner.next();
                }
            }

            switch (option) {
                case 1:
                    CrearNinja();
                    break;
                case 2:
                    ListarNinjas();
                    break;
                case 3:
                    System.out.println("🔙  Volviendo al menú");
                    break;
                default:
                    System.out.println("🚫  Opción inválida. Intente nuevamente.");
            }

            validInput = false;
        } while (option != 3);
    }

    public void CrearNinja() {
        String Nombre;
        String Rango;
        String Aldea;
        

        
        System.out.println("╔═════════════════════════════════════════════════════════════");
        System.out.print("║                   📛 Nombre del Ninja: ");
        Nombre = scanner.nextLine();
        System.out.println("╠═════════════════════════════════════════════════════════════");
        

        System.out.println("╔═════════════════════════════════════════════════════════════");
        System.out.print("║                   📛 Aldea del Ninja: ");
        Aldea = scanner.nextLine();
        System.out.println("╠═════════════════════════════════════════════════════════════");
        
        
        System.out.println("╔═════════════════════════════════════════════════════════════");
        System.out.print("║                   📛 Rango('Iniciante', 'Novato', 'Amateur', 'Experimentado' ): ");
        Rango = scanner.nextLine();
        System.out.println("╠═════════════════════════════════════════════════════════════");

        
        Ninja ninja = new Ninja();
        ninja.setNombre(Nombre);
        ninja.setRango(Rango);
        ninja.setAldea(Aldea);

        ninjaDAO.createNinja(ninja);

        // Mensaje de éxito
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println("║                  🎉 Ninja creado con éxito.                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                 ✔️ Detalles del evento:                     ║");
        System.out.println("║                                                            ");
        System.out.println("║    📅 Nombre: " + Nombre + "                                   ");
        System.out.println("║    🌍 Rango: " + Rango + "                                 ");
        System.out.println("║    🏙️ Aldea: " + Aldea + "                                 ");
        System.out.println("║                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }




    private void ListarNinjas() {
        try {
            List<Ninja> ninjas = ninjaDAO.getAllNinjas();
            if (ninjas.isEmpty()) {
                System.out.println("🔍  No hay eventos disponibles.");
            } else {

                System.out.println("╔═════╤═══════════════════════════╤════════════════════╤════════════════════╗");
                System.out.println("║ ID  | Nombre                    | Rango              | Aldea              ║");
                System.out.println("╠═════╪═══════════════════════════╪════════════════════╪════════════════════╢");


                for (Ninja ninja : ninjas) {
                    System.out.printf("║ %-3d │ %-25s │ %-20s │ %-20s ║\n",
                        ninja.getID_Ninja(),
                        truncateString(ninja.getNombre(), 25),
                        truncateString(ninja.getRango(), 20),
                        truncateString(ninja.getAldea(), 20)
                    );
                }

                // Imprimir el borde inferior de la tabla
                System.out.println("╚═════╩═══════════════════════════╩═════════════════════╩════════════════════╝");
                System.out.println("Escribe cualquier cosa para continuar");
                scanner.next(); 
            }
        } catch (Exception e) {
            System.out.println("🚨  Error al obtener ninjas.");
            e.printStackTrace();
        }
    }

    // Método auxiliar para truncar cadenas que exceden el ancho especificado
    private String truncateString(String str, int maxLength) {
        if (str.length() > maxLength) {
            return str.substring(0, maxLength - 3) + "...";
        }
        return str;
    }


    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private String readRango(String prompt) {
        while (true) {
            System.out.print(prompt);
            String Rango = scanner.nextLine();
            if (Rango.equalsIgnoreCase("Iniciante") || Rango.equalsIgnoreCase("Novato") || Rango.equalsIgnoreCase("Amateur" ) || Rango.equalsIgnoreCase("Experimentado" )) {
                return Rango;
            } else {
                System.out.println("Error: Estado inválido. Los valores aceptados son Active, Finished o Pending.");
            }
        }
    }
    
    
}

