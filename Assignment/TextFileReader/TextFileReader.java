import java.util.List;

public class TextFileReader {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.json";

        FileHandler fileHandler = new FileHandler();

        List<Operation> operations = fileHandler.readOperations(inputFile);

        fileHandler.saveToJson(outputFile, operations);

        List<Operation> loadedOperations = fileHandler.readFromJson(outputFile);

        for (Operation op : loadedOperations) {
            System.out.println(op);
        }
    }
}
