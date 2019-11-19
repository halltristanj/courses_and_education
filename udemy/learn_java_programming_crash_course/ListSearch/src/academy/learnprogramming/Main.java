package academy.learnprogramming;

import java.util.List;

public class Main {

    private static List<String> matches = List.of(
            "life",
            "i need",
            "why don't",
            "i can",
            "are you",
            "what",
            "because",
            "sorry"
    );

    private static List<String> responses = List.of(
            "Life? Don't talk to me about life.",
            "Why do you need %1?",
            "Do you really think I don't %1?",
            "How do you know you can't %1?",
            "Why does it matter whether I am %1?",
            "Why do you ask?",
            "Is that the real reason?",
            "There are many times when no apology is needed.",
            "Please tell me more."
    );

    public static void main(String[] args) {

        //                  0123456789
        String userInput = "I think I need to learn Java";
        String output = "";

        for (int index = 0; index < matches.size(); index++) {

            String match = matches.get(index);
            int position = userInput.toLowerCase().indexOf(match);
            if (position > -1) {
                // found a match
                output = responses.get(index);
                break;
            }
        }

        // If there wasn't a match, use the last item in the responses list.
        if (output.isEmpty()) {
            output = responses.get(responses.size() - 1);
        }

        System.out.println(output);
    }
}
