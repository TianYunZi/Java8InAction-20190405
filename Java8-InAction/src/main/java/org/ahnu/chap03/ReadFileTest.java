package org.ahnu.chap03;

import org.ahnu.interfaces.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileTest {

    public static void main(String[] args) throws IOException {
        String readLine = processFile(BufferedReader::readLine);
        System.out.println(readLine);
    }

    private static <T> T processFile(BufferedReaderProcessor<BufferedReader, T> processor) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\zxyse\\Documents\\Java\\Practise\\Java8InAction-20190405\\Java8-InAction\\src\\main\\resources\\data.txt"))) {
            return processor.process(reader);
        }
    }
}
