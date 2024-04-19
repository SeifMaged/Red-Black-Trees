import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Dictionary {
    private RedBlackTree dict;
    private String fileName;

    public Dictionary() {
        this.dict = new RedBlackTree();
        fileName = "dictionary.txt";
    }

    public void loadData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String word;
            while ((word = reader.readLine()) != null) {
                dict.insert(word);
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
    }

    public void insertWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new word : ");
        String key = scanner.nextLine().strip();
        if (dict.search(key) != null) {
            System.out.println("ERROR: word already exists in the dictionary");
        } else {
            dict.insert(key);
            printHeights();
        }
    }

    public void lookUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("does dictionary has ");
        String key = scanner.nextLine().strip();
        if (dict.search(key) != null) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private void printHeights() {
        System.out.printf("| %-20s | %-8s|%n", "Tree Size", dict.getSize());
        System.out.printf("| %-20s | %-8s|%n", "Tree Black Height", dict.getBlackHeight());
        System.out.printf("| %-20s | %-8s|%n", "Tree Height", dict.getHeight());
    }
}
