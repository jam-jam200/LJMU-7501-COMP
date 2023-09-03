import java.util.ArrayList;
import java.util.Random;

public class RandomPhraseGenerator {
    public static void main(String[] args) {
        //defining the ArrayLists for the subjects, verbs, and objects
        ArrayList<String> subjects = new ArrayList<>();
        ArrayList<String> verbs = new ArrayList<>();
        ArrayList<String> objects = new ArrayList<>();

        // Add words to the subject, verb, and object lists
        subjects.add("The cat");
        subjects.add("A dog");
        subjects.add("The car");
        subjects.add("A bird");
        subjects.add("My friend");

        verbs.add("chased");
        verbs.add("ate");
        verbs.add("jumped over");
        verbs.add("saw");
        verbs.add("drove");

        objects.add("the mouse");
        objects.add("a bone");
        objects.add("the wall");
        objects.add("a worm");
        objects.add("the park");

        // Create a random number generator
        Random random = new Random();

        // Generate random indices for each part of the sentence
        int subjectIndex = random.nextInt(subjects.size()); // Random subject index
        int verbIndex = random.nextInt(verbs.size());       // Random verb index
        int objectIndex = random.nextInt(objects.size());   // Random object index

        // Retrieve the random words for the sentence
        String subject = subjects.get(subjectIndex); // Get random subject
        String verb = verbs.get(verbIndex);           // Get random verb
        String object = objects.get(objectIndex);     // Get random object

        // Build and print the random sentence
        String sentence = subject + " " + verb + " " + object + "."; // Construct sentence
        System.out.println("Random Sentence: " + sentence);          // Print the sentence
    }
}
