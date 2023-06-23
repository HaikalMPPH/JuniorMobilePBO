package com.sugiartha.juniorandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sugiartha.juniorandroid.adapter.Adapter;
import com.sugiartha.juniorandroid.helper.DbHelper;
import com.sugiartha.juniorandroid.model.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SQLiteActivity extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> itemList = new ArrayList<>();
    Adapter adapter;
    DbHelper SQLite;

    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_ADDRESS = "address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SQLite = new DbHelper(getApplicationContext());
        listView = findViewById(R.id.list_view);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SQLiteActivity.this, AddEditActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
            }
        });

        adapter = new Adapter(SQLiteActivity.this, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                final String idx = itemList.get(position).getId();
                final String name = itemList.get(position).getName();
                final String address = itemList.get(position).getAddress();

                final CharSequence[] dialogitem = {"Edit", "Delete"};
                dialog = new AlertDialog.Builder(SQLiteActivity.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(SQLiteActivity.this, AddEditActivity.class);
                                intent.putExtra(TAG_ID, idx);
                                intent.putExtra(TAG_NAME, name);
                                intent.putExtra(TAG_ADDRESS, address);
                                startActivity(intent);
                                break;
                            case 1:
                                deleteData(Integer.parseInt(idx), position); // Panggil fungsi deleteData
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });

        getAllData();
    }

    private void getAllData() {
        SQLite = new DbHelper(getApplicationContext());
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(TAG_ID);
            String name = row.get(i).get(TAG_NAME);
            String address = row.get(i).get(TAG_ADDRESS);

            Data data = new Data();

            data.setId(id);
            data.setName("Nama: " + name);
            data.setAddress("Alamat: " + address);

            itemList.add(data);
        }
        adapter.notifyDataSetChanged();
    }


    // Fungsi untuk menghapus data dari database SQLite
    private void deleteData(int id, final int position) {
        SQLite.delete(id);
        itemList.remove(position);
        adapter.notifyDataSetChanged();
    }
}
