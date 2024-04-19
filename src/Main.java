// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        RedBlackTree dict = new RedBlackTree();
        dict.insert("a");
        System.out.println("root is " + dict.getRoot().getData());
        dict.insert("b");
        System.out.println("root is " + dict.getRoot().getData());
        dict.insert("c");
        System.out.println("root is " + dict.getRoot().getData());
        System.out.println("black height is " + dict.getBlackHeight());
        System.out.println("height is " + dict.getHeight());
        System.out.println("===============================================================");
        dict.insert("v");
        System.out.println("root is " + dict.getRoot().getData());
        System.out.println("black height is " + dict.getBlackHeight());
        dict.insert("w");
        dict.insert("x");
        dict.insert("y");
        dict.insert("z");
        System.out.println("root is " + dict.getRoot().getData());
        System.out.println("black height is " + dict.getBlackHeight());



//        dict.printAll();
//        if(dict.search("a")){
//            System.out.println(dict.getNode("a").getData());
//        }
    }
}
