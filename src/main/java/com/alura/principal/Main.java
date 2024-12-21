package com.alura.principal;
import com.alura.api.pointAPI;
import java.util.Scanner;
import com.alura.dto.ConvertDTO;
import com.alura.dto.ConvertUnit;

public class Main {
    public static void main(String[] args) {

        pointAPI api = new pointAPI();
        Scanner scanner = new Scanner(System.in);
        boolean active = false;

        while (!active) {
            try {
                int option = menu(scanner);
                active = execOptions(option, scanner, api);
            } catch (Exception e) {
                System.out.println("A ocurrido un error: " + e.getMessage());
            }
        }
    }

    private static boolean execOptions(int option, Scanner scanner, pointAPI api) {
        boolean active = false;

        switch (option) {
            case 1 -> {
                System.out.print("Ingrese la cantidad a convertir: ");
                Double amount = scanner.nextDouble();
                ConvertDTO response = api.getCurrencyConverter(ConvertUnit.EUR, ConvertUnit.ARS, amount);
                responseTemplate(ConvertUnit.EUR, ConvertUnit.ARS, response, amount);

            }
            case 2 -> {
                System.out.print("Ingrese la cantidad a convertir: ");
                Double amount = scanner.nextDouble();
                ConvertDTO response = api.getCurrencyConverter(ConvertUnit.USD, ConvertUnit.COP, amount);
                responseTemplate(ConvertUnit.USD, ConvertUnit.COP, response, amount);
            }
            case 3 -> {
                System.out.print("Ingrese la cantidad a convertir: ");
                Double amount = scanner.nextDouble();
                ConvertDTO response = api.getCurrencyConverter(ConvertUnit.PEN, ConvertUnit.BRL, amount);
                responseTemplate(ConvertUnit.PEN, ConvertUnit.BRL, response, amount);
            }
            case 4 -> {
                System.out.print("Ingrese la cantidad a convertir: ");
                Double amount = scanner.nextDouble();
                ConvertDTO response = api.getCurrencyConverter(ConvertUnit.EUR, ConvertUnit.COP, amount);
                responseTemplate(ConvertUnit.EUR, ConvertUnit.COP, response, amount);
            }
            case 5 -> {
                System.out.print("Ingrese la cantidad a convertir: ");
                Double amount = scanner.nextDouble();
                ConvertDTO response = api.getCurrencyConverter(ConvertUnit.PEN, ConvertUnit.USD, amount);
                responseTemplate(ConvertUnit.PEN, ConvertUnit.USD, response, amount);
            }
            case 6 -> {
                System.out.print("Ingrese la cantidad a convertir: ");
                Double amount = scanner.nextDouble();
                ConvertDTO response = api.getCurrencyConverter(ConvertUnit.EUR, ConvertUnit.USD, amount);
                responseTemplate(ConvertUnit.EUR, ConvertUnit.USD, response, amount);
            }
            case 7 -> {
                System.out.println("Saliendo...");
                active = true;
            }
            default -> System.out.println("Opción no válida");
        }
        return active;
    }

    private static void responseTemplate(ConvertUnit unit, ConvertUnit target, ConvertDTO response, Double amount) {
        System.out.println("Tasa de cambio de: " + unit.name() + " a " + target.name() + " es: "
                + response.conversion_rate());
        System.out.println(amount + " " + unit.getName() + " es igual a " + response.conversion_result() + " "
                + target.getName());
    }

    private static int menu(Scanner scanner) {
    System.out.println("===================================");
    System.out.println("         Conversor de Monedas      ");
    System.out.println("===================================");
    System.out.println("Seleccione una opción:");
    System.out.println("1. Convertir de Euro a Peso Argentino");
    System.out.println("2. Convertir de Dolar Estadounidense a Peso Colombiano");
    System.out.println("3. Convertir de Sol Peruano a Real Brasileño");
    System.out.println("4. Convertir de Euro a Peso Colombiano");
    System.out.println("5. Convertir de Sol Peruano a Dolar Estadounidense");
    System.out.println("6. Convertir de Euro a Dolar Estadounidense");
    System.out.println("7. Salir");
    System.out.println("===================================");
    System.out.print("Ingrese su opción: ");
    return scanner.nextInt();
}
}