package org.example;

import org.example.entity.Product;
import org.example.repository.ProductDAO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

/*        Product playstation = Product.builder().brand("Sony").ref("F424242").price(399.9).stock(25).purchaseDate(sqlDate("25/05/2025")).build();
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

        List<Product> productsAll = productDAO.get();

        /*for (Product product : productsAll) {
            System.out.println(product);
        }*/


        List<Product> productsMaxFiveHundreds = productDAO.getByPriceUnderAmount(500);

        /*for (Product product : productsMaxFiveHundreds) {
            System.out.println(product);
        }
*/
        List<Product> productsApril = productDAO.getFromToDates(sqlDate("01/01/2025"), sqlDate("30/12/2025"));

        for (Product product : productsApril) {
            System.out.println(product);
        }
    }


    public static Date sqlDate(String date){
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
    }
}
