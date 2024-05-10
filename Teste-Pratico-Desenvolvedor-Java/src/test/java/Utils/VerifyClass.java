package Utils;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.CheckClassAdapter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class VerifyClass {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java VerifyClass <path to .class file>");
            return;
        }

        String classFilePath = args[0];

        try (FileInputStream fis = new FileInputStream(classFilePath);
             PrintWriter writer = new PrintWriter(System.out)) {
            // Ler a classe usando o ClassReader
            ClassReader classReader = new ClassReader(fis);

            // Verificar a classe usando o CheckClassAdapter
            CheckClassAdapter.verify(classReader, true, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
