package com.grupo_7;


import java.io.*;
import java.util.Scanner;

public class Main {

    public static String content;
    public static Scanner menu = new Scanner(System.in);
    public static double[][][] matrices = new double[26][][];
    public static String[] letras = new String[26];

    //Arreglos que van a contener las matrices que se mostraran en los reportes
    public static double[][] primeraMatriz;
    public static double[][] segundaMatriz;
    public static double[][] primeraMatrizSuma;
    public static double[][] segundaMatrizSuma;
    public static double[][] primeraMatrizResta;
    public static double[][] segundaMatrizResta;
    public static double[][] primeraMatrizMultiMatriz;
    public static double[][] segundaMatrizMultiMatriz;
    public static double[][] primeraMatrizMultiN;
    public static double[][] segundaMatrizMultiN;
    public static double[][] primeraMatrizDivide;
    public static double[][] segundaMatrizDivide;
    public static double[][] primeraMatrizTranspuesta;
    public static double[][] primeraMatrizInversa;
    public static double[][] primeraMatrizPotencia;
    public static double[][] primeraMatrizDetermninante;
    public static double[][] sumaTest;
    public static double[][] restaTest;
    public static double[][] divideTest;
    public static double[][] multiNTest;
    public static double[][] multiMatrizTest;
    public static double[][] transpuestaTest;
    public static double[][] inversaTest;
    public static double[][] potenciaTest;
    public static double determinanteTest;
    public static boolean divicion = false;
    public static double[][] inversaResultante = new double[0][];
    public static double[][] matrizDin;
    public static double[][] matrizDin2;
    public static double[][] matrizDin3;
    public static double[][] matrizDin4;
    public static double[][] matrizDin5;
    public static double[][] matrizDin6;
    public static double[][] matrizDin7;
    public static double[][] matrizDin8;
    public static int exp;
    public static int numMulti;

    public static double[][] suma;
    public static double[][] resta;
    public static double[][] multiplicacionN;
    public static double[][] Transpuesta;
    public static double[][] inversa;
    public static double[][] A = null, C= null,B= null;
    public static double[][] multipliacionMatriz;
    public static double[][] matrizR;


    public static void main(String[] args) throws IOException {
        startMenu();
    }

    public static void startMenu() throws IOException {
        String menu_opciones = "";

        System.out.println("");
        System.out.println("-------------------MENU PRINCIPAL-------------------");
        System.out.println();
        System.out.println("Seleccione una opción:\n");

        System.out.println("01. Cargar matrices.");
        System.out.println("02. Sumar matrices.");
        System.out.println("03. Restar matrices.");
        System.out.println("04. Multiplicar matriz por un numero.");
        System.out.println("05. Multiplicar entre matrices.");
        System.out.println("06. Dividir matrices.");
        System.out.println("07. Transpuesta de matriz.");
        System.out.println("08. Matriz inversa.");
        System.out.println("09. Potencia de una matriz.");
        System.out.println("10. Determinante de una matriz.");
        System.out.println("11. Generar Reportes.");
        System.out.println("12. Finalizar el programa.\n");
        System.out.println("---------------------------------------------------");

        menu_opciones = menu.nextLine();

        switch (menu_opciones) {
            case "1":

                LeerArchivo();
                LeyendoMatriz();

                break;
            case "2":
                System.out.println("Usted escogio sumar matrices:\n");
                sumaMatrices();
                System.out.println("--------------------------");
                break;
            case "3":
                System.out.println("Usted escogio restar matrices:\n");
                restarMatrices();
                System.out.println("--------------------------");
                break;
            case "4":
                System.out.println("Usted escogio multiplicar por un numero la matrices:\n");
                multiplicarMNumero();
                System.out.println("--------------------------");
                break;
            case "5":
                System.out.println("Usted escogio multiplicar entre matrices.\n");
                multiplicarMatrices();
                System.out.println("--------------------------");
                break;
            case "6":
                System.out.println("Usted escogio dividir entre matrices\n");
                dividirMatriz();
                System.out.println("--------------------------");
                break;
            case "7":
                System.out.println("Usted escogio transpuesta de matriz\n");
                trasnpuesta();
                System.out.println("--------------------------");
                break;
            case "8":
                System.out.println("Usted escogio inversa de una matriz\n");
                MenuInversa();
                System.out.println("--------------------------");
                break;
            case "9":
                System.out.println("Usted escogio potencia de matrices\n");
                System.out.println("--------------------------");
                potenciaMatriz();
                break;
            case "10":
                MenuDetermimante();
                System.out.println("--------------------------");
                break;
            case "11":
                menuReporte();
                System.out.println("--------------------------");
                break;
            case "12":
                System.out.println("El programa ha finalizado\n");
                System.exit(0);
                break;
            default:
                System.out.println("OpciÃ³n no valida\n");
                break;
        }
        startMenu();
    }

    public static String LeerArchivo() {

        System.out.println("Ingrese la direcciÃ³n del archivo.");
        File archivo = new File(menu.nextLine());
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            System.out.println("\n" + content);
            return content;
        } catch (Exception e) {

            System.out.println("Intentelo de nuevo \n");
            e.getMessage();

        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println("Intentelo de nuevo \n");
                e2.getMessage();
            }
        }
        return "";
    }

    public static void LeyendoMatriz() {
        try {
            String reglon[] = content.split("\n");

            for (int i = 0; i < reglon.length; i++) {

                // limpiar matriz de :
                String[] matriz = reglon[i].split(":");
                // letra renglon
                letras[i] = matriz[0].trim();
                // content de la matriz
                String content_matriz = matriz[1].trim();
                // limpiar matriz de ;
                String[] filas = content_matriz.split(";");
                // recorriendo filas
                int cantidadFilas = filas[0].split(",").length;
                // crear matriz para las columnas
                double[][] subMatriz = new double[cantidadFilas][filas[0].split(",").length];
                for (int a = 0; a < cantidadFilas; a++) {
                    // limpiando fila de ,
                    String[] columnas = filas[a].split(",");
                    // recorriendo las columnas
                    for (int b = 0; b < columnas.length; b++) {
                        subMatriz[a][b] = Double.parseDouble(columnas[b]);
                    }
                    // agregar la matriz bidimensional a la principal
                    matrices[i] = subMatriz;
                }
            }
            System.out.println("----------------------------------------");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void solictarMatrices() {
        System.out.println("Ingresa la letra de la primera matriz");
        String opcion1 = menu.nextLine();
        System.out.println("Ingresa la letra de la segunda matriz");
        String opcion2 = menu.nextLine();
        for (int a = 0; a < letras.length; a++) {
            if (letras[a] != null) {
                if (letras[a].equals(opcion1)) {
                    primeraMatriz = matrices[a];
                }
                if (letras[a].equals(opcion2)) {
                    segundaMatriz = matrices[a];
                }
            }
        }

    }

    public static void solicitarmatriz1(){

        System.out.println("Ingresa la letra de la primera matriz");
        String opcion1 = menu.nextLine();
        for (int a = 0; a < letras.length; a++) {
            if (letras[a] != null) {
                if (letras[a].equals(opcion1)) {
                    primeraMatriz = matrices[a];

                }
            }else{
                System.out.println("La matriz no existe");
                break;
            }
        }
    }

    public static void sumaMatrices() {
        solictarMatrices();
        int tamanio=0;
        try{
            for (double[] Elements : primeraMatriz)
                tamanio++;
            double[][] suma = new double[tamanio][tamanio];
            if ((primeraMatriz.length == segundaMatriz.length) && (primeraMatriz[0].length == segundaMatriz[0].length)) {
                for (int x = 0; x < primeraMatriz.length; x++) {
                    for (int y = 0; y < primeraMatriz[x].length; y++) {
                        suma[x][y] = primeraMatriz[x][y] + segundaMatriz[x][y];
                    }
                }
                asignarR(suma);
                for (int x = 0; x < suma.length; x++) {
                    for (int y = 0; y < suma[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(suma[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }

                sumaTest=suma;
                primeraMatrizSuma=primeraMatriz;
                segundaMatrizSuma=segundaMatriz;
            } else {
                System.out.println("No se pueden sumar matrices de estas dimensiones");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("OcurriÃ³ un error");
            System.out.println("Una o ambas matrices no existen");

        }

    }

    public static void restarMatrices() {

        solictarMatrices();
        int tamanio=0;
        try{
            for (double[] Elements : primeraMatriz)
                tamanio++;
            double[][] resta = new double[tamanio][tamanio];
            if ((primeraMatriz.length == segundaMatriz.length) && (primeraMatriz[0].length == segundaMatriz[0].length)) {
                for (int x = 0; x < primeraMatriz.length; x++) {
                    for (int y = 0; y < primeraMatriz[x].length; y++) {
                        resta[x][y] = primeraMatriz[x][y] - segundaMatriz[x][y];

                    }
                }
                asignarR(resta);
                for (int x = 0; x < resta.length; x++) {
                    for (int y = 0; y < resta[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(resta[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                restaTest=resta;
                primeraMatrizResta=primeraMatriz;
                segundaMatrizResta=segundaMatriz;
            } else {
                System.out.println("No se pueden sumar matrices de estas dimensiones");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("OcurriÃ³ un error");
            System.out.println("Una o ambas matrices no existen");

        }
    }

    public static void multiplicarMNumero() {
        solicitarmatriz1();
        int tamanio = 0;
        try{
            for (double[] Elements : primeraMatriz)
                tamanio++;
            double[][] multiplicacionN = new double[tamanio][tamanio];
            System.out.println("Digite el numero a multplicar");
            int numero = menu.nextInt();
            for (int i = 0; i < primeraMatriz.length; i++) {
                for (int j = 0; j < primeraMatriz[i].length; j++) {
                    multiplicacionN[i][j] = primeraMatriz[i][j] * numero;
                }
            }
            numMulti=numero;
            asignarR(multiplicacionN);
            for (int x = 0; x < multiplicacionN.length; x++) {
                for (int y = 0; y < multiplicacionN[x].length; y++) {
                    System.out.print(" | ");
                    System.out.print(multiplicacionN[x][y]);
                    System.out.print(" | ");
                }
                System.out.println();
            }
            System.out.println("----------------------------");
            multiNTest=multiplicacionN;
            primeraMatrizMultiN=primeraMatriz;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("OcurriÃ³ un error");
            System.out.println("La matriz no existe.");

        }
    }

    public static void multiplicarMatrices(){
        solictarMatrices();

        int tamanio=0;
        try{
            for (double[] Elements : primeraMatriz)
                tamanio++;
            double[][] multipliacionMatriz = new double[tamanio][tamanio];

            int filasA = primeraMatriz.length;
            int columnasA = primeraMatriz[0].length;
            int filasB = segundaMatriz.length;
            int columnasB = segundaMatriz[0].length;

            if (columnasA != filasB) {
                throw new IllegalArgumentException("La cantidad de columnas de la matriz A no es igual a la cantidad de filas de la matriz B");
            }

            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasB; j++) {
                    for (int k = 0; k < columnasA; k++) {
                        multipliacionMatriz[i][j] += primeraMatriz[i][k] * segundaMatriz[k][j];
                    }
                }
            }
            asignarR(multipliacionMatriz);
            for (int x = 0; x < multipliacionMatriz.length; x++) {
                for (int y = 0; y < multipliacionMatriz[x].length; y++) {
                    System.out.print(" | ");
                    System.out.print(multipliacionMatriz[x][y]);
                    System.out.print(" | ");
                }
                System.out.println();
            }
            System.out.println("----------------------------");
            multiMatrizTest=multipliacionMatriz;
            primeraMatrizMultiMatriz=primeraMatriz;
            segundaMatrizMultiMatriz=segundaMatriz;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("OcurriÃ³ un error");
            System.out.println("Una o ambas matrices no existen");
        }
    }

    public static void trasnpuesta(){
        solicitarmatriz1();
        int tamanio = 0;
        try{
            for (double[] Elements : primeraMatriz)
                tamanio++;
            double[][] Transpuesta = new double[tamanio][tamanio];

            Transpuesta = new double[primeraMatriz[0].length][primeraMatriz.length];
            for (int x = 0; x < primeraMatriz.length; x++) {
                for (int y = 0; y < primeraMatriz[x].length; y++) {
                    Transpuesta[y][x] = primeraMatriz[x][y];
                }
            }
            asignarR(Transpuesta);
            for (int x = 0; x < Transpuesta.length; x++) {
                for (int y = 0; y < Transpuesta[x].length; y++) {
                    System.out.print(" | ");
                    System.out.print(Transpuesta[x][y]);
                    System.out.print(" | ");
                }
                System.out.println();
            }
            System.out.println("----------------------------");
            transpuestaTest=Transpuesta;
            primeraMatrizTranspuesta=primeraMatriz;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("OcurriÃ³ un error");
            System.out.println("La matriz no existe.");
        }
    }

    public static void Determinante() {
        solicitarmatriz1();
        try{
            double determinante, x00, x01, x02, x10, x11, x12, x20, x21, x22;
            A = primeraMatriz;
            C = new double[3][3];

            determinante = (A[0][0] * ((A[1][1] * A[2][2]) - (A[1][2] * A[2][1]))) - (A[0][1] * ((A[1][0] * A[2][2]) - (A[2][0] * A[1][2]))) + (A[0][2] * ((A[1][0] * A[2][1]) - (A[2][0] * A[1][1])));

            System.out.println("\nLa determimante es " + determinante + "\n");
            determinanteTest=determinante;
            primeraMatrizDetermninante=primeraMatriz;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("OcurriÃ³ un error");
            System.out.println("La matriz no existe.");
        }
    }

    public static void MenuInversa() throws IOException {
        String menu_opciones = "";

        System.out.println("Seleccione una opciÃ³n:\n");

        System.out.println("01. Inversa 2x2");
        System.out.println("02. Inversa 3x3");
        System.out.println("03. Regresar a menu ");

        menu_opciones = menu.nextLine();

        switch (menu_opciones) {
            case "1":
                System.out.println("");
                inversa2x2();
                break;
            case "2":
                inversa();
                break;
            default:
                System.out.println("OpciÃ³n no valida\n");
                break;
            //startMenu();

        }
        //startMenu();
        startMenu();
    }

    public static void inversa(){
        double[][] matrizEvaluada = new double[0][];
        if(divicion) {
            matrizEvaluada = segundaMatriz;
        } else {
            solicitarmatriz1();
            matrizEvaluada = primeraMatriz;
        }
        double determinante, x00, x01, x02, x10, x11, x12, x20, x21, x22;
        A = matrizEvaluada;
        C = new double[3][3];
        int tamanio = 0;
        for (double[] Elements : primeraMatriz)
            tamanio++;
        double[][] InversaMatriz = new double[tamanio][tamanio];

        determinante  = (A[0][0] * ((A[1][1] * A[2][2]) - (A[1][2] * A[2][1]))) - (A[0][1] * ((A[1][0] * A[2][2]) - (A[2][0] * A[1][2]))) + (A[0][2] * ((A[1][0] * A[2][1]) - (A[2][0] * A[1][1])));

        if (determinante != 0) {
            x00 = ((A[1][1] * A[2][2] - A[2][1] * A[1][2])) / determinante;
            x01 = (-(A[1][0] * A[2][2] - A[2][0] * A[1][2])) / determinante;
            x02 = ((A[1][0] * A[2][1] - A[2][0] * A[1][1])) / determinante;
            x10 = (-(A[0][1] * A[2][2] - A[2][1] * A[0][2])) / determinante;
            x11 = ((A[0][0] * A[2][2] - A[2][0] * A[0][2])) / determinante;
            x12 = (-(A[0][0] * A[2][1] - A[2][0] * A[0][1])) / determinante;
            x20 = ((A[0][1] * A[1][2] - A[1][1] * A[0][2])) / determinante;
            x21 = (-(A[0][0] * A[1][2] - A[1][0] * A[0][2])) / determinante;
            x22 = ((A[0][0] * A[1][1] - A[1][0] * A[0][1])) / determinante;

            C[0][0] = x00;
            C[0][1] = x10;
            C[0][2] = x20;
            C[1][0] = x01;
            C[1][1] = x11;
            C[1][2] = x21;
            C[2][0] = x02;
            C[2][1] = x12;
            C[2][2] = x22;

            asignarR(InversaMatriz);

            System.out.println("La inversa es :");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    InversaMatriz[i][j] = C[i][j];
                    System.out.print("|" + InversaMatriz[i][j] + "|");
                }
                System.out.println();
            }
            inversaTest=InversaMatriz;
            primeraMatrizInversa=primeraMatriz;
        } else {
            System.out.println("No existe matriz inversa");
        }

    }

    public static void inversa2x2(){

        solicitarmatriz1();
        double determinante, x00, x01,  x10, x11;
        B = primeraMatriz;

        determinante  = ((B[0][0]*B[1][1])-(B[1][0]*B[0][1]));

        System.out.println("\nLa determimante es " + determinante + "\n");
        C = new double[2][2];
        int tamanio = 0;
        for (double[] Elements : primeraMatriz)
            tamanio++;
        double[][] InversaMatriz = new double[tamanio][tamanio];

        if (determinante != 0) {
            x00 = (B[1][1]) / determinante;
            x01 = (-B[0][1]) / determinante;
            x10 = (-B[1][0]) / determinante;
            x11 = (B[0][0]) / determinante;

            C[0][0] = x00;
            C[0][1] = x01;
            C[1][0] = x10;
            C[1][1] = x11;


            asignarR(InversaMatriz);

            System.out.println("La inversa es :");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    InversaMatriz[i][j] = C[i][j];
                    System.out.print("|" + InversaMatriz[i][j] + "|");
                }
                System.out.println();
            }
            inversaTest=InversaMatriz;
            primeraMatrizInversa=primeraMatriz;
        } else {
            System.out.println("No existe matriz inversa");
        }

    }

    public static void determinante2x2(){

        solicitarmatriz1();
        double determinante, x00, x01,  x10, x11;
        B = primeraMatriz;

        determinante  = ((B[0][0]*B[1][1])-(B[1][0]*B[0][1]));

        System.out.println("\nLa determimante es " + determinante + "\n");
        determinanteTest=determinante;
        primeraMatrizDetermninante=primeraMatriz;
    }

    public static void MenuDetermimante() throws IOException {
        String menu_opciones = "";

        System.out.println("Seleccione una opciÃ³n:\n");

        System.out.println("01. Detemimante 2x2");
        System.out.println("02. Determinante 3x3");
        System.out.println("03. Regresar a menu ");

        menu_opciones = menu.nextLine();

        switch (menu_opciones) {
            case "1":
                System.out.println("");
                determinante2x2();
                break;
            case "2":
                Determinante();
                break;
            default:
                System.out.println("OpciÃ³n no valida\n");
                break;
            //startMenu();

        }
        //startMenu();
        startMenu();
    }

    public static void dividirMatriz() {
        divicion = true;
        solictarMatrices();
        inversa();
        multiplicarMatrices();
    }

    public static void potenciaMatriz() {
        solicitarmatriz1();
        System.out.println("Ingrese el numero del exponente");
        int exp = menu.nextInt();
        int tamanio = 0;
        try {
            for (double[] Elements : primeraMatriz)
                tamanio++;
            double[][] potenciaMatriz = new double[tamanio][tamanio];
            double[][] copiaMatriz = primeraMatriz;

            int filasA = primeraMatriz.length;
            int columnasA = primeraMatriz[0].length;
            int filasB = copiaMatriz.length;
            int columnasB = copiaMatriz[0].length;

            potenciaMatriz = new double[filasA][columnasA];
            if (exp == 1) {
                for (int i = 0; i < primeraMatriz.length; i++) {
                    for (int j = 0; j < primeraMatriz[0].length; j++) {
                    }
                }
                asignarR(primeraMatriz);
                for (int x = 0; x < primeraMatriz.length; x++) {
                    for (int y = 0; y < primeraMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(primeraMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------------");
                potenciaTest= primeraMatrizPotencia;
                primeraMatrizPotencia=primeraMatriz;

            }
            if (exp == 2) {
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasA; k++) {
                            potenciaMatriz[i][j] += primeraMatriz[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                asignarR(potenciaMatriz);
                for (int x = 0; x < potenciaMatriz.length; x++) {
                    for (int y = 0; y < potenciaMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(potenciaMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------------");
                potenciaTest= potenciaMatriz;
                primeraMatrizPotencia=primeraMatriz;
            }
            if (exp == 3) {

                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasA; k++) {
                            potenciaMatriz[i][j] += primeraMatriz[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin = potenciaMatriz;
                int filasC = matrizDin.length;
                int columnasC = matrizDin[0].length;
                potenciaMatriz = new double[filasC][columnasC];
                for (int i = 0; i < filasC; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasC; k++) {
                            potenciaMatriz[i][j] += matrizDin[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                asignarR(potenciaMatriz);
                for (int x = 0; x < potenciaMatriz.length; x++) {
                    for (int y = 0; y < potenciaMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(potenciaMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();

                }potenciaTest= potenciaMatriz;
                primeraMatrizPotencia=primeraMatriz;
                System.out.println("----------------------------");
            }
            if (exp == 4) {
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasA; k++) {
                            potenciaMatriz[i][j] += primeraMatriz[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin = potenciaMatriz;
                int filasC = matrizDin.length;
                int columnasC = matrizDin[0].length;
                potenciaMatriz = new double[filasC][columnasC];
                for (int i = 0; i < filasC; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasC; k++) {
                            potenciaMatriz[i][j] += matrizDin[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin2 = potenciaMatriz;
                int filasD = matrizDin2.length;
                int columnasD = matrizDin2[0].length;
                potenciaMatriz = new double[filasD][columnasD];
                for (int i = 0; i < filasD; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasD; k++) {
                            potenciaMatriz[i][j] += matrizDin2[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                asignarR(potenciaMatriz);
                for (int x = 0; x < potenciaMatriz.length; x++) {
                    for (int y = 0; y < potenciaMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(potenciaMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------------");
                potenciaTest= potenciaMatriz;
                primeraMatrizPotencia=primeraMatriz;
            }
            if (exp == 5) {
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasA; k++) {
                            potenciaMatriz[i][j] += primeraMatriz[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin = potenciaMatriz;
                int filasC = matrizDin.length;
                int columnasC = matrizDin[0].length;
                potenciaMatriz = new double[filasC][columnasC];
                for (int i = 0; i < filasC; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasC; k++) {
                            potenciaMatriz[i][j] += matrizDin[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin2 = potenciaMatriz;
                int filasD = matrizDin2.length;
                int columnasD = matrizDin2[0].length;
                potenciaMatriz = new double[filasD][columnasD];
                for (int i = 0; i < filasD; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasD; k++) {
                            potenciaMatriz[i][j] += matrizDin2[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin3 = potenciaMatriz;
                int filasE = matrizDin3.length;
                int columnasE = matrizDin3[0].length;
                potenciaMatriz = new double[filasE][columnasE];
                for (int i = 0; i < filasE; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasE; k++) {
                            potenciaMatriz[i][j] += matrizDin3[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                asignarR(potenciaMatriz);
                for (int x = 0; x < potenciaMatriz.length; x++) {
                    for (int y = 0; y < potenciaMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(potenciaMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------------");
                potenciaTest= potenciaMatriz;
                primeraMatrizPotencia=primeraMatriz;
            }
            if (exp == 6) {
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasA; k++) {
                            potenciaMatriz[i][j] += primeraMatriz[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin = potenciaMatriz;
                int filasC = matrizDin.length;
                int columnasC = matrizDin[0].length;
                potenciaMatriz = new double[filasC][columnasC];
                for (int i = 0; i < filasC; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasC; k++) {
                            potenciaMatriz[i][j] += matrizDin[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin2 = potenciaMatriz;
                int filasD = matrizDin2.length;
                int columnasD = matrizDin2[0].length;
                potenciaMatriz = new double[filasD][columnasD];
                for (int i = 0; i < filasD; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasD; k++) {
                            potenciaMatriz[i][j] += matrizDin2[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin3 = potenciaMatriz;
                int filasE = matrizDin3.length;
                int columnasE = matrizDin3[0].length;
                potenciaMatriz = new double[filasE][columnasE];
                for (int i = 0; i < filasE; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasE; k++) {
                            potenciaMatriz[i][j] += matrizDin3[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin4 = potenciaMatriz;
                int filasF = matrizDin4.length;
                int columnasF = matrizDin4[0].length;
                potenciaMatriz = new double[filasF][columnasF];
                for (int i = 0; i < filasF; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasF; k++) {
                            potenciaMatriz[i][j] += matrizDin4[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                asignarR(potenciaMatriz);
                for (int x = 0; x < potenciaMatriz.length; x++) {
                    for (int y = 0; y < potenciaMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(potenciaMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------------");
                potenciaTest= potenciaMatriz;
                primeraMatrizPotencia=primeraMatriz;
            }
            if (exp == 7) {
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasA; k++) {
                            potenciaMatriz[i][j] += primeraMatriz[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin = potenciaMatriz;
                int filasC = matrizDin.length;
                int columnasC = matrizDin[0].length;
                potenciaMatriz = new double[filasC][columnasC];
                for (int i = 0; i < filasC; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasC; k++) {
                            potenciaMatriz[i][j] += matrizDin[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin2 = potenciaMatriz;
                int filasD = matrizDin2.length;
                int columnasD = matrizDin2[0].length;
                potenciaMatriz = new double[filasD][columnasD];
                for (int i = 0; i < filasD; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasD; k++) {
                            potenciaMatriz[i][j] += matrizDin2[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin3 = potenciaMatriz;
                int filasE = matrizDin3.length;
                int columnasE = matrizDin3[0].length;
                potenciaMatriz = new double[filasE][columnasE];
                for (int i = 0; i < filasE; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasE; k++) {
                            potenciaMatriz[i][j] += matrizDin3[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin4 = potenciaMatriz;
                int filasF = matrizDin4.length;
                int columnasF = matrizDin4[0].length;
                potenciaMatriz = new double[filasF][columnasF];
                for (int i = 0; i < filasF; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasF; k++) {
                            potenciaMatriz[i][j] += matrizDin4[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin5 = potenciaMatriz;
                int filasG = matrizDin5.length;
                int columnasG = matrizDin5[0].length;
                potenciaMatriz = new double[filasF][columnasF];
                for (int i = 0; i < filasG; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasG; k++) {
                            potenciaMatriz[i][j] += matrizDin5[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                asignarR(potenciaMatriz);
                for (int x = 0; x < potenciaMatriz.length; x++) {
                    for (int y = 0; y < potenciaMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(potenciaMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------------");
                potenciaTest= potenciaMatriz;
                primeraMatrizPotencia=primeraMatriz;
            }
            if (exp == 8) {
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasA; k++) {
                            potenciaMatriz[i][j] += primeraMatriz[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin = potenciaMatriz;
                int filasC = matrizDin.length;
                int columnasC = matrizDin[0].length;
                potenciaMatriz = new double[filasC][columnasC];
                for (int i = 0; i < filasC; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasC; k++) {
                            potenciaMatriz[i][j] += matrizDin[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin2 = potenciaMatriz;
                int filasD = matrizDin2.length;
                int columnasD = matrizDin2[0].length;
                potenciaMatriz = new double[filasD][columnasD];
                for (int i = 0; i < filasD; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasD; k++) {
                            potenciaMatriz[i][j] += matrizDin2[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin3 = potenciaMatriz;
                int filasE = matrizDin3.length;
                int columnasE = matrizDin3[0].length;
                potenciaMatriz = new double[filasE][columnasE];
                for (int i = 0; i < filasE; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasE; k++) {
                            potenciaMatriz[i][j] += matrizDin3[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin4 = potenciaMatriz;
                int filasF = matrizDin4.length;
                int columnasF = matrizDin4[0].length;
                potenciaMatriz = new double[filasF][columnasF];
                for (int i = 0; i < filasF; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasF; k++) {
                            potenciaMatriz[i][j] += matrizDin4[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin5 = potenciaMatriz;
                int filasG = matrizDin5.length;
                int columnasG = matrizDin5[0].length;
                potenciaMatriz = new double[filasF][columnasF];
                for (int i = 0; i < filasG; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasG; k++) {
                            potenciaMatriz[i][j] += matrizDin5[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin6 = potenciaMatriz;
                int filasH = matrizDin6.length;
                int columnasH = matrizDin6[0].length;
                potenciaMatriz = new double[filasF][columnasF];
                for (int i = 0; i < filasH; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasH; k++) {
                            potenciaMatriz[i][j] += matrizDin6[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                asignarR(potenciaMatriz);
                for (int x = 0; x < potenciaMatriz.length; x++) {
                    for (int y = 0; y < potenciaMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(potenciaMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------------");
                potenciaTest= potenciaMatriz;
                primeraMatrizPotencia=primeraMatriz;
            }
            if (exp == 9) {
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasA; k++) {
                            potenciaMatriz[i][j] += primeraMatriz[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin = potenciaMatriz;
                int filasC = matrizDin.length;
                int columnasC = matrizDin[0].length;
                potenciaMatriz = new double[filasC][columnasC];
                for (int i = 0; i < filasC; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasC; k++) {
                            potenciaMatriz[i][j] += matrizDin[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin2 = potenciaMatriz;
                int filasD = matrizDin2.length;
                int columnasD = matrizDin2[0].length;
                potenciaMatriz = new double[filasD][columnasD];
                for (int i = 0; i < filasD; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasD; k++) {
                            potenciaMatriz[i][j] += matrizDin2[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin3 = potenciaMatriz;
                int filasE = matrizDin3.length;
                int columnasE = matrizDin3[0].length;
                potenciaMatriz = new double[filasE][columnasE];
                for (int i = 0; i < filasE; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasE; k++) {
                            potenciaMatriz[i][j] += matrizDin3[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin4 = potenciaMatriz;
                int filasF = matrizDin4.length;
                int columnasF = matrizDin4[0].length;
                potenciaMatriz = new double[filasF][columnasF];
                for (int i = 0; i < filasF; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasF; k++) {
                            potenciaMatriz[i][j] += matrizDin4[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin5 = potenciaMatriz;
                int filasG = matrizDin5.length;
                int columnasG = matrizDin5[0].length;
                potenciaMatriz = new double[filasG][columnasG];
                for (int i = 0; i < filasG; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasG; k++) {
                            potenciaMatriz[i][j] += matrizDin5[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin6 = potenciaMatriz;
                int filasH = matrizDin6.length;
                int columnasH = matrizDin6[0].length;
                potenciaMatriz = new double[filasH][columnasH];
                for (int i = 0; i < filasH; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasH; k++) {
                            potenciaMatriz[i][j] += matrizDin6[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin7 = potenciaMatriz;
                int filasI = matrizDin7.length;
                int columnasI = matrizDin7[0].length;
                potenciaMatriz = new double[filasI][columnasI];
                for (int i = 0; i < filasI; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasI; k++) {
                            potenciaMatriz[i][j] += matrizDin7[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                asignarR(potenciaMatriz);
                for (int x = 0; x < potenciaMatriz.length; x++) {
                    for (int y = 0; y < potenciaMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(potenciaMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------------");
                potenciaTest= potenciaMatriz;
                primeraMatrizPotencia=primeraMatriz;
            }
            if (exp == 10) {
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasA; k++) {
                            potenciaMatriz[i][j] += primeraMatriz[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin = potenciaMatriz;
                int filasC = matrizDin.length;
                int columnasC = matrizDin[0].length;
                potenciaMatriz = new double[filasC][columnasC];
                for (int i = 0; i < filasC; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasC; k++) {
                            potenciaMatriz[i][j] += matrizDin[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin2 = potenciaMatriz;
                int filasD = matrizDin2.length;
                int columnasD = matrizDin2[0].length;
                potenciaMatriz = new double[filasD][columnasD];
                for (int i = 0; i < filasD; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasD; k++) {
                            potenciaMatriz[i][j] += matrizDin2[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin3 = potenciaMatriz;
                int filasE = matrizDin3.length;
                int columnasE = matrizDin3[0].length;
                potenciaMatriz = new double[filasE][columnasE];
                for (int i = 0; i < filasE; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasE; k++) {
                            potenciaMatriz[i][j] += matrizDin3[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin4 = potenciaMatriz;
                int filasF = matrizDin4.length;
                int columnasF = matrizDin4[0].length;
                potenciaMatriz = new double[filasF][columnasF];
                for (int i = 0; i < filasF; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasF; k++) {
                            potenciaMatriz[i][j] += matrizDin4[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin5 = potenciaMatriz;
                int filasG = matrizDin5.length;
                int columnasG = matrizDin5[0].length;
                potenciaMatriz = new double[filasG][columnasG];
                for (int i = 0; i < filasG; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasG; k++) {
                            potenciaMatriz[i][j] += matrizDin5[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin6 = potenciaMatriz;
                int filasH = matrizDin6.length;
                int columnasH = matrizDin6[0].length;
                potenciaMatriz = new double[filasH][columnasH];
                for (int i = 0; i < filasH; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasH; k++) {
                            potenciaMatriz[i][j] += matrizDin6[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin7 = potenciaMatriz;
                int filasI = matrizDin7.length;
                int columnasI = matrizDin7[0].length;
                potenciaMatriz = new double[filasI][columnasI];
                for (int i = 0; i < filasI; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasI; k++) {
                            potenciaMatriz[i][j] += matrizDin7[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                matrizDin8 = potenciaMatriz;
                int filasJ = matrizDin8.length;
                int columnasJ = matrizDin8[0].length;
                potenciaMatriz = new double[filasJ][columnasJ];
                for (int i = 0; i < filasJ; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        for (int k = 0; k < columnasJ; k++) {
                            potenciaMatriz[i][j] += matrizDin8[i][k] * copiaMatriz[k][j];
                        }
                    }
                }
                asignarR(potenciaMatriz);
                for (int x = 0; x < potenciaMatriz.length; x++) {
                    for (int y = 0; y < potenciaMatriz[x].length; y++) {
                        System.out.print(" | ");
                        System.out.print(potenciaMatriz[x][y]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------------");
                potenciaTest= potenciaMatriz;
                primeraMatrizPotencia=primeraMatriz;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("OcurriÃƒÂ³ un error");
            System.out.println("Una o ambas matrices no existen");
        }
    }

    public static void asignarR(double[][] matriz) {
        matrizR = matriz;
        for (int a = 0; a < letras.length; a++) {
            if (letras[a] != null) {
                if (letras[a].equals("R")) {
                    matrices[a] = matriz;
                }
            } else {
                letras[a] = "R";
                matrices[a] = matriz;
                break;
            }
        }
    }

    public static void menuReporte() throws IOException {
        String menu_opciones = "";

        System.out.println("Ingrese la opciÃ³n de reporte que desee generar");
        System.out.println("01. Reporte de suma");
        System.out.println("02. Reporte de resta");
        System.out.println("03. Reporte de multiplicaciÃ³n por N nÃºmero");
        System.out.println("04. Reporte de multiplicacipiÃ³n por matrices");
        System.out.println("05. Reporte de DivisiÃ³n");
        System.out.println("06. Reporte de matriz transpuesta");
        System.out.println("07. Reporte de matriz inversa");
        System.out.println("08. Reporte de potencia de matriz");
        System.out.println("09. Regresar a menu Principal");


        menu_opciones = menu.nextLine();

        switch (menu_opciones) {
            case "1":
                report("Reporte de Sumas",1);
                break;
            case "2":
                report("Reporte de Resta",2);
                break;
            case "3":
                report("Reporte de multiplicaciÃ³n por N nÃºmero",3);
                break;
            case "4":
                report("Reporte de multiplicaciÃ³n",4);
                break;
            case "5":
                report("Reporte de DisiviÃ³n",5);
                break;
            case "6":
                report("Reporte de matriz transpuesta",6);
                break;
            case "7":
                report("Reporte de inversa de matriz",7);
                break;
            case "8":
                report("Reporte de potencia de matriz",8);
                break;
            case "9":
                startMenu();
                break;
            default:
                System.out.println("OpciÃ³n no valida\n");
                break;


        }
        //startMenu();
        startMenu();
    }

    public static void report(String title, int type) {

        FileWriter filewriter = null;
        PrintWriter printw = null;

        try {
            filewriter = new FileWriter(title + ".html");
            printw = new PrintWriter(filewriter);

            printw.println("<html>");
            printw.println("<head><title>Reporte</title></head>");

            printw.println("<body style=\"padding: 40px\" bgcolor=\"#00cec9\">");

            printw.println("<center style=\"margin-bottom: 20px\"><h1><font>" + title + "</font></h1></center>");
            printw.println("<div style=\"margin-bottom: 10px\">");
            if (type == 1) {
                try{
                    for (int x = 0; x < primeraMatrizSuma.length; x++) {
                        for (int y = 0; y < primeraMatrizSuma[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ primeraMatrizSuma[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "+" + "</font></span></br>");

                    for (int x = 0; x < segundaMatrizSuma.length; x++) {
                        for (int y = 0; y < segundaMatrizSuma[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ segundaMatrizSuma[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "=" + "</font></span></br>");

                    for (int x = 0; x < sumaTest.length; x++) {
                        for (int y = 0; y < sumaTest[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ sumaTest[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");

                    }System.out.println("Generado exitosamente, en la ruta root.");
                } catch (Exception e) {
                    System.out.println("Error al generar, no hay matriz operada.");
                }
            }
            if (type == 2) {
                try{
                    for (int x = 0; x < primeraMatrizResta.length; x++) {
                        for (int y = 0; y < primeraMatrizResta[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ primeraMatrizResta[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "-" + "</font></span></br>");

                    for (int x = 0; x < segundaMatrizResta.length; x++) {
                        for (int y = 0; y < segundaMatrizResta[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ segundaMatrizResta[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "=" + "</font></span></br>");

                    for (int x = 0; x < restaTest.length; x++) {
                        for (int y = 0; y < restaTest[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ restaTest[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");

                    }System.out.println("Generado exitosamente, en la ruta root.");
                } catch (Exception e) {
                    System.out.println("Error al generar, no hay matriz operada.");
                }
            }
            if (type == 3) {
                try{
                    for (int x = 0; x < primeraMatrizMultiN .length; x++) {
                        for (int y = 0; y < primeraMatrizMultiN[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ primeraMatrizMultiN[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "*" + "</font></span></br>");

                    printw.println("<span><font>"+ numMulti+ " "+"</font></span>");
                    printw.print("<span><font>"+ "=" + "</font></span></br>");

                    for (int x = 0; x < multiNTest.length; x++) {
                        for (int y = 0; y < multiNTest[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ multiNTest[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }System.out.println("Generado exitosamente, en la ruta root.");
                } catch (Exception e) {
                    System.out.println("Error al generar, no hay matriz operada.");
                }
            }
            if (type == 4) {
                try{
                    for (int x = 0; x < primeraMatrizMultiMatriz.length; x++) {
                        for (int y = 0; y < primeraMatrizMultiMatriz[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ primeraMatrizMultiMatriz[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "*" + "</font></span></br>");

                    for (int x = 0; x < segundaMatrizMultiMatriz.length; x++) {
                        for (int y = 0; y < segundaMatrizMultiMatriz[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ segundaMatrizMultiMatriz[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "=" + "</font></span></br>");

                    for (int x = 0; x < multiMatrizTest.length; x++) {
                        for (int y = 0; y < multiMatrizTest[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ multiMatrizTest[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }System.out.println("Generado exitosamente, en la ruta root.");
                } catch (Exception e) {
                    System.out.println("Error al generar, no hay matriz operada.");
                }
            }
            if (type == 5) {
                try{
                    for (int x = 0; x < primeraMatrizDivide.length; x++) {
                        for (int y = 0; y < primeraMatrizDivide[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ primeraMatrizDivide[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "/" + "</font></span></br>");

                    for (int x = 0; x < segundaMatrizDivide.length; x++) {
                        for (int y = 0; y < segundaMatrizDivide[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ segundaMatrizDivide[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "=" + "</font></span></br>");

                    for (int x = 0; x < divideTest.length; x++) {
                        for (int y = 0; y < divideTest[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ divideTest[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }System.out.println("Generado exitosamente, en la ruta root.");
                } catch (Exception e) {
                    System.out.println("Error al generar, no hay matriz operada.");
                }
            }

            if (type == 6) {
                try{
                    for (int x = 0; x < primeraMatrizTranspuesta.length; x++) {
                        for (int y = 0; y < primeraMatrizTranspuesta[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ primeraMatrizTranspuesta[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "=" + "</font></span></br>");


                    for (int x = 0; x < transpuestaTest.length; x++) {
                        for (int y = 0; y < transpuestaTest[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ transpuestaTest[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }System.out.println("Generado exitosamente, en la ruta root.");
                } catch (Exception e) {
                    System.out.println("Error al generar, no hay matriz operada.");
                }
            }
            if (type == 7) {
                try{
                    for (int x = 0; x < primeraMatrizInversa.length; x++) {
                        for (int y = 0; y < primeraMatrizInversa[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ primeraMatrizInversa[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ "=" + "</font></span></br>");


                    for (int x = 0; x < inversaTest.length; x++) {
                        for (int y = 0; y < inversaTest[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ inversaTest[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }System.out.println("Generado exitosamente, en la ruta root.");
                } catch (Exception e) {
                    System.out.println("Error al generar, no hay matriz operada.");
                }
            }
            if (type == 8) {
                try{
                    for (int x = 0; x < primeraMatrizPotencia.length; x++) {
                        for (int y = 0; y < primeraMatrizPotencia[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ primeraMatrizPotencia[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }printw.print("<span><font>"+ " Resultado de la potencia " + "</font></span></br>");
                    printw.print("<span><font>"+ "   =  " + "</font></span></br>");

                    for (int x = 0; x < potenciaTest.length; x++) {
                        for (int y = 0; y < potenciaTest[x].length; y++) {
                            printw.print("<span><font>"+ "|" + "</font></span>");
                            printw.print("<span><font>"+ potenciaTest[x][y]+ " "+"</font></span>");
                            printw.print("<span><font>"+ "|" + "</font></span>");
                        }
                        printw.print("<span><font>"+ "" + "</font></span></br>");
                    }System.out.println("Generado exitosamente, en la ruta root.");
                } catch (Exception e) {
                    System.out.println("Error al generar, no hay matriz operada.");
                }
            }

            printw.println("</div>");

            printw.println("</body>");
            printw.println("</html>");

            printw.close();


        } catch (IOException e) {
            System.out.println("Error al generar.");
        }
    }
}
