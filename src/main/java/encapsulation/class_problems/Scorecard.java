public class Scorecard {
    private boolean[] results;
    private int count;
    private final int totalQuestions;

    Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.count = 0;
    }

    void recordAnswer(boolean correct) {
        if (count < totalQuestions) {
            results[count] = correct;
            count++;
        }
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
    }
}
