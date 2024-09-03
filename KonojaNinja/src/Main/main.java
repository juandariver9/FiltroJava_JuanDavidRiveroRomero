
package Main;


import Controller.*;
import View.*;
import Database.Conection;
import Model.*;

import java.sql.Connection;
import java.util.Scanner;


public class main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conection con = new Conection();
        Connection connection = null;
        
        try {
            connection = con.getConnection();
            
            //iniciar controladores
            //blablablbalba no tengo controladores todavía
            
            //iniciar DAO
            //blablablbalba no tengo DAOS todavía
            
            //iniciar vistas
            NinjaView ninjaView = new NinjaView();
            
            int option;
            do {
                System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
                System.out.println("║                                                                   ║");
                System.out.println("║           BIENVENIDO AL SISTEMA DE GESTIÓN DE NINJAS              ║");
                System.out.println("║                                                                   ║");
                System.out.println("╠═══════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                   ║");
                System.out.println("║    1. Gestion de Ninjas                                           ║");
                System.out.println("║    2. Gestion de Misiones                                         ║");
                System.out.println("║    3. Gestion de Habilidades                                      ║");
                System.out.println("║    4. Back                                                        ║");
                System.out.println("║                                                                   ║");
                System.out.println("╚═══════════════════════════════════════════════════════════════════╝");
                System.out.println("Elige una opción: ");
                option = scanner.nextInt();
                scanner.nextLine();
                
                switch(option){
                    case 1:
                       ninjaView.displayMenu();
                       break;
                    case 2:
                        System.out.println("Si aparece este mensaje es porque probablemente no terminé el modulo de Mision");
                       //misionView.displayMenu();
                       break;
                    case 3:
                        System.out.println("Si aparece este mensaje es porque probablemente no terminé el modulo de Habilidades");
                       //habilidadesView.displayMenu();
                       break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
                
            }while (option != 4);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    con.closeConnection(); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            scanner.close();
        }
    }
    
}
