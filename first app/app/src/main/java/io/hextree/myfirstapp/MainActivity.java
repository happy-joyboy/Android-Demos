package io.hextree.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
    String TAG = "Hello_LogCat";

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

        count_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Log.i(TAG, "Button clicked, count incremented to: " + count);

                // Update the text
                count_txt.setText(String.format("Counting: %d", count));
                Log.d(TAG, "Text updated to: Counting: " + count);

                // Check if count has reached 10
                if (count == 10) {
                    Log.w(TAG, "Count reached 10!");
                    count_txt.setText("Yessssssssss");
                }

                // For demonstration of error log
                if (count > 10) {
                    Log.e(TAG, "Count exceeded 10! Unexpected behavior.");
                }

                // Example of using Log.wtf for something that should never happen
                if (count < 0) {
                    Log.wtf(TAG, "How did the count go negative?! Something went terribly wrong.");
                }
            }
        });
    }
}