package org.example;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {
        Files.createDirectories(Path.of("Dir0/Dir1/Dir11/Dir111"));
        Files.createDirectories(Path.of("Dir0/Dir2"));
        Files.createDirectories(Path.of("Dir0/Dir3/Dir31"));
        Files.createDirectories(Path.of("Dir0/Dir3/Dir32"));

        Path file1Path = Path.of("Dir0/Dir1/Dir11/File1.txt");
        Files.writeString(file1Path, "James Gosling, Mike Sheridan i Patrick Naughton zainicjowali projekt języka Java w czerwcu 1991 r.[6] Java została pierwotnie zaprojektowana dla telewizji interaktywnej, ale była wówczas zbyt zaawansowana dla branży cyfrowej telewizji kablowej[7]. Gosling zaprojektował Javę ze składnią w stylu C/C++, którą programiści systemów i aplikacji mogliby uznać za znajomą.\n" +
                "\n" +
                "Firma Sun Microsystems wydała pierwszą publiczną implementację jako Java 1.0 w 1996 roku[8]. Zapewniał funkcjonalność WORA (ang. Write Once, Run Anywhere), zapewniającą darmowe środowisko uruchomieniowe na popularnych platformach. Dość bezpieczny i wyposażony w konfigurowalne zabezpieczenia pozwalał na ograniczenia dostępu do sieci i plików. Popularne przeglądarki internetowe wkrótce włączyły możliwość uruchamiania apletów Java na stronach internetowych, a Java szybko stała się popularna. Kompilator Java 1.0 został ponownie napisany w Javie przez Arthura van Hoffa w celu ścisłej zgodności ze specyfikacją języka Java 1.0.\n" +
                "\n" +
                "Wraz z pojawieniem się Java 2 (wydanej początkowo jako J2SE 1.2 w grudniu 1998 - 1999), nowe wersje miały wiele konfiguracji zbudowanych dla różnych typów platform. J2EE zawierała technologie i interfejsy API dla aplikacji korporacyjnych, które zwykle działają w środowiskach serwerowych, natomiast J2ME zawierało interfejsy API zoptymalizowane pod kątem aplikacji mobilnych. Wersja desktopowa została przemianowana na J2SE. W 2006 w celach marketingowych firma Sun zmieniła nazwy nowych wersji J2 na odpowiednio Java EE, Java ME i Java SE.\n" +
                "\n");

        Path file1CopyPath = Path.of("Dir0/Dir3/Dir32/File1.txt");
        Files.copy(file1Path, file1CopyPath);

        Path file2Path = Path.of("Dir0/Dir1/Dir11/File2.txt");
        String file1Content = Files.readString(file1Path);
        Files.writeString(file2Path, file1Content.replace('a', '@'));

        Path file3Path = Path.of("Dir0/Dir1/Dir11/Dir111/File3.txt");
        String file1Reversed = new StringBuilder(file1Content).reverse().toString();
        Files.writeString(file3Path, file1Reversed);

        Path file4Path = Path.of("Dir0/Dir2/File4.txt");
        Files.writeString(file4Path, file1Content);

        try (SeekableByteChannel sbc = Files.newByteChannel(file4Path, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1);
            for (int i = 0; i < 200; i += 2) {
                buffer.clear();
                buffer.put((byte) ' ');
                buffer.flip();
                sbc.position(i);
                sbc.write(buffer);
            }
        }

        try (Stream<Path> paths = Files.walk(Path.of("Dir0"))) {
            List<String> files = paths.filter(Files::isRegularFile)
                    .map(p -> p.toString() + " - " + p.toFile().length() + " bajtow")
                    .collect(Collectors.toList());
            files.forEach(System.out::println);
        }


    }
}