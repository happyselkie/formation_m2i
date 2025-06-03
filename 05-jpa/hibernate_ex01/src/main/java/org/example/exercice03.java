package org.example;

import org.example.entity.Product;
import org.example.repository.ProductDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class exercice03 {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        /************EX03***************/
        /*1.1. Afficher la liste des produits commandés entre deux dates lus au clavier.*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date 1 (yyyy-MM-dd): ");
        String date1 = scanner.nextLine();
        System.out.println("Enter date 2 (yyyy-MM-dd): ");
        String date2 = scanner.nextLine();

        List<Product> productsApril = productDAO.getFromToDates(convertDate(date1), convertDate(date2));

        for (Product product : productsApril) {
            System.out.println(product);
        }

        /*1.2. retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.*/
        System.out.println("Entrer le stock : ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        List<Product> productsUnderStock =  productDAO.getRefUnderStock(stock);
        for (Product product : productsUnderStock) {
            System.out.println(product.getRef());
        }


        /*2.1. Afficher la valeur du stock des produits d'une marque choisie.*/
        System.out.println("Saisir une marque : ");
        String marque = scanner.nextLine();

        System.out.println(productDAO.getStockByBrand(marque));

        /*2.2. Calculer le prix moyen des produits.*/
        System.out.println("Prix moyen des produits : " + productDAO.getAvgPrice());


        /*2.3. Récupérer la liste des produits d'une marque choisie.*/
        System.out.println("Saisir une marque : ");
        String marque2 = scanner.nextLine();
        List<Product> ProductsByBrand = productDAO.getByBrand(marque2);

        for (Product product : ProductsByBrand) {
            System.out.println(product);
        }

        /*2.4. Supprimer les produits d'une marque choisie de la table produit.*/
        //System.out.println("Saisir une marque : ");
       // productDAO.deleteByBrand(scanner.nextLine());
    }

    public static LocalDate convertDate(String date){
        LocalDate purchaseDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        formatter = formatter.withLocale(Locale.FRANCE);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try{
            purchaseDate = LocalDate.parse(date, formatter);
        } catch (Exception e){
            System.out.println("date format error");
            return null;
        }

        return purchaseDate;
    }
}
