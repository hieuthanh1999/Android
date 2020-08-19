package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> arr;
    ArrayAdapter adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     list = (ListView) findViewById(R.id.listview);

     arr = new ArrayList<>();
     ds();
     adt = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arr);
     list.setAdapter(adt);

     list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
         @Override
         public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               Delete(i);
            // Toast.makeText(MainActivity.this, "đây là :" +arr.get(i), Toast.LENGTH_SHORT).show();

             return false;
         }
     });
    }

    private  void Delete(final  int vitri)
    {
            // khai báo
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo nè!");
        alertDialog.setMessage("Bạn có chắc chắn muốn xóa không?");


        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              arr.remove(vitri);
                adt.notifyDataSetChanged();
            }
        });
       alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {

           }
       });
        alertDialog.show();
    }
    private void ds()
    {
        arr.add("Android");
        arr.add("IOS");
        arr.add("C#");
        arr.add("Java");
    }
}
