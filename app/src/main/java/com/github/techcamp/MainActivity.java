package com.github.techcamp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText mTypeMessage;
    Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTypeMessage = findViewById(R.id.textField);
        mSubmit = findViewById(R.id.button);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mTypeMessage.getText().toString().trim();
                if (text.isEmpty()) {
                    mTypeMessage.setError("Cannot be Empty");
                    mTypeMessage.requestFocus();
                } else {
                    Log.d("mTypeMessage", text);
                    Toast.makeText(MainActivity.this, "textField: " + text, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}