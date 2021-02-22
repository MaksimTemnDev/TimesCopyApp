package com.example.timescopy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    Storage_Of_MainTXT databaseHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        databaseHelper = new Storage_Of_MainTXT(getApplicationContext());
        EditText editArticleText = findViewById(R.id.editTextTextArticle);
        EditText editHeadText = findViewById(R.id.editTextHead);
        Button add = findViewById(R.id.button);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String article = editArticleText.getText().toString();
                String heading = editHeadText.getText().toString();
                db = databaseHelper.getWritableDatabase();
                ContentValues contentValues =new ContentValues();
                contentValues.put(Storage_Of_MainTXT.KEY_TITLE, heading);
                contentValues.put(Storage_Of_MainTXT.KEY_ARTICLE, article);
                if (contentValues != null) {
                    db.insert(Storage_Of_MainTXT.TABLE_ARTICLES, null, contentValues);
                }
                Intent intent = new Intent(AddActivity.this, ActivityOfArticle.class);
                intent.putExtra("", article);
                intent.putExtra("h",heading);
                startActivity(intent);
            }
        });
    }

}