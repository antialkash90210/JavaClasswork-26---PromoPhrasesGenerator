package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class PhraseList {
    private String[] phrases = null;
    private String fileName = null;

    public PhraseList() {
        phrases = new String[0];
    }

    public PhraseList(String fileName) throws Exception {
        this.fileName = fileName;
        load();
    }

    public void clear() {
        phrases = new String[0];
    }

    public String getByIndex(int index) throws Exception {
        if (index < 0 || index > phrases.length - 1) {
            throw new Exception("Выход за границы списка фраз");
        }

        return phrases[index];
    }

    public void setByIndex(int index, String value) throws Exception {
        if (index < 0 || index > phrases.length - 1) {
            throw new Exception("Выход за границы списка фраз");
        }

        phrases[index] = value;
    }

    public int getLength() {
        return phrases.length;
    }

    public void addToEnd(String value) {
        String[] tempPhrases = new String[phrases.length + 1];

        for (int i = 0; i < phrases.length; i++) {
            tempPhrases[i] = phrases[i];
        }

        tempPhrases[tempPhrases.length - 1] = value;

        phrases = tempPhrases;
    }

    public void deleteByIndex(int index) throws Exception {
        if (index < 0 || index > phrases.length - 1) {
            throw new Exception("Выход за границы списка фраз");
        }

        String[] tempPhrases = new String[phrases.length - 1];

        for (int i = 0; i < index; i++) {
            tempPhrases[i] = phrases[i];
        }

        for (int i = index + 1; i < phrases.length; i++) {
            tempPhrases[i - 1] = phrases[i];
        }

        phrases = tempPhrases;
    }

    public void addRange(String[] phrases) {
        for (int i = 0; i < phrases.length; i++) {
            addToEnd(phrases[i]);
        }
    }

    public void load() throws Exception {
        clear();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            String currentValue = bufferedReader.readLine();
            addToEnd(currentValue);
        }

        bufferedReader.close();
    }

    public void save() throws Exception {
        if (fileName == null) {
            throw new Exception("file name was not set");
        }

        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(phrases.length+"\n");

        for (int i = 0; i < phrases.length; i++) {
            bufferedWriter.write(phrases[i]+"\n");
        }

        bufferedWriter.close();


    }

}