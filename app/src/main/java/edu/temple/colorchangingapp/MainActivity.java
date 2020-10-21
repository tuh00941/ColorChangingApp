package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements PaletteFragment.ColorChangeInterface {

    ArrayList<String> colors;
    ArrayList<String> englishColors;
    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = this.getResources();
        String[] colores = res.getStringArray(R.array.colors);
        colors = new ArrayList<>(Arrays.asList(colores));
        final ColorAdapter adapter = new ColorAdapter(MainActivity.this, colors);
        englishColors = adapter.englishColors;

        PaletteFragment paletteFragment = PaletteFragment.newInstance(colors, englishColors);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ftp = fm.beginTransaction();
        ftp.add(R.id.container_1, paletteFragment).commit();

        canvasFragment = new CanvasFragment();
        FragmentTransaction ftc = fm.beginTransaction();
        ftc.add(R.id.container_2, canvasFragment).commit();
    }

    @Override
    public void changeColor(int position) {
        canvasFragment.textView.setText(colors.get(position));
        canvasFragment.l.setBackgroundColor(Color.parseColor(englishColors.get(position)));
    }
}