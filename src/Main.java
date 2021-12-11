import java.io.*;

public class Main {
    public static void main(String[] args) {
        File fileToBeModified = new File("C:/Users/acer/Desktop/test.txt");
        String oldContent = "";
        String newContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        String neededWord = "<question>";
        int i = 1;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();

            while (line != null) {
                if (line.startsWith(neededWord)) {
                    oldContent = oldContent + line.replace(neededWord, i + ". ") + System.lineSeparator();
                    i++;
                } else {
                    oldContent = oldContent + line + System.lineSeparator();
                }
                line = reader.readLine();
            }
            newContent = oldContent;
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
