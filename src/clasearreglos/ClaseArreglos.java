/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasearreglos;

import java.util.Scanner;

/**
 *
 * @author chris
 */
public class ClaseArreglos {

    /**
     * @param args the command line arguments
     */
    int[] Aenteros;
    int indice = 0;

    public static void main(String[] args) {
        // TODO code application logic here
        ClaseArreglos a = new ClaseArreglos();
        a.inicializaarreglo(0, 10);
        Scanner sc = new Scanner(System.in);
        a.menu();
        }
    public ClaseArreglos() {
        //int [] Aent = {2,3,45,12,10,12,11,13,45,34};
        this.Aenteros = new int[10];
    }

    public void setAenteros(int cantidad) {
        Aenteros = new int[cantidad];
    }

    public void inicializaarreglo(int valor, int cant) {
        for (int i = 0; i < cant; i++) {
            Aenteros[i] = valor;
        }
    }

    public void muestraArreglo() {
        for (int i = 0; i < Aenteros.length; i++) {
            System.out.println("Posicion " + i + " :" + Aenteros[i]);
        }
    }

    public void muestraArreglo(int cantidad) {

        for (int i = 0; i < cantidad; i++) {

            System.out.println("Posición " + i + " : " + Aenteros[i]);
        }
    }

    public void agregar(int valor) {
        if (indice < Aenteros.length) {

            Aenteros[indice++] = valor;
        } else {
            System.out.println("Arreglo esta lleno");
        }
    }

    public Integer buscar(int valor) {
        for (int i = 0; i < indice; i++) {
            if (valor == Aenteros[i]) {
                return Aenteros[i];
            }
        }

        return null;
    }

    public int buscarPos(int valor) {
        for (int i = 0; i < indice; i++) {
            if (valor == Aenteros[i]) {
                return i;
            }
        }

        return -1;
    }

    public boolean Eliminar(int valor) {
        int r = buscarPos(valor);
        if (r > -1) {
            Aenteros[r] = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean modificar(int valorB, int valorM) {
        int r = buscarPos(valorB);
        if (r > -1) {
            Aenteros[r] = valorM;
            return true;
        }
        return false;
    }

    public void menu() {

        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do {
                                System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Bienvenido a la prueba de arreglos\n\n");
            System.out.println("1. Crear arreglo\n");
            System.out.println("2. Ver arreglo\n");
            System.out.println("3. Buscar elemento\n");
            System.out.println("4. Eliminar elemento\n");
            System.out.println("5. Modificar elemento\n");
            System.out.println("6. Salir\n");
            System.out.println("Selecciona una opción: ");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Ingresa la cantidad de espacios del arreglo");
                    int cantidad = sc.nextInt();
                    setAenteros(cantidad);

                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("Ingresa el valor de la posición " + i + ":");
                        int valor = sc.nextInt();
                        agregar(valor);
                    }
                    break;
                case 2:
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Ingrese la cantidad de elementos que desea ver\n\n\n\n\n");
                    System.out.println("(Recuerde que el número de elementos a guardar que elijio es de: "+Aenteros.length+". ese es el numero maximo que puede elejir.)");
                    System.out.println("Ingrese el numero: ");
                    int cant = sc.nextInt();
                    muestraArreglo(cant);
                    System.out.println("Indice--> " + indice);
                    break;
                case 3:
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Buscar elemento\n");
                    System.out.println("ingresa el elemento a buscar");
                    int v = sc.nextInt();
                    Integer vI = buscar(v);
                    if (vI != null) {
                        System.out.println("Elemento encontrado " + vI);
                    } else {
                        System.out.println("Elemento no encontrado");
                    }
                    break;
                case 4:
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Eliminar elemento\n\n");
                    System.out.println("ingresa el elemento a Eliminar: ");
                    int a = sc.nextInt();
                    if (Eliminar(a)) {
                        System.out.println("Elemento " + a + " Eliminado");
                    } else {
                        System.out.println("Elemento no encontrado");
                    }
                    break;
                case 5:
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Modificar elemento\n\n");
                    System.out.println("ingresa el elemento a Modificar");
                    int m = sc.nextInt();
                    System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
                    System.out.println("Ingresa el elemento nuevo");
                    int vx = sc.nextInt();
                    if (modificar(m, vx)) {
                        System.out.println("Elemento " + m + " Modificado por " + vx);
                    } else {
                        System.out.println("Elemento no encontrado");
                    }
                    muestraArreglo(Aenteros.length);
                    System.out.println("\n\n");
            
            break;
                case 6:
                    System.out.println("");
                    break;
          default:
              System.out.println("La opcion no existe. Elija otra.");
                    break;
            }

        
    }
    while (opc != 6);
    }
}