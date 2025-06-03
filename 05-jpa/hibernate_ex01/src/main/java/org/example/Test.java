package org.example;

import org.example.entity.Product;
import org.example.repository.ProductDAO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        /************EX01***************/
/*
        *Product playstation = Product.builder().brand("Sony").ref("F424242").price(399.9).stock(25).purchaseDate(sqlDate("25/05/2025")).build();
        Product nintendoSwitch = Product.builder().brand("Nintendo").ref("242424F").price(299.9).stock(40).purchaseDate(sqlDate("24/04/2025")).build();
        Product xbox = Product.builder().brand("Microsoft").ref("F4E7SQD4F").price(349.9).stock(60).purchaseDate(sqlDate("23/03/2025")).build();
        Product steamDeck = Product.builder().brand("Valve").ref("42D42G42T").price(599.9).stock(10).purchaseDate(sqlDate("22/02/2025")).build();
        Product rogueAlly = Product.builder().brand("Asus").ref("4FG48F4D5S").price(725.9).stock(5).purchaseDate(sqlDate("21/01/2025")).build();

        productDAO.save(playstation);
        productDAO.save(nintendoSwitch);
        productDAO.save(xbox);
        productDAO.save(steamDeck);
        productDAO.save(rogueAlly);

        productDAO.findById(2);
        productDAO.delete(productDAO.findById(3));

        rogueAlly.setRef("F7454F5");
       productDAO.save(rogueAlly);*/


        /************EX02***************/
        /*
          List<Product> productsAll = productDAO.get();

        for (Product product : productsAll) {
            System.out.println(product);
        }


        List<Product> productsMaxFiveHundreds = productDAO.getByPriceUnderAmount(500);

        for (Product product : productsMaxFiveHundreds) {
            System.out.println(product);
        }
        List<Product> productsApril = productDAO.getFromToDates("2025-04-01","2025-04-30");

        for (Product product : productsApril) {
            System.out.println(product);
        }*/


        /************EX03***************/
        /*1. Afficher la liste des produits commandés entre deux dates lus au clavier.*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date 1 (yyyy-MM-dd): ");
        String date1 = scanner.nextLine();
        System.out.println("Enter date 2 (yyyy-MM-dd): ");
        String date2 = scanner.nextLine();

        List<Product> productsApril = productDAO.getFromToDates(convertDate(date1),convertDate(date2));

        for (Product product : productsApril) {
            System.out.println(product);
        }

        /*2. retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.*/
        System.out.println("Entrer le stock : ");
        int stock = scanner.nextInt();
        scanner.nextLine();



        /*1. Afficher la valeur du stock des produits d'une marque choisie.*/




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

/*    public static Date sqlDate(String date){
        java.util.Date purchaseDate = new java.util.Date();

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try{
            purchaseDate = df.parse(date);
        } catch (ParseException e){
            System.out.println("date format error");
            return null;
        }

        java.sql.Date sqlDate = new java.sql.Date(purchaseDate.getTime());
        return sqlDate;
    }*/
}
