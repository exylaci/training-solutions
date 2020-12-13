package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] bytes, Path path) {
        try {
            OutputStream writer = new BufferedOutputStream(Files.newOutputStream(path.resolve("image.png")));
            for (byte[] one : bytes) {
                writer.write(one);
            }
            writer.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write image.png file!", e);
        }
    }
}
//Hozz létre egy ImageAssembler osztályt, melyben a
// makeImageFile() metódus a paraméterben a kép részleteit byte[][]-ként kapja meg,
// majd a részeket kiírja egyetlen
//  image.png nevű fájlba a
//  Path-ként kapott mappába!