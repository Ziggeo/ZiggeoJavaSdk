package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/*
	This script will show you how you can download the video

	Parameters you need to pass:
	1. appToken
	2. privateKey
	3. videoToken
*/
public class VideosDownloadVideo {

	public static void main(String[] args) throws Exception {

		String appToken = args[0];
		String privateKey = args[1];
		String videoToken = args[2];

		Ziggeo ziggeo = new Ziggeo(appToken, privateKey, "");
		InputStream fileStream = ziggeo.videos().downloadVideo(videoToken);

		File targetFile = new File("video.mp4");
		try (FileOutputStream outputStream = new FileOutputStream(targetFile)) {
			int read;
			byte[] bytes = new byte[1024];
			while ((read = fileStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		}
	}
}