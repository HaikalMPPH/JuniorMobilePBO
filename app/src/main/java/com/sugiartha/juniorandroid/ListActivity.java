package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    // Mendeklarasikan ListView var dan menginisialisasi array tipe data string
    private ListView lvItem;
    private String[] namanegara = new String[]{
            "Indonesia","Malaysia","Singapore" ,
            "Italia", "Inggris", "Belanda",
            "Argentina","Chile",
            "Mesir", "Uganda"};

    SearchView searchView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setTitle("ListView Sederhana"); // Tampil judul

        // Membinding atau memformat data
        lvItem = (ListView) findViewById(R.id.list_view);

        // Generate a numbered list by creating a new array with numbered items
        String[] numberedNamanegara = new String[namanegara.length];
        for (int i = 0; i < namanegara.length; i++) {
            numberedNamanegara[i] = (i + 1) + ". " + namanegara[i];
        }

        adapter = new ArrayAdapter<String>(ListActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, numberedNamanegara);

        // Menset data di dalam ListView
        lvItem.setAdapter(adapter);

        // Mencari
        searchView = findViewById(R.id.search_bar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ListActivity.this.adapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ListActivity.this.adapter.getFilter().filter(newText);

                return false;
            }
        });

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ListActivity.this,
                        "Memilih : "+namanegara[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}

