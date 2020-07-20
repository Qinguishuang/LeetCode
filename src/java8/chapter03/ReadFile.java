package java8.chapter03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public ReadFile() throws IOException {
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new FileReader("data.txt"))
        ) {
            return p.process(br);
        }
    }

    String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
}

@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader p) throws IOException;
}