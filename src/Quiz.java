/* Name: Jason Cameron
   Date: 2024-07-08
   Purpose of program: To create a quiz program that asks the user a series of questions and provides feedback on their answers.
 */

public class Summative {
    // Constant for the total number of questions
    private static final int NUM_QUESTIONS = 6;

    // Array to hold the Question objects
    static Question[] questions = new Question[NUM_QUESTIONS];

    // Method to populate the quiz questions
    private static void addQuestions() {
        questions[0] = new Question("What is the capital of Canada?", "Ottawa", new String[]{"Toronto", "Ottawa", "Vancouver", "Montreal"});
        questions[1] = new Question("What is the capital of France?", "Paris", new String[]{"Lyon", "Paris", "Marseille", "Nice"});
        questions[2] = new Question("What is the capital of Japan?", "Tokyo", new String[]{"Osaka", "Kyoto", "Yokohama", "Tokyo"});
        questions[3] = new Question("What is the capital of the United States?", "Washington D.C.", new String[]{"New York", "Los Angeles", "Chicago", "Washington D.C."});
        questions[4] = new Question("What is the course code for this class?", "ICS3U", new String[]{"ICS3U", "ICS4U", "ICS3C", "ICS4C"});
        questions[5] = new Question("What is the creator of this quiz's name?", "Jason", new String[]{"John", "Jason", "James", "Jack"});
    }

    public static void main(String[] args) {
        addQuestions();
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.question); // Display the question

            // Display the answer options dynamically
            for (int i = 0; i < question.options.length; i++) {
                System.out.println(i + ": " + question.options[i]);
            }

            System.out.print("Enter your answer: ");
            String answer = System.console().readLine().strip();

            // Check if the answer is correct (either the string itself or the corresponding option index)
            if (answer.equalsIgnoreCase(question.answer) ||
                    isCorrectIndex(answer, question)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is " + question.answer);
            }
        }

        // Calculate and display the final score
        float finalScore = (float)  Math.round(((float) score / NUM_QUESTIONS) * 1000) / 10;
        System.out.println("You got " + score + " out of " + NUM_QUESTIONS + " questions correct. Your score is " + finalScore + "%");
    }

    // Helper function to check if the answer is a valid index and correct
    private static boolean isCorrectIndex(String answer, Question question) {
        try {
            int answerIndex = Integer.parseInt(answer);
            // Check if the index is within bounds and the corresponding option is correct
            return (answerIndex >= 0 && answerIndex < question.options.length &&
                    question.options[answerIndex].equalsIgnoreCase(question.answer));
        } catch (NumberFormatException e) {
            return false; // Not a valid number
        }
    }
}

// Class to represent a quiz question
class Question {
    String question;      // The question text
    String answer;        // The correct answer
    String[] options;     // Array of answer choices

    // Constructor
    public Question(String question, String answer, String[] options) {
        this.question = question;
        this.answer = answer;
        this.options = options;
    }
}
