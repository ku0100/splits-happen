import java.util.ArrayList;
import java.util.List;

class BowlingScoreUtil {

    public static int generateScore(String scoreLine) {

        List<String> scoreList = new ArrayList<>();
        int bowlingScore = 0;

        for (int i=0; i < scoreLine.length(); i++) {
            // iterate over all scores and add to generated list,
            // substitute 10 and 0 for 'X' and '-', respectively
            // leave spare values alone for now
            char c = scoreLine.charAt(i);
            switch (c) {
                case 'X':
                    scoreList.add("10");
                    break;
                case '/':
                    scoreList.add("/");
                    break;
                case '-':
                    scoreList.add("0");
                    break;
                default:
                    scoreList.add(Character.toString(c));
                    break;
            }
        }

        for (int j=0; j < scoreList.size(); j++) {
            if (j >= (scoreList.size() - 3)) {
                // for scoring the special 10th frame
                if (scoreList.get(j).equals("/")) {
                    bowlingScore = bowlingScore + (10 - Integer.parseInt(scoreList.get(j + 1)));
                } else {
                    bowlingScore = bowlingScore + Integer.parseInt(scoreList.get(j));
                }
            } else if (scoreList.get(j).equals("10")) {
                // calculate value of a strike in a particular frame (excluding frame 10)
                bowlingScore = bowlingScore + 10 + Integer.parseInt(scoreList.get(j + 1));
                if (scoreList.get(j + 2).equals("/")) {
                    bowlingScore = bowlingScore + (10 - Integer.parseInt(scoreList.get(j + 1)));
                } else {
                    bowlingScore = bowlingScore + Integer.parseInt(scoreList.get(j + 2));
                }
            } else if (scoreList.get(j).equals("/")) {
                // calculate value of a spare in a particular frame (excluding frame 10)
                bowlingScore = bowlingScore + (10 - Integer.parseInt(scoreList.get(j - 1))
                        + Integer.parseInt(scoreList.get(j + 1)));
            } else {
                bowlingScore = bowlingScore + Integer.parseInt(scoreList.get(j));
            }
        }
        return bowlingScore;
    }
}
