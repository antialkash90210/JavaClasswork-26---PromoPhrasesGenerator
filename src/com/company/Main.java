package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        PhraseList callToActionPhrases = new PhraseList("callToActionPhrases.txt");
        PhraseList itemPhrases = new PhraseList("itemPhrases.txt");
        PhraseList brandPhrases = new PhraseList("brandPhrases.txt");
        PhraseList prepositionPhrases = new PhraseList("prepositionPhrases.txt");
        PhraseList placePhrases = new PhraseList("placePhrases.txt");

        PromoPhrasesGenerator promoPhrasesGenerator = new PromoPhrasesGenerator(callToActionPhrases, itemPhrases, brandPhrases, prepositionPhrases, placePhrases);

        MenuManager menuManager = new MenuManager(promoPhrasesGenerator);
        menuManager.execute();
    }
}