package view;

import controller.MotorController;
import model.*;
import java.util.Scanner;
import java.util.Optional;
import java.util.List;

public class Main {
    private static MotorController controller = new MotorController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- CRUD de Motores ---");
            System.out.println("1. Registrar motor");
            System.out.println("2. Listar motores");
            System.out.println("3. Buscar motor por número");
            System.out.println("4. Actualizar motor");
            System.out.println("5. Eliminar motor");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    registrarMotor();
                    break;
                case 2:
                    listarMotores();
                    break;
                case 3:
                    buscarMotor();
                    break;
                case 4:
                    actualizarMotor();
                    break;
                case 5:
                    eliminarMotor();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 6);
        scanner.close();
    }

    private static void registrarMotor() {
        System.out.print("¿Tipo de motor? (1: Gasolina, 2: Eléctrico): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Número de motor: ");
        String numero = scanner.nextLine();
        System.out.print("Caballos de fuerza: ");
        int caballos = scanner.nextInt();
        System.out.print("Cilindraje: ");
        double cilindraje = scanner.nextDouble();
        scanner.nextLine();
        if (tipo == 1) {
            System.out.print("Consumo de combustible (L/100km): ");
            double consumo = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Tipo de gasolina: ");
            String tipoGas = scanner.nextLine();
            MotorGasolina mg = new MotorGasolina(numero, caballos, cilindraje, consumo, tipoGas);
            controller.agregarMotor(mg);
        } else if (tipo == 2) {
            System.out.print("Voltaje: ");
            int voltaje = scanner.nextInt();
            System.out.print("Autonomía: ");
            double autonomia = scanner.nextDouble();
            MotorElectrico me = new MotorElectrico(numero, caballos, cilindraje, voltaje, autonomia);
            controller.agregarMotor(me);
        } else {
            System.out.println("Tipo de motor inválido.");
        }
    }

    private static void listarMotores() {
        List<Motor> motores = controller.listarMotores();
        if (motores.isEmpty()) {
            System.out.println("No hay motores registrados.");
        } else {
            motores.forEach(m -> System.out.println(m.getInfo()));
        }
    }

    private static void buscarMotor() {
        System.out.print("Ingrese el número de motor: ");
        String numero = scanner.nextLine();
        Optional<Motor> motor = controller.buscarMotor(numero);
        if (motor.isPresent()) {
            System.out.println(motor.get().getInfo());
        } else {
            System.out.println("Motor no encontrado.");
        }
    }

    private static void actualizarMotor() {
        System.out.print("Ingrese el número de motor a actualizar: ");
        String numero = scanner.nextLine();
        Optional<Motor> motorOpt = controller.buscarMotor(numero);
        if (motorOpt.isPresent()) {
            Motor motor = motorOpt.get();
            System.out.print("Nuevo caballaje: ");
            int caballos = scanner.nextInt();
            System.out.print("Nuevo cilindraje: ");
            double cilindraje = scanner.nextDouble();
            scanner.nextLine();
            if (motor instanceof MotorGasolina) {
                System.out.print("Nuevo consumo de combustible: ");
                double consumo = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Nuevo tipo de gasolina: ");
                String tipoGas = scanner.nextLine();
                controller.actualizarMotor(new MotorGasolina(numero, caballos, cilindraje, consumo, tipoGas));
            } else if (motor instanceof MotorElectrico) {
                System.out.print("Nuevo voltaje: ");
                int voltaje = scanner.nextInt();
                System.out.print("Nueva autonomía: ");
                double autonomia = scanner.nextDouble();
                controller.actualizarMotor(new MotorElectrico(numero, caballos, cilindraje, voltaje, autonomia));
            }
        } else {
            System.out.println("Motor no encontrado.");
        }
    }

    private static void eliminarMotor() {
        System.out.print("Ingrese el número de motor a eliminar: ");
        String numero = scanner.nextLine();
        controller.eliminarMotor(numero);
    }
} 