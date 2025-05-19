package org.example.ihm;

import org.example.model.Todo;
import org.example.service.TodoService;

import java.util.Scanner;

public class Ihm {
    private final TodoService service;
    private final Scanner scanner;

    public Ihm(TodoService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n==== TODO LIST ====");
            System.out.println("1. Créer une tâche");
            System.out.println("2. Voir toutes les tâches");
            System.out.println("3. Modifier une tâche");
            System.out.println("4. Supprimer une tâche");
            System.out.println("5. Marquer tâche comme faite / non faite");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> createTodo();
                case "2" -> showAll();
                case "3" -> updateTodo();
                case "4" -> deleteTodo();
                case "5" -> toggleTodo();
                case "6" -> {
                    System.out.println("Au revoir !");
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    private void createTodo() {
        System.out.print("Nom : ");
        String name = scanner.nextLine();
        System.out.print("Description : ");
        String description = scanner.nextLine();
        service.add(name, description);
        System.out.println("Tâche ajoutée !");
    }

    private void showAll() {
        System.out.println("\nListe des tâches :");
        for (Todo todo : service.getAll()) {
            System.out.println(todo);
        }
    }

    private void updateTodo() {
        System.out.print("ID de la tâche à modifier : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nouveau nom : ");
        String name = scanner.nextLine();
        System.out.print("Nouvelle description : ");
        String description = scanner.nextLine();
        System.out.print("Est-ce fait ? (true/false) : ");
        boolean done = Boolean.parseBoolean(scanner.nextLine());
        service.update(id, name, description, done);
        System.out.println("Tâche modifiée !");
    }

    private void deleteTodo() {
        System.out.print("ID de la tâche à supprimer : ");
        int id = Integer.parseInt(scanner.nextLine());
        service.remove(id);
        System.out.println("Tâche supprimée !");
    }

    private void toggleTodo() {
        System.out.print("ID de la tâche à inverser : ");
        int id = Integer.parseInt(scanner.nextLine());
        service.toggleDone(id);
        System.out.println("État de la tâche inversé !");
    }
}
