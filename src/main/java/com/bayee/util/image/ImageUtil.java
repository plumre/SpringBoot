package com.bayee.util.image;

/*
 * Created by renhongjiang on 2018/12/11.
 */

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/11 15:11
 */
public class ImageUtil {


    public static void main(String[] args) {
        String image = "C:\\Users\\Tiramisu\\Pictures\\Saved Pictures\\gewg.jpg";
        String watermark = "C:\\Users\\Tiramisu\\Pictures\\Saved Pictures\\123.png";
        String format = "bmp";
        double scale = 0.6;
        String directory = "D:\\KProject\\upndown\\web\\images";
        double degree = 0;
        String[] images = {"D:\\KProject\\upndown\\web\\images"};

        /*generateFixedSizeImage(image);
        generateRotationWatermark(image, watermark);
        convertImageFormat(image, format);
        generateScale(image, scale);
        generateThumbnail2Directory(images, directory);*/
        generateDirectoryThumbnail(directory);
        /*rotateImage(image, degree);
        toBufferedImage(image);
        cutImage(image);*/
    }

    /**
     * get a image cut from center as per the size of source region
     *
     * @param image source image path
     */
    private static void cutImage(String image) {
        try {
            Thumbnails.of(image).
                    sourceRegion(Positions.CENTER, 400, 400).
                    size(300, 300).
                    keepAspectRatio(false).
                    toFile(getPathname(image, "_cut"));
        } catch (IOException e) {
            printlnE(e);
        }
    }

    /**
     * get the image as buffered
     *
     * @param image source image path
     */
    private static void toBufferedImage(String image) {
        try {
            BufferedImage thumbnail =
                    Thumbnails.of(image).
                            size(1024, 768).
                            asBufferedImage();
            ImageIO.write(thumbnail, "jpg", new File(getPathname(image, "_buffered")));
        } catch (IOException e) {
            printlnE(e);
        }
    }

    /**
     * rotate image as per the given degree
     *
     * @param image  source image path
     * @param degree the double value, positive numbers mean rotating clockwise;
     *               negative numbers mean anticlockwise
     */
    private static void rotateImage(String image, double degree) {
        try {
            Thumbnails.of(image).
                    size(600, 400).
                    rotate(degree).
                    toFile(getPathname(image, "_rotate"));
        } catch (IOException e) {
            printlnE(e);
        }
    }

    private static void printlnE(IOException e) {
        System.out.println("故障原因：" + e.getMessage());
    }

    private static void generateDirectoryThumbnail(String directory) {
        try {
            Thumbnails.of(Objects.requireNonNull(new File(directory).listFiles())).
                    scale(0.4).
                    toFiles(new File(directory), Rename.SUFFIX_HYPHEN_THUMBNAIL);
        } catch (IOException e) {
            printlnE(e);
        }
    }

    /**
     * generate thumbnail of given images to the specific directory
     *
     * @param images    a batch of source image paths
     * @param directory the specific directory to store thumbnails
     */
    private static void generateThumbnail2Directory(String[] images, String directory) {
        try {
            Thumbnails.of(images).
                    scale(0.6).
                    toFiles(new File(directory), Rename.NO_CHANGE);
        } catch (IOException e) {
            printlnE(e);
        }
    }

    /**
     * scale up/down the original image
     *
     * @param image source image path
     * @param scale a double value for scale
     */
    private static void generateScale(String image, double scale) {
        try {
            Thumbnails.of(image).
                    scale(scale).
                    outputQuality(0.8).
                    toFile(getPathname(image, "_scale"));
        } catch (IOException e) {
            printlnE(e);
        }
    }

    /**
     * convert the format of image to new one
     *
     * @param image  source image path
     * @param format the new format
     */
    private static void convertImageFormat(String image, String format) {
        try {
            OutputStream outputStream = new FileOutputStream(getPathname(changeSuffix(image, format), "_outputstream"));
            Thumbnails.of(image).
                    size(500, 500).
                    outputFormat(format).
                    toOutputStream(outputStream);
        } catch (IOException e) {
            printlnE(e);
        }
    }

    /**
     * change the suffix of image to the one provided by client
     *
     * @param image  source image path
     * @param format new image suffix
     * @return file path with format of String
     */
    private static String changeSuffix(String image, String format) {
        return new StringBuffer(image).replace(image.lastIndexOf('.') + 1,
                image.length(), format).toString();
    }

    /**
     * get the file path after the new label added
     *
     * @param image source image path
     * @param label label for new image
     * @return file path with format of String
     */
    private static String getPathname(String image, String label) {
        return new StringBuffer(image).insert(image.lastIndexOf('.'),
                label).toString();
    }

    /**
     * generate the image with watermark
     *
     * @param image     source image path
     * @param watermark watermark path
     */
    private static void generateRotationWatermark(String image, String watermark) {
        try {
            Thumbnails.of(image).
                    size(800, 600).
                    watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(watermark)), 0.5f).
                    outputQuality(0.8).
                    toFile(getPathname(image, "_watermark"));
        } catch (IOException e) {
            printlnE(e);
        }
    }

    /**
     * generate a image as per the fixed size with the original one
     *
     * @param image source image path
     */
    private static void generateFixedSizeImage(String image) {
        try {
            Thumbnails.of(image).
                    size(640, 480).
                    // 图片默认按比例缩放, false指定不按比例
                            keepAspectRatio(false).
                    toFile(getPathname(image, " - 640_480"));
        } catch (IOException e) {
            printlnE(e);
        }
    }

}