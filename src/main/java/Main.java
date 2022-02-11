import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/9828ef4989632378cb01f05c18a0ca3a47781f777d705291ec60422ef13d871c").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select(".CurrentConditions--location--kyTeL");
        Elements newsHeadlines2 = doc.select(".CurrentConditions--tempValue--3a50n");
        Elements newsHeadlines3 = doc.select(".CurrentConditions--phraseValue--2Z18W");

        for (Element headline : newsHeadlines) {
            System.out.println(headline.html());
        }
        for (Element headline : newsHeadlines2) {
            System.out.println(headline.html());
        }
        for (Element headline : newsHeadlines3) {
            System.out.println(headline.html());
        }
    }
}
