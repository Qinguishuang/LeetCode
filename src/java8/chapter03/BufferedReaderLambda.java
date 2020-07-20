package java8.chapter03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderLambda {

    public static void main(String[] args) throws IOException {
        String result = processFile((BufferedReader br) -> br.readLine());
        String lines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }


    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("a.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReader br) throws IOException {
        return br.readLine();
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("a.txt"))) {
            return p.process(br);
        }
    }

}

// @FunctionalInterface
// interface BufferedReaderProcessor {
//     String process(BufferedReader br) throws IOException;
// }