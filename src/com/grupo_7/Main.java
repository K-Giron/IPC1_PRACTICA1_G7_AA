package com.grupo_7;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner menu = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
	// write your code here
        startMenu();
            }
        public static void startMenu() throws IOException {
            String menu_opciones = "";

            System.out.println("Seleccione una opción:");
            System.out.println("");
            System.out.println("1. Cargar matrices.");
            System.out.println("2. Sumar matrices.");
            System.out.println("3. Restar matrices.");
            System.out.println("4. Multiplicar matrices.");
            System.out.println("5. Dividir matrices.");
            System.out.println("6. Transpuesta de matriz.");
            System.out.println("7. Matriz inversa.");
            System.out.println("8. Potencia de una matriz.");
            System.out.println("9. Determinante de una matriz.");

            menu_opciones = menu.nextLine();

            switch (menu_opciones){
                case "1":
                    System.out.println("");
                    System.out.println("Por favor ingrese el nombre del archivo que contienen las mastrices.");
                    //encriptar();
                    break;
                case "2":
                    System.out.println("PRUEBA");
                    //desencriptar();
                    break;
                case "3":
                    System.out.println("PRUEBA");
                    //ataque();
                    break;
                case "4":
                    System.out.println("PRUEBA");
                    //reporte();
                    break;
                case "5":
                    System.out.println("PRUEBA");
                    //reporte();
                    break;
                case "6":
                    System.out.println("PRUEBA");
                    //reporte();
                    break;
                case "7":
                    System.out.println("PRUEBA");
                    //reporte();
                    break;
                case "8":
                    System.out.println("PRUEBA");
                    //reporte();
                    break;
                case "9":
                    System.out.println("PRUEBA");
                    //reporte();
                    break;
                case "10":
                    System.out.println("El programa ha finalizado");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida");
                    startMenu();
        }
        startMenu();
    }



}
