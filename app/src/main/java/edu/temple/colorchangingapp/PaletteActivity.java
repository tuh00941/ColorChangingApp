package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(R.string.palette);

        gridView = findViewById(R.id.grid_view);

        final ArrayList<String> colors = new ArrayList<>();

        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("magenta");
        colors.add("yellow");
        colors.add("black");
        colors.add("white");
        colors.add("purple");
        colors.add("cyan");
        colors.add("lime");
        colors.add("gray");
        colors.add("maroon");

        ColorAdapter adapter = new ColorAdapter(PaletteActivity.this, colors);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent canvasActivityIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                canvasActivityIntent.putExtra("color", colors.get(position));
                startActivity(canvasActivityIntent);
            }
        });
    }
}