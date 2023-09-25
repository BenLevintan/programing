import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

public record PersonId(String name, String idNumber) {
    public PersonId {
        if (!isValidIdNumber(idNumber)) {
            throw new RuntimeException("Invalid ID number: " + idNumber + " for person: " + name);
        }
    }

    private boolean isValidIdNumber(String idNumber) {
        try {
            int number = Integer.parseInt(idNumber);
            return number >= 1000 && number <= 9999;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid ID number: " + idNumber + " for person: " + name);
        }
    }

    public void readIdDataFromFile (Path fileName){
        PersonId list[] = new PersonId[10];
    }
}
