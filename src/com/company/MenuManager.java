package com.company;

public class MenuManager {
    private PromoPhrasesGenerator promoPhrasesGenerator = null;

    public MenuManager(PromoPhrasesGenerator promoPhrasesGenerator) {
        this.promoPhrasesGenerator = promoPhrasesGenerator;
    }

    private void workWithPhrasesList(PhraseList phraseList) throws Exception {
        int action = -1;
        boolean isRun = true;

        while (isRun) {
            for (int i = 0; i < phraseList.getLength(); i++) {
                String message = String.format("        %d - %s", i, phraseList.getByIndex(i));
                ConsoleHelper.PrintMessage(message);
            }
            ConsoleHelper.PrintMessage("        =====");

            ConsoleHelper.PrintMessage("        Меню словаря:");
            ConsoleHelper.PrintMessage("        1. Добавить новое слово в конец словаря");
            ConsoleHelper.PrintMessage("        2. Удалить слово по индексу");
            ConsoleHelper.PrintMessage("        3. Сохранить словарь");
            ConsoleHelper.PrintMessage("        4. Перезагрузить словарь из файла");
            ConsoleHelper.PrintMessage("        0. Выход");
            action = ConsoleHelper.InputInt("        Введите номер пункта меню: ", 0, 4);

            switch (action) {
                case 1: {
                    String word = ConsoleHelper.InputString("        Введите слово: ");
                    phraseList.addToEnd(word);
                }
                break;
                case 2: {
                    int index = ConsoleHelper.InputInt("        Введите индекс для удаления: ", 0, phraseList.getLength() - 1);
                    phraseList.deleteByIndex(index);
                }
                break;
                case 3: {
                    phraseList.save();
                }
                break;
                case 4: {
                    phraseList.load();
                }
                break;
                case 0: {
                    isRun = false;
                }
                break;
            }

        }
    }

    public void execute() throws Exception {
        int action = -1;
        boolean isRun = true;

        while (isRun) {

            ConsoleHelper.PrintMessage("Меню:");
            ConsoleHelper.PrintMessage("1. Вывести новую фразу");
            ConsoleHelper.PrintMessage("2. Работа со словарями");
            ConsoleHelper.PrintMessage("0. Выход");

            action = ConsoleHelper.InputInt("Введите номер пункта меню: ", 0, 2);

            switch (action) {
                case 1: {
                    String phrase = promoPhrasesGenerator.getRandomPhrase();
                    ConsoleHelper.PrintMessage(phrase);
                }
                break;
                case 2: {
                    int innerAction = -1;
                    ConsoleHelper.PrintMessage("    Меню словарей:");
                    ConsoleHelper.PrintMessage("    1. Словарь фраз призыва к действию");
                    ConsoleHelper.PrintMessage("    2. Словарь фраз сущностей");
                    //todo add other phrases list
                    ConsoleHelper.PrintMessage("    0. Выход");

                    innerAction = ConsoleHelper.InputInt("    Введите номер пункта меню: ", 0, 2);

                    switch (innerAction) {
                        case 1: {
                            PhraseList callToActionPhrases = promoPhrasesGenerator.getCallToActionPhrases();
                            workWithPhrasesList(callToActionPhrases);
                        }
                        break;

                        case 2: {
                            PhraseList itemPhrases = promoPhrasesGenerator.getItemPhrases();
                            workWithPhrasesList(itemPhrases);
                        }
                        break;
                    }
                }
                break;
                case 0: {
                    isRun = false;
                }
                break;
            }
        }
    }
}