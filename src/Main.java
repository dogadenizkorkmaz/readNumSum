import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/data.txt"; //file path
        String[] data = {"5", "10", "20", "12", "33"}; // Data to file

        try {
            // Create file
            File file = new File(filePath);

            // Use FileWriter,write to file
            FileWriter writer = new FileWriter(file);

            // Write the data
            for (String datum : data) {
                writer.write(datum + "\n"); // Write each data on a new line
            }

            // Close the writer
            writer.close();

            System.out.println("File created: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }

        int total = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line);
                total += number;
            }
            System.out.println("Total of the numbers read from the file: " + total);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
