package com.lohum.lohum_price_scraper;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PriceController {

    @GetMapping("/price")
    public String getPrice() throws IOException {
        String url = "https://www.metal.com/Lithium-ion-Battery/202303240001";
        try {
            Document doc = Jsoup.connect(url).get();
            String price = doc.selectFirst(".priceDown___2TbRQ").text();
            return price;
        } catch (Exception error) {
            return "Encountered an error while fetching the price. " + "(Error: "+ error.getMessage()+")";
        }
    }
}
