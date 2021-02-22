package com.example.timescopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityOfArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_of_article);
        Button back = findViewById(R.id.getBack);
        MainActivity main = new MainActivity();
        Intent intent =getIntent();
        String heading = intent.getStringExtra("h");
        if(heading == null){
            heading = "Onece in world...";
        }else {
            Toast.makeText(ActivityOfArticle.this, heading, Toast.LENGTH_SHORT).show();
            main.head.add(heading);
        }

        String argument = intent.getStringExtra("");
        if(argument != null){
            main.article_content.add(argument);
        }else {
            main.article_content.add(0,"CHANGED Родился Сергей Есенин в селе Константиново Кузьминской волости Рязанского уезда Рязанской губернии, в крестьянской семье. Отец — Александр Никитич Есенин (1873—1931), мать — Татьяна Фёдоровна Титова (1875—1955). Сёстры — Екатерина (1905—1977), Александра (1911—1981), единоутробный брат[4] — Александр Иванович Разгуляев (1902—1961).\n" +
                    "\n" +
                    "В 1904 году Есенин пошёл в Константиновское земское училище, по окончании которого в 1909 году начал учёбу в церковно-приходской, второклассной учительской школе[5] (ныне музей С. А. Есенина) в Спас-Клепиках.\n" +
                    "\n" +
                    "По окончании школы, в августе 1912 года, Есенин переехал в Москву и начал работать в мясной лавке купца Крылова, где служил старшим приказчиком его отец. В это время Есенин жил в Общежитии одиноких приказчиков во владении купца Н. В. Крылова "+"\n"+"Родился Сергей Есенин в селе Константиново Кузьминской волости Рязанского уезда Рязанской губернии, в крестьянской семье. Отец — Александр Никитич Есенин (1873—1931), мать — Татьяна Фёдоровна Титова (1875—1955). Сёстры — Екатерина (1905—1977), Александра (1911—1981), единоутробный брат[4] — Александр Иванович Разгуляев (1902—1961).\n" +
                    "\n" +
                    "В 1904 году Есенин пошёл в Константиновское земское училище, по окончании которого в 1909 году начал учёбу в церковно-приходской, второклассной учительской школе[5] (ныне музей С. А. Есенина) в Спас-Клепиках.\n" +
                    "\n" +
                    "По окончании школы, в августе 1912 года, Есенин переехал в Москву и начал работать в мясной лавке купца Крылова, где служил старшим приказчиком его отец. В это время Есенин жил в Общежитии одиноких приказчиков во владении купца Н. В. Крылова "+"\n"+"Родился Сергей Есенин в селе Константиново Кузьминской волости Рязанского уезда Рязанской губернии, в крестьянской семье. Отец — Александр Никитич Есенин (1873—1931), мать — Татьяна Фёдоровна Титова (1875—1955). Сёстры — Екатерина (1905—1977), Александра (1911—1981), единоутробный брат[4] — Александр Иванович Разгуляев (1902—1961).\n" +
                    "\n" +
                    "В 1904 году Есенин пошёл в Константиновское земское училище, по окончании которого в 1909 году начал учёбу в церковно-приходской, второклассной учительской школе[5] (ныне музей С. А. Есенина) в Спас-Клепиках.\n" +
                    "\n" +
                    "По окончании школы, в августе 1912 года, Есенин переехал в Москву и начал работать в мясной лавке купца Крылова, где служил старшим приказчиком его отец. В это время Есенин жил в Общежитии одиноких приказчиков во владении купца Н. В. Крылова ");
        }
        TextView text = findViewById(R.id.Main_Text);
        String [] article_contentArray = main.article_content.toArray(new String[main.article_content.size()]);
        TextView head = findViewById(R.id.head);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getBck = new Intent(ActivityOfArticle.this, MainActivity.class);
                getBck.putExtra("0", main.head.toArray(new  String[main.head.size()]));
                startActivity(getBck);
            }
        });
        head.setText(heading);
        text.setText(article_contentArray[0]);
    }


}