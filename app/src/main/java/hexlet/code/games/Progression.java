package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.List;

import static hexlet.code.Engine.COUNT_QUEST;

public final class Progression {

    public static final int MIN_START_CHAIN = 5;
    public static final int MAX_START_CHAIN = 20;
    public static final int MIN_STEP_CHAIN = 2;
    public static final int MAX_STEP_CHAIN = 8;
    public static final int MIN_COUNT_ELEMENTS = 5;
    public static final int MAX_COUNT_ELEMENTS = 12;
    private static final String RULE_GAME = "What number is missing in the progression?";

    public static void gameProgression() {

        String[][] gameQuestions = new String[COUNT_QUEST][2];

        for (int i = 0; i < COUNT_QUEST; i++) {

            int startChain = Utils.generateNumber(MIN_START_CHAIN, MAX_START_CHAIN);
            int stepChain = Utils.generateNumber(MIN_STEP_CHAIN, MAX_STEP_CHAIN);
            int countElements = Utils.generateNumber(MIN_COUNT_ELEMENTS, MAX_COUNT_ELEMENTS);

            String[] chain = generateProgression(startChain, stepChain, countElements);
            int indexQuest = Utils.generateNumber(0, chain.length - 1);
            gameQuestions[i][1] = chain[indexQuest];
            chain[indexQuest] = "..";
            gameQuestions[i][0] = String.join(" ", List.of(chain));
        }

        Engine.run(RULE_GAME, gameQuestions);
    }

    private static String[] generateProgression(int startChain, int stepChain, int countElements) {

        String[] chain = new String[countElements];

        chain[0] = String.valueOf(startChain);
        for (int i = 1; i < chain.length; i++) {
            chain[i] = String.valueOf(Integer.parseInt(chain[i - 1]) + stepChain);
        }

        return chain;
    }
}
