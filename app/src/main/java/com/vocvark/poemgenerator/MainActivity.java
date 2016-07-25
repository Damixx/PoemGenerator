package com.vocvark.poemgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    SeekBar countWordsSB;
    SeekBar countLinesSB;

    TextView countWordsT;
    TextView countLinesT;

    Spinner spinner;


    String[] data = {"one", "two", "three", "four", "five"};


    int countWords;
    int countLines;
    int meter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countWords = 3;
        countLines = 4;

        countWordsSB = (SeekBar) findViewById(R.id.countWordsSeekBar);
        countLinesSB = (SeekBar) findViewById(R.id.countLinesSeekBar);
        countWordsT = (TextView) findViewById(R.id.countWordsText);
        countLinesT = (TextView) findViewById(R.id.countLinesText);
        spinner = (Spinner) findViewById(R.id.meter);

        ArrayAdapter<String> meterAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, data);
        meterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(meterAdapter);

        spinner.setPrompt("Метр");
        spinner.setSelection(0);

        AdapterView.OnItemSelectedListener selectListner = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                meter = position;
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        spinner.setOnItemSelectedListener(selectListner);
        countWordsSB.setOnSeekBarChangeListener(this);
        countLinesSB.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        switch (seekBar.getId()){
            case R.id.countWordsSeekBar:
                countWords = progress;
                countWordsT.setText(String.valueOf(countWords));
                break;
            case R.id.countLinesSeekBar:
                countLines = progress;
                countLinesT.setText(String.valueOf(countLines));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
