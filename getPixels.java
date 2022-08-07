package getPixels;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class getPixels {

    public static void main(String[] args) {

        //  URL url = FileLoader.getResource("climbingPic.tiff");
        File file = new File("/Users/Stuben/Desktop/ClimbingPic.jpg");
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("pixels.txt"));

            BufferedImage image;
            try {
                image = ImageIO.read(file);

                //String header = "Width:" + image.getWidth() + " x Height:"
                //      + image.getHeight() + "\n";
                //writer.write(header);

                int[][] pixels = new int[3 * image.getHeight()][image
                        .getWidth()];

                for (int x = 0; x < image.getWidth(); x++) {
                    for (int y = 0; y < image.getHeight(); y++) {
                        int colorNumber = image.getRGB(x, y);
                        Color color = new Color(colorNumber, true);

                        int red = color.getRed();
                        int green = color.getGreen();
                        int blue = color.getBlue();

                        pixels[y * 3][x] = red;
                        pixels[y * 3 + 1][x] = green;
                        pixels[y * 3 + 2][x] = blue;

                    }
                }

                for (int y = 0; y < image.getHeight() * 3; y++) {
                    for (int x = 0; x < image.getWidth(); x++) {
                        writer.write(pixels[y][x] + "\t");
                    }
                    writer.write("\n");
                }

                writer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
