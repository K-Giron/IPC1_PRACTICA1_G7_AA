package com.grupo_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner menu = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        startMenu();

    }


        public static void startMenu() throws IOException {
            String menu_opciones = "";

            System.out.println("Seleccione una opción:\n");

            System.out.println("01. Cargar matrices.");
            System.out.println("02. Sumar matrices.");
            System.out.println("03. Restar matrices.");
            System.out.println("04. Multiplicar matrices.");
            System.out.println("05. Dividir matrices.");
            System.out.println("06. Transpuesta de matriz.");
            System.out.println("07. Matriz inversa.");
            System.out.println("08. Potencia de una matriz.");
            System.out.println("09. Determinante de una matriz.");
            System.out.println("10. Finalizar el programa.\n");

            menu_opciones = menu.nextLine();

            switch (menu_opciones){
                case "1":
                    System.out.println("");
                    System.out.println("Por favor ingrese el nombre del archivo que contienen las mastrices.\n");
                    getContentOfFile();
                    //encriptar();
                    break;
                case "2":
                    System.out.println("PRUEBA\n");
                    //desencriptar();
                    break;
                case "3":
                    System.out.println("PRUEBA\n");
                    //ataque();
                    break;
                case "4":
                    System.out.println("PRUEBA\n");
                    //reporte();
                    break;
                case "5":
                    System.out.println("PRUEBA\n");
                    //reporte();
                    break;
                case "6":
                    System.out.println("PRUEBA\n");
                    //reporte();
                    break;
                case "7":
                    System.out.println("PRUEBA\n");
                    //reporte();
                    break;
                case "8":
                    System.out.println("PRUEBA\n");
                    //reporte();
                    break;
                case "9":
                    System.out.println("PRUEBA\n");
                    //reporte();
                    break;
                case "10":
                    System.out.println("El programa ha finalizado\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida\n");
                    startMenu();
        }
        startMenu();
    }

    public static String getContentOfFile() {

        System.out.println("Ingrese la dirección del archivo.");
        File archivo = new File(menu.nextLine());
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
 

            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            System.out.println("\n" +  content);
            return content;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return "";
    }
}
