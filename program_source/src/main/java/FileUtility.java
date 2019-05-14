import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtility {

    public static String[] toStringArray(String path, String delimiterPattern) throws IOException {
        return Files.lines(Paths.get(path), Charset.forName("ISO-8859-1"))
                .flatMap(line -> Stream.of(line.split(delimiterPattern)))
                .filter(word -> !word.isEmpty())
                .toArray(String[]::new);
    }

}