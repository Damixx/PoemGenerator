package com.vocvark.poemgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar countWordsSB;
    SeekBar countLinesSB;

    TextView countWordsT;
    TextView countLinesT;

    int countWords;
    int countLines;

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
