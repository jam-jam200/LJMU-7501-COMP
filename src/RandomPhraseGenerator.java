import java.util.ArrayList;
import java.util.Random;

public class RandomPhraseGenerator {
    public static void main(String[] args) {
        //defining the ArrayLists for the subjects, verbs, and objects
        ArrayList<String> subjects = new ArrayList<>();
        ArrayList<String> verbs = new ArrayList<>();
        ArrayList<String> objects = new ArrayList<>();

        //adding words to the subject, verb, and object list
        subjects.add("The boy");
        subjects.add("A Man");
        subjects.add("The cat");
        subjects.add("A bird");
        subjects.add("My Mummy");

        verbs.add("sang");
        verbs.add("chased");
        verbs.add("ate");
        verbs.add("fell");
        verbs.add("flew over");

        objects.add("the mouse");
        objects.add("a bone");
        objects.add("the wall");
        objects.add("a hymn");
        objects.add("the park");

        //creating a random number generator
        Random random = new Random();

        //generating random indices for each part of the sentence
        int subjectIndex = random.nextInt(subjects.size()); //random subject index
        int verbIndex = random.nextInt(verbs.size());       //random verb index
        int objectIndex = random.nextInt(objects.size());   //random object index

        //retrieving the random words for the phrase/sentence
        String subject = subjects.get(subjectIndex); //get random subject
        String verb = verbs.get(verbIndex);           //get random verb
        String object = objects.get(objectIndex);     //get random object

        //building and printing the random phrase/sentence
        String sentence = subject + " " + verb + " " + object + "."; //constructing sentence
        System.out.println("Random Sentence: " + sentence);          //printing the sentence
    }
}
