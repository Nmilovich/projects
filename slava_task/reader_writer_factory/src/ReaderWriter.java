import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ReaderWriter  {

     public void writerPerson(List<String> recordingList, File file) {

        try (FileWriter writer = new FileWriter(file)) {
            for (String person : recordingList) {
                writer.write(person + System.getProperty("line.separator"));
            }
            System.out.println("recording completed...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readerPerson(List<Person> listPerson, File file){

        try {
            List<String> helperList = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            for (String person : helperList) {

                String[] personSplit = person.split(" ");
                if (personSplit.length > 1) listPerson.add(new Person(personSplit[0], personSplit[1]));

            }
            System.out.println("All person are object Person");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
