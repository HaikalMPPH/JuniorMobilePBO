package com.sugiartha.juniorandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NegaraAdapter extends BaseAdapter {
    TextView text1, text2;
    ImageView imgView;
    String[][] data;
    Activity activity;

    public NegaraAdapter(Activity activity, String[][] data) {
        super();
        this.data = data;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(activity);
            v = vi.inflate(R.layout.activity_list_view, null);
        }

        Object p = getItem(position);

        if (p != null) {
            imgView = v.findViewById(R.id.imgView);
            text1 = v.findViewById(R.id.text1);
            text2 = v.findViewById(R.id.text2);

            int id = activity.getResources().getIdentifier(data[position][2], "drawable", activity.getPackageName());
            Drawable drawable = activity.getResources().getDrawable(id);

            imgView.setImageDrawable(drawable);
            text1.setText(data[position][0]);
            text2.setText(data[position][1]);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String selectedCountry = data[position][0];
                    showToast(selectedCountry);
                }
            });
        }

        return v;
    }

    private void showToast(String message) {
        Context context = activity.getApplicationContext();
        CharSequence text = "Anda memilih negara " + message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
