package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class PaletteActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(R.string.palette);

        gridView = findViewById(R.id.grid_view);

        Resources res = this.getResources();

        String[] colores = res.getStringArray(R.array.colors);

        final ArrayList<String> colors = (ArrayList<String>) Arrays.asList(colores);

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