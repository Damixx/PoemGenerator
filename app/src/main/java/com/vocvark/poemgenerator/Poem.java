package com.vocvark.poemgenerator;

public class Poem {
    private int lineCount;
    private int wordsInLine;
    private String meter;
    private String[] words;

    private String poem;

    public Poem(int lineCount, int wordsInLine, int meter, int dictionary) {
        this.lineCount = lineCount;
        this.wordsInLine = wordsInLine;
        //this.meter = meter;
        //this.words = words;
    }

    public void GeneratePoem() {

    }

    public String Poem() { return poem; }
}
