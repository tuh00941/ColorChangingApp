package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    View layout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        layout = findViewById(R.id.layout);
        textView = findViewById(R.id.textView);

        layout.setBackgroundColor(Color.parseColor(getIntent().getStringExtra("englishColor")));
        textView.setText(getIntent().getStringExtra("color"));
    }
}