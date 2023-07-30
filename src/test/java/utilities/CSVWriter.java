package utilities;
import pojos.UserCreationPojo;
import pojos.UserResponsePojo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CSVWriter {
    public static void writeUserToCSV(UserResponsePojo user, String csvFileName) throws IOException {
        File csvFile = new File(csvFileName + ".csv");
        FileWriter fileWriter = new FileWriter(csvFile, true); // Append mode to add new content to the existing file

        if (!csvFile.exists() || csvFile.length() == 0) {
            fileWriter.write("\"id\",\"name\",\"email\",\"gender\",\"status\"\n");
        }

        StringBuilder line = new StringBuilder();
        line.append("\"").append(user.getId().replaceAll("\"", "\"\"")).append("\",");
        line.append("\"").append(user.getName().replaceAll("\"", "\"\"")).append("\",");
        line.append("\"").append(user.getEmail().replaceAll("\"", "\"\"")).append("\",");
        line.append("\"").append(user.getGender().replaceAll("\"", "\"\"")).append("\",");
        line.append("\"").append(user.getStatus().replaceAll("\"", "\"\"")).append("\"\n");

        fileWriter.write(line.toString());

        fileWriter.close();
        System.out.println("User written to " + csvFileName + ".csv");

    }

    public static void main(String[] args) throws IOException {
        UserResponsePojo user1 = new UserResponsePojo("1234","John Doe", "john.doe@example.com", "male", "active");
        UserResponsePojo user2 = new UserResponsePojo("1234","Jane Smith", "jane.smith@example.com", "female", "active");

        writeUserToCSV(user1, "users");
        writeUserToCSV(user2, "users");
    }
}
