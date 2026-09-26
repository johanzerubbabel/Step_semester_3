import java.util.*;
import java.util.regex.*;

public class ExamGrader {
    abstract static class Question {
        String text, correctAnswer, studentAnswer;
        int points;
        Question(String text, String correctAnswer, String studentAnswer, int points) {
            this.text = text;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }
        abstract double gradeAnswer();
        abstract String getType();
    }

    static class McqQuestion extends Question {
        McqQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
        double gradeAnswer() { return studentAnswer.equals(correctAnswer) ? points : 0; }
        String getType() { return "MCQ"; }
    }

    static class TfQuestion extends Question {
        TfQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
        double gradeAnswer() { return studentAnswer.equals(correctAnswer) ? points : 0; }
        String getType() { return "TF"; }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
        double gradeAnswer() {
            String[] keywords = correctAnswer.toLowerCase().split(",\\s*");
            String studentLower = studentAnswer.toLowerCase();
            int matchCount = 0;
            for (String kw : keywords) {
                if (studentLower.contains(kw.trim())) matchCount++;
            }
            if (matchCount >= 2) return points * 0.75;
            else if (matchCount == 1) return points * 0.5;
            else return 0;
        }
        String getType() { return "ESSAY"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Question> questions = new ArrayList<>();
        Pattern quotePattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String type = line.substring(0, line.indexOf('"')).trim();

            Matcher m = quotePattern.matcher(line);
            List<String> quoted = new ArrayList<>();
            int lastEnd = 0;
            while (m.find()) {
                quoted.add(m.group(1));
                lastEnd = m.end();
            }
            String text = quoted.get(0);
            String correctAnswer = quoted.get(1);
            String studentAnswer = quoted.get(2);
            int points = Integer.parseInt(line.substring(lastEnd).trim());

            Question q;
            switch (type) {
                case "MCQ": q = new McqQuestion(text, correctAnswer, studentAnswer, points); break;
                case "TF": q = new TfQuestion(text, correctAnswer, studentAnswer, points); break;
                default: q = new EssayQuestion(text, correctAnswer, studentAnswer, points);
            }
            questions.add(q);
        }

        for (Question q : questions) {
            double score = q.gradeAnswer();
            total += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
