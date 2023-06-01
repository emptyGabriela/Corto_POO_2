

package com.uca.llenadoarchivotexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LlenadoArchivoTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del archivo:");
        String nombreArchivo = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            while (true) {
                System.out.println("Ingrese un nombre (o 'salir' para terminar):");
                String nombre = scanner.nextLine();

                if (nombre.equalsIgnoreCase("salir")) {
                    break;
                }

                System.out.println("Ingrese la edad de " + nombre + ":");
                int edad = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                String linea = nombre + "," + edad;
                writer.write(linea);
                writer.newLine();
            }
            System.out.println("El archivo se ha llenado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}

