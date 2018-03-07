package pl.sklepzproduktami.demo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class Database {
    ArrayList<Product> produkty = new ArrayList<>();

    public Database() {
        Product prod1= new Product("Mleko", 3, "spożywczy");
        Product prod2= new Product("Fairy", 8, "domowy");
        Product prod3= new Product("Opona", 400, "inny");
        Product prod4=new Product("Masło", 15, "spożywczy");
        Product prod5= new Product("Żelazko", 200, "domowy");
        Product prod6=new Product("Drewno", 250, "inny");
        produkty.add(prod1);
        produkty.add(prod2);
        produkty.add(prod3);
        produkty.add(prod4);
        produkty.add(prod5);
        produkty.add(prod6);
   }
}


