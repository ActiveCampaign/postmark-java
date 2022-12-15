package com.postmarkapp.postmark.client.data.model;

import org.apache.tika.Tika;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDetails {
    public static String getFileName(String path) {
        return new File(path).getName();
    }
    public static byte[] getFileContent(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }
    public static String getFileContentType(String path) throws IOException {
        return new Tika().detect(new File(path));
    }
}
