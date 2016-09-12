package section5;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    private final FileWriter writer;
    public FileWriterExample(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }
    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }
    //クライアントに解放処理を明示的に実施するよう強制してしまう
    public void close() throws IOException {
        writer.close();
    }
    //GC実行時にしか呼ばれない = メモリに余裕があると呼ばれない解放処理
    public void finalize() throws IOException {
        writer.close();
    }
}
