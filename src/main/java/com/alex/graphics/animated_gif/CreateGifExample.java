package com.alex.graphics.animated_gif;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;


//https://memorynotfound.com/generate-gif-image-java-delay-infinite-loop-example/

public class CreateGifExample {
	public static void main(String[] args) throws Exception {
		BufferedImage first = ImageIO.read(new File("/tmp/duke.jpg"));
		ImageOutputStream output = new FileImageOutputStream(new File("example.gif"));

		GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 250, true);
		writer.writeToSequence(first);

		File[] images = new File[] {
				new File("/tmp/duke-image-watermarked.jpg"),
				new File("/tmp/duke.jpg"),
				new File("/tmp/duke-text-watermarked.jpg"),
				};

		for (File image : images) {
			BufferedImage next = ImageIO.read(image);
			writer.writeToSequence(next);
		}

		writer.close();
		output.close();
	}
}
