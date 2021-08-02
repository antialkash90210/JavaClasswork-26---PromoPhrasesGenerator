package com.company;

import java.util.Random;

public class PromoPhrasesGenerator {
    private Random random = null;

    private PhraseList callToActionPhrases = null;
    private PhraseList itemPhrases = null;
    private PhraseList brandPhrases = null;
    private PhraseList prepositionPhrases = null;
    private PhraseList placePhrases = null;

    public PromoPhrasesGenerator(PhraseList callToActionPhrases, PhraseList itemPhrases, PhraseList brandPhrases, PhraseList prepositionPhrases, PhraseList placePhrases) {
        random = new Random();

        this.callToActionPhrases = callToActionPhrases;
        this.itemPhrases = itemPhrases;
        this.brandPhrases = brandPhrases;
        this.prepositionPhrases = prepositionPhrases;
        this.placePhrases = placePhrases;
    }

    public String getRandomPhrase() throws Exception{
        int callToActionIndex = random.nextInt(callToActionPhrases.getLength());
        String callToAction = callToActionPhrases.getByIndex(callToActionIndex);

        int itemIndex = random.nextInt(itemPhrases.getLength());
        String item = itemPhrases.getByIndex(itemIndex);

        int brandIndex = random.nextInt(brandPhrases.getLength());
        String brand = brandPhrases.getByIndex(brandIndex);

        int prepositionIndex = random.nextInt(prepositionPhrases.getLength());
        String preposition = prepositionPhrases.getByIndex(prepositionIndex);

        int placeIndex = random.nextInt(placePhrases.getLength());
        String place = placePhrases.getByIndex(placeIndex);

        return String.format("%s %s %s %s %s", callToAction, item, brand, preposition, place);
    }

    public PhraseList getCallToActionPhrases() {
        return callToActionPhrases;
    }

    public PhraseList getItemPhrases() {
        return itemPhrases;
    }

    //todo add other getters
}