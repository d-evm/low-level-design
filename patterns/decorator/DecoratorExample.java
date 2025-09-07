import java.io.*;

public class DecoratorExample {
    public static void main(String[] args) throws IOException {
        String data = "Hello World!";

        // Base component: FileWriter (writes text to a file)
        Writer fileWriter = new FileWriter("output.txt");

        // Decorator: BufferedWriter (adds buffering)
        Writer bufferedWriter = new BufferedWriter(fileWriter);

        // Decorator: PrintWriter (adds convenience methods like println)
        PrintWriter writer = new PrintWriter(bufferedWriter);

        // Now write plain text
        writer.println(data);
        writer.println(10.0);

        writer.close();
        System.out.println("Plain text written in output.txt");
    }
}
