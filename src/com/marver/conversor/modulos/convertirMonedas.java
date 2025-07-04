package com.marver.conversor.modulos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class convertirMonedas {
    public static void convertirMoneda(Scanner scanner, int opcion) {
        String monedaInicial = switch (opcion) {
            case 1 -> "USD";
            case 2 -> "ARS";
            case 3 -> "BRL";
            case 4 -> "COP";
            case 5 -> "EUR";
            case 6 -> "MXN";
            case 7 -> "BOB";
            default -> "";
        };

        System.out.println("Ingrese la cantidad en " + monedaInicial + " que desea convertir: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();
        LocalDateTime timeStamp = LocalDateTime.now();

        menu menu = new menu();
        System.out.println(menu.opcionesMenu);
        System.out.println("////////////////////////////////////////////////////////////////");
        System.out.println("Por favor elija una opcion de moneda a la que quiere convertir: ");
        System.out.println("////////////////////////////////////////////////////////////////");
        int opcionFinal = scanner.nextInt();
        scanner.nextLine();

        String monedaFinal;
        switch (opcionFinal) {
            case 1:
                monedaFinal = "USD";
                break;
            case 2:
                monedaFinal = "ARS";
                break;
            case 3:
                monedaFinal = "BRL";
                break;
            case 4:
                monedaFinal = "COP";
                break;
            case 5:
                monedaFinal = "EUR";
                break;
            case 6:
                monedaFinal = "MXN";
                break;
            case 7:
                monedaFinal = "BOB";
                break;
            case 8:
                System.out.println(menu.salida);
                System.exit(0);
                return;
            default:
                monedaFinal = "";
        }

        try {
            conexionAPI.convertirMoneda(monedaInicial, monedaFinal, cantidad);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = timeStamp.format(formatter);
            System.out.println("Fecha de conversion: " + formattedDateTime + ": " + cantidad + " en " + monedaInicial + " a " + monedaFinal);
            System.out.println("\n");
            System.out.println("¿Desea realizar otra accion?");
            System.out.println("--------------------------------");
            System.out.println("1) Realizar otra conversión");
            System.out.println("2) Salir");
            System.out.println("\n");
            System.out.println("Por favor elija una opción valida: ");
            int opcionMenu = scanner.nextInt();
            switch (opcionMenu) {
                case 1:
                    break;
                case 2:
                    System.out.println(menu.salida);
                    System.exit(0);
                    return;
                default:
                    System.out.println("Opción no válida. Reiniciando el programa...");
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }


    }

}
