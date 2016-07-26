package com.vocvark.poemgenerator;

import android.content.res.Resources;
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

    Resources resources;

    SeekBar countWordsSB;
    SeekBar countLinesSB;

    TextView countWordsT;
    TextView countLinesT;

    Spinner metersS;
    Spinner dictionaryS;


    String[] meters;


    int countWords;
    int countLines;
    int meter;
    int dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resources = getResources();

        meters = resources.getStringArray(R.array.meters);

        countWords = 3;
        countLines = 4;

        countWordsSB = (SeekBar) findViewById(R.id.countWordsSeekBar);
        countLinesSB = (SeekBar) findViewById(R.id.countLinesSeekBar);
        countWordsT = (TextView) findViewById(R.id.countWordsText);
        countLinesT = (TextView) findViewById(R.id.countLinesText);
        metersS = (Spinner) findViewById(R.id.meter);
        dictionaryS = (Spinner) findViewById(R.id.dictionary);

        ArrayAdapter<String> meterAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, meters);
        ArrayAdapter<String> dictionaryAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,meters);


        dictionaryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        meterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dictionaryS.setAdapter(dictionaryAdapter);
        metersS.setAdapter(meterAdapter);

        dictionaryS.setSelection(0);
        metersS.setSelection(0);

        AdapterView.OnItemSelectedListener selectListner = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (view.getId()) {
                    case R.id.meter:
                        meter = position;
                        Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.dictionary:
                        dictionary = position;
                        Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        dictionaryS.setOnItemSelectedListener(selectListner);
        metersS.setOnItemSelectedListener(selectListner);

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
