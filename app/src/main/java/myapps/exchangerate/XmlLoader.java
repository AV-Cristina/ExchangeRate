package myapps.exchangerate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import org.xmlpull.v1.XmlPullParserException;
import java.util.List;
import java.net.URL;

/**
 * Класс для загрузки xml-файла и передачи его парсеру
 */

public class XmlLoader {
    private String urlString;

    public XmlLoader(String urlString) {
        this.urlString = urlString;
    }

    public List<Currency> loadXmlFromNetwork() throws XmlPullParserException, IOException {
        InputStream stream = null;
        List<Currency> currencyList  = null;
        CurrencyXmlParser currencyXmlParser = new CurrencyXmlParser();
        try {
            stream = downloadUrl();
            currencyList = currencyXmlParser.parse(stream);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return currencyList;
    }

    private InputStream downloadUrl() throws IOException {
        URL url = new URL(this.urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 );
        conn.setConnectTimeout(15000 );
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }

}