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
    @ResponseBody
    public String printOption1() {
        return "WYŚWIETL WSZSYTKIE PRODUKTY";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String printAll() {
        String tekst = "";
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
        }
        return tekst;
    }

    @RequestMapping("/spozywcze")
    @ResponseBody
    public String printSpozywcze() {
        String tekst = "";
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            if (product.getCategory().equals("spożywczy")) {
                tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
            }
        }
        return tekst;
    }
    @ResponseBody
    public int sumPrices() {
        int sumPrice = 0;
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            if (product.getCategory().equals("spożywczy")) {
                sumPrice = sumPrice + product.getPrice();
            }
        }
        return sumPrice;
    }

    @RequestMapping("/domowe")
    @ResponseBody
    public String printDomowe() {
        String tekst = "";
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            if (product.getCategory().equals("domowy")) {
                tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
            }
        }
        return tekst;
    }

    @RequestMapping("/inne")
    @ResponseBody
    public String printInne() {
        String tekst = "";
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            if (product.getCategory().equals("inny")) {
                tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
            }
        }
        return tekst;
    }
}
