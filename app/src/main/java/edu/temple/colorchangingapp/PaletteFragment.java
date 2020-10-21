package edu.temple.colorchangingapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {

    GridView gridView;
    ColorChangeInterface parentActivity;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String COLORS = "colors";
    private static final String ENGLISH_COLORS = "englishColors";

    public ArrayList<String> colors;
    public ArrayList<String> englishColors;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof ColorChangeInterface) {
            parentActivity = (ColorChangeInterface) context;
        }
        else {
            throw new RuntimeException("Implement the ColorChangeInterface. Please.");
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param colors The colors (Current language).
     * @param englishColors The colors (guaranteed English language).
     * @return A new instance of fragment PaletteFragment.
     */
    public static PaletteFragment newInstance(ArrayList<String> colors, ArrayList<String> englishColors) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(COLORS, colors);
        args.putStringArrayList(ENGLISH_COLORS, englishColors);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colors = getArguments().getStringArrayList(COLORS);
            englishColors = getArguments().getStringArrayList(ENGLISH_COLORS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View l = inflater.inflate(R.layout.fragment_palette, container, false);

        gridView = l.findViewById(R.id.grid_view);

        final ColorAdapter adapter = new ColorAdapter((Context) parentActivity, colors);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentActivity.changeColor(position);
            }
        });

        return l;
    }

    interface ColorChangeInterface {
        void changeColor(int position);
    }
}