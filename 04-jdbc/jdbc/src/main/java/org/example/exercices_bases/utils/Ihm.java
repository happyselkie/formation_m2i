package org.example.exercices_bases.utils;

import java.sql.*;
import java.util.Scanner;

public class Ihm {

    private final Scanner scanner;
    private final Connection connection;

    public Ihm(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n==== GESTION DES ETUDIANTS ====");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher tous les etudiants");
            System.out.println("3. Afficher les étudiants d'une classe");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> addStudent();
                case "2" -> getAll();
                case "3" -> getByClassroomNum();
                case "4" -> deleteStudent();
                case "0" -> {
                    System.out.println("Au revoir !");
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    public void addStudent(){
        System.out.print("Nom : ");
        String lastname = scanner.nextLine();
        System.out.print("Prénom : ");
        String firstname = scanner.nextLine();
        System.out.print("Numéro de classe : ");
        int classroom_num = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Date de diplôme (jj-mm-yy) : ");
        String degree_date = scanner.nextLine();

        String request = "INSERT INTO students (firstname, lastname, classroom_num, degree_date) VALUES (?,?,?,?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setInt(3, classroom_num);
            preparedStatement.setString(4, degree_date);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                System.out.println("Un nouvel étudiant à l'id " + resultSet.getInt(1) + " vient d'être ajouté");
            }

        } catch (SQLException e){
            System.out.println("La requete " + request + " a échoué : "+e.getMessage());
        }
    }

    public void getAll(){
        String request = "SELECT  * FROM students";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()){
                System.out.print("Étudiant (id:"+resultSet.getInt("id")+") ");
                System.out.print(resultSet.getString("firstname") + " ");
                System.out.print(", numéro de classe : " + resultSet.getInt("classroom_num") + " ");
                System.out.println(", Date du diplôme : " + resultSet.getString("degree_date"));
                System.out.println("---------------------------------------------------------");
            }
        } catch (SQLException e){
            System.out.println("La requete " + request + " a échoué : "+e.getMessage());
        }
    }

    public void getByClassroomNum(){
        System.out.println("Veuillez saisir un numéro de classe : ");
        int classroom_num = scanner.nextInt();
        scanner.nextLine();
        String request = "SELECT * FROM students where classroom_num = ?";

        try{
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, classroom_num);

            ResultSet resultSet = statement.executeQuery();
            System.out.println("Étudiants de la classe numéro "+classroom_num+ ": ");
            while (resultSet.next()){
                System.out.print("Étudiant (id:"+resultSet.getInt("id")+") ");
                System.out.print(resultSet.getString("firstname") + " ");
                System.out.print(", numéro de classe : " + resultSet.getInt("classroom_num") + " ");
                System.out.println(", Date du diplôme : " + resultSet.getString("degree_date"));
                System.out.println("---------------------------------------------------------");
            }
        } catch (SQLException e){
            System.out.println("La requete " + request + " a échoué : "+e.getMessage());
        }
    }

    public void deleteStudent(){

        System.out.println("Quel id d'étudiant voulez-vous supprimer ?");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();
        String request = "DELETE FROM students where id = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, idToDelete);

            int rows = preparedStatement.executeUpdate();

            if(rows > 0){
                System.out.println(rows + " étudiant a été affecté");
                System.out.println("l'étudiant avec l'id "+idToDelete+" a bien été supprimé");
            }

        } catch (SQLException e){
            System.out.println("La requete " + request + " a échoué : "+e.getMessage());
        }
    }
}
