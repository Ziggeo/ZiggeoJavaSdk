package com.ziggeo.demos;

import com.ziggeo.Ziggeo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

class ImageDownload {

    public static void main(String[] args) throws Exception {
        Ziggeo ziggeo = new Ziggeo(args[0], args[1], "");
        InputStream fileStream = ziggeo.videos().downloadVideo(args[2]);
        File targetFile = new File("image.png");
        try (FileOutputStream outputStream = new FileOutputStream(targetFile)) {
            int read;
            byte[] bytes = new byte[1024];
            while ((read = fileStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }
}

