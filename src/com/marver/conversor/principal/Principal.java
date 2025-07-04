package com.marver.conversor.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marver.conversor.modulos.convertirMonedas;
import com.marver.conversor.modulos.menu;
import com.marver.conversor.modulos.monedaJson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.marver.conversor.modulos.convertirMonedas.convertirMoneda;

public class Principal {
    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        convertirMonedas convertirMoneda = new convertirMonedas();

        List<monedaJson> monedas = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        FileWriter escritura = new FileWriter("monedas.json");
        escritura.write(gson.toJson(monedas));

        int opcion = 0;

        while (opcion != 8) {
            menu menu = new menu();
            System.out.println(menu.opcionesMenu);
            System.out.println(menu.eleccion);
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion >= 1 && opcion <= 7) {
                convertirMoneda(scanner, opcion);
            } else if (opcion == 8) {
                System.out.println(menu.salida);
            } else {
                System.out.println("La opcion es incorrecta!!! Ingrese una opcion valida.");
            }
        }

        scanner.close();

    }
}
