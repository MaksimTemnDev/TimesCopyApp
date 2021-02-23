package com.example.timescopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> head = new ArrayList<>();
    ArrayList<String> article_content = new ArrayList<>();
    Storage_Of_MainTXT databaseHelper;
    SQLiteDatabase storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        databaseHelper  = new Storage_Of_MainTXT(getApplicationContext());
        storage = databaseHelper.getReadableDatabase();
        Cursor cursor = storage.query(Storage_Of_MainTXT.TABLE_ARTICLES, null, null, null, null, null, null);
            int index = cursor.getColumnIndex(Storage_Of_MainTXT.KEY_ID);
            int titleId = cursor.getColumnIndex(Storage_Of_MainTXT.KEY_TITLE);
            int articleId = cursor.getColumnIndex(Storage_Of_MainTXT.KEY_ARTICLE);
            while (cursor.moveToNext()) {
                head.add(cursor.getString(titleId));
            }
            cursor.close();
        databaseHelper.close();
        head.add("История о Есенине");
        head.add("Срочное сообщение!");
        head.add("Биография Есенина");
        String[] Titles = head.toArray(new  String[head.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Titles);
        listView.setAdapter(adapter);
        Button btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == position){
                    Intent intent = new Intent(MainActivity.this, ActivityOfArticle.class);
                    startActivity(intent);
                }
            }
        });

    }
}