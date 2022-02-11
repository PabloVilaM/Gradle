import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Document doc = null;
        //De manera previa tenemos que abrir el proyecto como Gradle y con las librerias de Java para poder programar.
        // Eso generará casi todo el proyecto solo, solo tenemos que añadir 2 lineas en la build de gradle para añadir la libreria de JSOUP de manera sencilla que es lo que nos permitira hacer el resto.
        // Estas son ambas lineas. jsoup HTML parser library @ https://jsoup.org/
        // jsoup HTML parser library @ https://jsoup.org/ implementation 'org.jsoup:jsoup:1.14.3

        //Aqui tenemos que hacer un try and catch, dado que la url o la web pueden desaparecer o cambiar lo cual nos daria error en el codigo y por eso lo capturamos
        try {
            doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/9828ef4989632378cb01f05c18a0ca3a47781f777d705291ec60422ef13d871c").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Imprimimos en pantalla el titulo de la página
        System.out.println(doc.title());
        //Buscamos los elementos que queremos y lo guardamos en un arraylist. Para buscarlos vamos a buscar por la clase de CSS a lo que corresponde el elemento HTML correspondiente.
        // Para encontrar el elemento con su clase inspeccionaremos elemento y lo leemos.
        //Lo hacemos 3 veces, 1 por cada elemento que queremos enseñar.
        Elements newsHeadlines = doc.select(".CurrentConditions--location--kyTeL");
        Elements newsHeadlines2 = doc.select(".CurrentConditions--tempValue--3a50n");
        Elements newsHeadlines3 = doc.select(".CurrentConditions--phraseValue--2Z18W");
        //Buscamos todos los elementos que haya en la lista y los imprimimos, al ser tan especifico con el select solo nos saldra uno de cada que sera lo que nos interesa.
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
