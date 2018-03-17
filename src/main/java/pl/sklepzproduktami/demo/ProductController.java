package pl.sklepzproduktami.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        double sumPrice = 0;
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
            sumPrice = sumPrice + product.getPrice();

        }
        tekst += "<br/>Suma cen to: " + sumPrice;
        return tekst;
    }

    @RequestMapping("/lista")
    @ResponseBody
    public String printAll(@RequestParam(value = "kategoria") String category) {
        String tekst = "";
        double sumPrice = 0;
        for (int i = 0; i < datbas.produkty.size(); i++) {
            Product product = datbas.produkty.get(i);
            if (product.getCategory().equals(category)) {
                tekst += product.getName() + " " + product.getPrice() + " " + product.getCategory() + "<br>";
                sumPrice = sumPrice + product.getPrice();
            }
        }
        tekst += "<br/>Suma cen to: " + sumPrice;
        return tekst;
    }

    @RequestMapping("/add")
    public String addProduct(@RequestParam(value = "nazwa") String name, @RequestParam(value = "cena", required = false, defaultValue = "0") String priceString, @RequestParam(value = "kategoria", required = false, defaultValue = "domowy") String category) {
        int parseInt = Integer.parseInt(priceString);
        Product product = new Product();
        product.setName(name);
        product.setPrice(parseInt);
        product.setCategory(category);
        datbas.produkty.add(product);
        return "redirect:/all";
    }
}
