package org.example.tp_parc.utils;

import org.example.tp_parc.dao.OperatingSystemDAO;
import org.example.tp_parc.dao.ProcessorDAO;
import org.example.tp_parc.entity.Computer;
import org.example.tp_parc.entity.Identification;
import org.example.tp_parc.entity.OperatingSystem;
import org.example.tp_parc.entity.Processor;
import org.example.tp_parc.service.ComputerService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private static ComputerService computerService = new ComputerService();
    private static ProcessorDAO processorDAO = new ProcessorDAO();
    private static OperatingSystemDAO operatingSystemDAO = new OperatingSystemDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Computer System **************************");
            System.out.println("*   [1] Ajouter un ordinateur                                    *");
            System.out.println("*   [2] Ajouter un Processeur                                    *");
            System.out.println("*   [3] Ajouter un OS                                            *");
            System.out.println("*   [4] Modifier un ordinateur                                   *");
            System.out.println("*   [5] Supprimer un ordinateur                                  *");
            System.out.println("*   [6] Voir tous les ordinateurs                                *");
            System.out.println("*   [7] Voir tous les ordinateurs en fonction de leur processeur *");
            System.out.println("*   [8] Voir tous les ordinateurs en fonction de leur os         *");
            System.out.println("*   [0] Quitter                                                  *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createComputer();
                    break;
                case 2:
                    createProcessor();
                    break;
                case 3:
                    createOS();
                    break;
                case 4:
                    updateComputer();
                    break;
                case 5:
                    deleteComputer();
                    break;
                case 6:
                    displayAllComputers();
                    break;
                case 7:
                    displayComputersByProcessor();
                    break;
                case 8:
                    displayComputersByOS();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void createComputer() {
        System.out.print("Modèle de la machine  : ");
        String modelName = scanner.nextLine();
        System.out.print("ID du processeur  : ");
        int proId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID de l'OS  : ");
        int OSId = scanner.nextInt();
        scanner.nextLine();

        Processor processor;
        OperatingSystem operatingSystem;

        try{
            processor = processorDAO.getById(proId, Processor.class);
        } catch (EntityNotFoundException e){
            System.out.printf("Il n'y a aucun processeur à cet id");
            return;
        }

        try{
           operatingSystem = operatingSystemDAO.getById(OSId, OperatingSystem.class);
        } catch (EntityNotFoundException e){
            System.out.printf("Il n'y a aucun OS à cet id");
            return;
        }

        computerService.create(modelName, new Identification("FF:FF:FF:FF:FF:FF", "127.0.0.1"), processor,operatingSystem);
    }

    private static void createProcessor() {
        System.out.print("Marque du processeur : ");
        String proBrandName = scanner.nextLine();
        System.out.print("Nom du processeur : ");
        String proName = scanner.nextLine();

        Processor processor = Processor.builder().brand(proBrandName).name(proName).build();
        processorDAO.save(processor);
    }

    private static void createOS() {
        System.out.print("Nom de l'OS : ");
        String osName = scanner.nextLine();
        System.out.print("Version de l'OS : ");
        String osVersion = scanner.nextLine();

        OperatingSystem operatingSystem = OperatingSystem.builder().name(osName).version(osVersion).build();
        operatingSystemDAO.save(operatingSystem);
    }

    private static void updateComputer() {
        System.out.println("Saisir l'id de l'ordinateur à modifier :");
        int id = scanner.nextInt();
        scanner.nextLine();
        Computer computer = null;

        try {
            computer = computerService.getComputerById(id);
        } catch (Exception e) {
            System.out.println("Il n'y a pas d'ordinateur avec cet id");
        }

        boolean back = false;
        while (!back) {
            System.out.printf("====== Que voulez-vous faire ? =====");
            System.out.printf("====== [1] modifier le modèle ======");
            System.out.printf("====== [2] modifier le processeur ==");
            System.out.printf("====== [3] modifier l'OS ===========");
            System.out.printf("====== [0] Retour ==================");

            int choice2 = scanner.nextInt();
            scanner.nextLine();
            switch (choice2) {
                case 1:
                    System.out.println("Saisir le modèle :");
                    computer.setModel(scanner.nextLine());
                    System.out.printf("Le modèle a été modifié");
                    back = true;
                    break;
                case 2:
                    System.out.println("Saisir l'id du processeur :");
                    int proId = scanner.nextInt();
                    scanner.nextLine();
                    Processor processor;
                    try {
                        processor = processorDAO.getById(proId, Processor.class);
                    } catch (EntityNotFoundException e) {
                        System.out.printf("Il n'y a aucun processeur à cet id");
                        break;
                    }
                    computer.setProcessor(processor);
                    System.out.println("le processeur a été modifié");
                    back = true;
                    break;
                case 3:
                    System.out.print("ID de l'OS  : ");
                    int OSId = scanner.nextInt();
                    scanner.nextLine();
                    OperatingSystem operatingSystem;
                    try {
                        operatingSystem = operatingSystemDAO.getById(OSId, OperatingSystem.class);
                    } catch (EntityNotFoundException e) {
                        System.out.printf("Il n'y a aucun OS à cet id");
                        break;
                    }
                    computer.setOperatingSystem(operatingSystem);
                    System.out.println("l'os a été modifié");
                    back = true;
                    break;
                default :
                    System.out.println("Choix invalide !");
                    break;
            }
        }
    }

    private static void deleteComputer() {
        System.out.print("ID de l'ordinateur à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        computerService.deleteComputer(id);
        System.out.println("Ordinateur supprimé avec succès !");
    }

    private static void displayAllComputers() {
        List<Computer> computers = computerService.getAll();
        for (Computer computer : computers) {
            System.out.println(computer);
        }
    }

    private static void displayComputersByProcessor() {
        System.out.println("Saisir l'id du processeur :");
        int proId = scanner.nextInt();
        scanner.nextLine();

        Processor processor;
        try {
            processor = processorDAO.getById(proId, Processor.class);
        } catch (EntityNotFoundException e) {
            System.out.printf("Il n'y a aucun processeur à cet id");
            return;
        }

        List<Computer> computers = computerService.getComputersByProcessor(processor);
        for (Computer computer : computers) {
            System.out.println(computer);
        }
    }

    private static void displayComputersByOS() {
        System.out.println("Saisir l'id de l'OS :");
        int osId = scanner.nextInt();
        scanner.nextLine();

        OperatingSystem os;
        try {
            os = operatingSystemDAO.getById(osId, OperatingSystem.class);
        } catch (EntityNotFoundException e) {
            System.out.printf("Il n'y a aucun OS à cet id");
            return;
        }

        List<Computer> computers = computerService.getComputersByOs(os);
        for (Computer computer : computers) {
            System.out.println(computer);
        }
    }
}
