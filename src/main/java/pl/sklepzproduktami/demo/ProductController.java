package pl.sklepzproduktami.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    private Database datbas;

    public ProductController(Database database) {
        this.datbas = database;
    }

    @RequestMapping("/")
    public String main() {
        return "/index.html";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String printAll() {
        String tekst = "";
        double sumPrice=0;
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
            sumPrice = sumPrice + product.getPrice();

        }
        tekst+="<br/>Suma cen to: "+sumPrice;
        return tekst;
    }

    @RequestMapping("/spozywcze")
    @ResponseBody
    public String printSpozywcze() {
        String tekst = "";
        double sumPrice=0;
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            if (product.getCategory().equals("spożywczy")) {
                tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
                sumPrice = sumPrice + product.getPrice();
            }
        }
        tekst+="<br/>Suma cen to: "+sumPrice;
        return tekst;
    }

    @RequestMapping("/domowe")
    @ResponseBody
    public String printDomowe() {
        String tekst = "";
        double sumPrice=0;
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            if (product.getCategory().equals("domowy")) {
                tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
                sumPrice = sumPrice + product.getPrice();
            }
        }
        tekst+="<br/>Suma cen to: "+sumPrice;
        return tekst;
    }

    @RequestMapping("/inne")
    @ResponseBody
    public String printInne() {
        String tekst = "";
        double sumPrice=0;
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            if (product.getCategory().equals("inny")) {
                tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
                sumPrice = sumPrice + product.getPrice();
            }
        }
        tekst+="<br/>Suma cen to: "+sumPrice;
        return tekst;
    }
}
