package io.hextree.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button Go_MainActivity = findViewById(R.id.button1);
        Button Go_Activity2 = findViewById(R.id.button4);

        Go_MainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GO_MainActivity_intent = new Intent(Activity3.this, MainActivity.class);
                startActivity(GO_MainActivity_intent);
            }
        });

        Go_Activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GO_Activity2_intent = new Intent(Activity3.this, Activity2.class);
                startActivity(GO_Activity2_intent);
            }
        });
    }
}