package myapps.exchangerate;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Адаптер для отображения кастомизированного списка валют
 */

public class CurrencyListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    List<Currency> objects;

    CurrencyListAdapter(Context context) {
        ctx = context;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    CurrencyListAdapter(Context context, List<Currency> currencyList) {
        ctx = context;
        objects = currencyList;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // количество элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.currency_row, parent, false);
        }

        Currency c = getCurrency(position);

        // заполнение элемента View :
        ((TextView) view.findViewById(R.id.currency_char_code)).setText(c.getCharCode());
        ((TextView) view.findViewById(R.id.currency_name)).setText(c.getName());
        ((TextView) view.findViewById(R.id.currency_nominal)).setText(c.getNominal());
        ((TextView) view.findViewById(R.id.currency_value)).setText(c.getValue());

        return view;
    }

    // возвращает Currency по позиции
    Currency getCurrency(int position) {
        return ((Currency) getItem(position));
    }

}
