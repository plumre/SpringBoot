package com.bayee.util;

/*
 * Created by renhongjiang on 2018/10/29.
 */

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/29 14:44
 */
public class QRCode {

    public static void createCode(String contents) {

        // 定义二维码参数
        int width = 300;
        int height = 300;
        String format = "png";
        HashMap<EncodeHintType, Object> hints = new HashMap<>(16);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);

        // 画二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
            Path file = new File("E:/code/baidu.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCode() {
        File file = new File("E:/code/baidu.png");
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

            HashMap<DecodeHintType, Object> map = new HashMap<>(16);
            map.put(DecodeHintType.CHARACTER_SET, "utf-8");

            Result result = new MultiFormatReader().decode(bitmap, map);
            System.out.println("二维码：" + result);
            System.out.println("格式：" + result.getBarcodeFormat());
            System.out.println("文本：" + result.getText());
            System.out.println("result.getNumBits() - " + result.getNumBits());
            System.out.println("result.getRawBytes() - " + result.getRawBytes());
            System.out.println("result.getResultPoints() - " + result.getResultPoints());
            System.out.println("result.getResultMetadata() - " + result.getResultMetadata());
        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       // QRCode.createCode("WiFi sdsds-202 12345678");
        QRCode.readCode();
    }

}