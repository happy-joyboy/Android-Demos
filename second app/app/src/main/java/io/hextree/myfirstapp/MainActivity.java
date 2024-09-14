package io.hextree.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView count_txt = findViewById(R.id.count_txt);
        Button count_btn = findViewById(R.id.count_btn);
        Button GO_Activity3 = findViewById(R.id.button2);
        Button web_browser = findViewById(R.id.button3);

        count_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                count_txt.setText(String.format("Counting: %d", count));
                if (count == 10) {
                    count_txt.setText("Yessssssssss");
                }

            }
        });

        GO_Activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Go_Activity3_intent = new Intent(MainActivity.this, Activity3.class);
                startActivity(Go_Activity3_intent);
            }
        });

        web_browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntnet = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/"));
                startActivity(browserIntnet);
            }
        });
    }
}