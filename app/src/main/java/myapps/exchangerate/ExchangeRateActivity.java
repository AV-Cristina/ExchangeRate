package myapps.exchangerate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import android.view.Gravity;
import java.lang.String;
import java.util.List;

/**
 * Активность загружающая из интернета и отображающая курсы валют
 */

public class ExchangeRateActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";

    private static final String URL = "http://www.cbr.ru/scripts/XML_daily.asp";

    // listView для отображения списка валют
    private ListView listView;

    // адаптер для кастомизированного списка объектов Currency
    private CurrencyListAdapter currencyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_rate);

        // создание listView для отображения списка
        listView = (ListView) findViewById(R.id.listView);

        // создание адаптера
        currencyListAdapter = new CurrencyListAdapter(this);

        // используется AsyncTask, чтобы загрузить XML и вывести список валют
        new DownloadXmlTask().execute(URL);
    }

    public void onClickRefreshData(View view){
        new DownloadXmlTask().execute(URL);
    }

    private class DownloadXmlTask extends AsyncTask<String, Void, List<Currency>> {
        @Override
        protected List<Currency> doInBackground(String... urls) {
            List<Currency> currencyList = null;
            XmlLoader xmlLoader = new XmlLoader(URL);
            try {
                currencyList = xmlLoader.loadXmlFromNetwork();
            } catch (IOException e) {
                Log.d(LOG_TAG, "Connection error");
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                Log.d(LOG_TAG, "XML error");
                e.printStackTrace();
            }
            return currencyList;
        }

        @Override
        protected void onPostExecute(List<Currency> currencyList) {
            // вывод загруженного из xml-файла списка
            currencyListAdapter = new CurrencyListAdapter(ExchangeRateActivity.this, currencyList);
            listView.setAdapter(currencyListAdapter);
        }
    }
}
