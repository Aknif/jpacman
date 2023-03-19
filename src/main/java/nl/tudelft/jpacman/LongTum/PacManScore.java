package nl.tudelft.jpacman.LongTum;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PacManScore {
    private List<Score> scores;

    public PacManScore() {
        // Initialize scores list
        scores = new ArrayList<>();

        // Add some scores to the list
        scores.add(new Score("Jone", 100));
        scores.add(new Score("Jane", 200));

        // Save scores to JSON file
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("scores.json")) {
            gson.toJson(scores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PacManScore();
    }

    public static class Score {
        private String name;
        private int score;

        public Score(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
}
