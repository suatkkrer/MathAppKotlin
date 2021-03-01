package com.suatkkrer.mathappkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GraphicActivity2 extends AppCompatActivity {

    int falseQuestion = 0;
    int trueQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic2);

        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> questions = new ArrayList<>();

        Intent intent = getIntent();

        falseQuestion = intent.getIntExtra("False",-1);
        trueQuestion = intent.getIntExtra("True",-1);

        if (trueQuestion != -1 && falseQuestion != -1){

            questions.add(new PieEntry(trueQuestion,"True Answers"));
            questions.add(new PieEntry(falseQuestion,"False Answers"));

            PieDataSet pieDataSet = new PieDataSet(questions,"");
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieDataSet.setValueTextColor(Color.BLACK);
            pieDataSet.setValueTextSize(16f);

            PieData pieData = new PieData(pieDataSet);

            pieChart.setData(pieData);
            pieChart.getDescription().setEnabled(false);
            pieChart.setCenterText("Questions");
            pieChart.animate();

        }

    }
}