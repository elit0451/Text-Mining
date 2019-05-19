import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileUtility {

    public static String[] toStringArray(String path, String delimiterPattern) throws IOException {
        return Files.lines(Paths.get(path), Charset.forName("ISO-8859-1"))
                .flatMap(line -> Stream.of(line.split(delimiterPattern)))
                .filter(word -> !word.isEmpty())
                .toArray(String[]::new);
    }

    public static void exportToCSV(String path, ArrayList<WordCount> words) throws IOException {
        String content = "Word, Count";
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        for (WordCount word: words){
            content += "\n" + word.word + "," + word.count;
        }

        writer.write(content);
        writer.close();
    }
}