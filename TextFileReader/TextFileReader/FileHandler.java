import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    // Read operations from input.txt
    public List<Operation> readOperations(String inputFile) {
        List<Operation> operations = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            for (String line : lines) {
                try {
                    String[] parts = line.trim().split("\\s+");
                    if (parts.length == 3) {
                        double numOne = Double.parseDouble(parts[0]);
                        String operator = parts[1];
                        double numTwo = Double.parseDouble(parts[2]);
                        operations.add(new Operation(numOne, numTwo, operator));
                    }
                } catch (Exception e) {
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
        }
        return operations;
    }

    // Save operations into JSON format manually
    public void saveToJson(String outputFile, List<Operation> operations) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("[\n");
            for (int i = 0; i < operations.size(); i++) {
                writer.write("  " + operations.get(i).toJson());
                if (i < operations.size() - 1) writer.write(",");
                writer.write("\n");
            }
            writer.write("]");
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }

    // Read operations back from JSON file
    public List<Operation> readFromJson(String outputFile) {
        List<Operation> operations = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(outputFile));
            String content = String.join("", lines); // merge into one string
            content = content.trim();

            if (content.startsWith("[")) content = content.substring(1);
            if (content.endsWith("]")) content = content.substring(0, content.length() - 1);

            String[] objs = content.split("},");
            for (String obj : objs) {
                if (!obj.trim().endsWith("}")) obj = obj + "}";
                Operation op = Operation.fromJson(obj.trim());
                if (op != null) operations.add(op);
            }
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
        return operations;
    }
}
