import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class QR {
    private String bankCode = "970436";
    private String accountNumber = "1025797284";
    private String acocuntName = "Tran Xuan Hoan";
    double amount = 200000;

    public static String generateQRCodeImage(String data, int width, int height) {
        StringBuilder result = new StringBuilder();
        if (!data.isEmpty()) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                QRCodeWriter writer = new QRCodeWriter();
                // Ma hoa thong tin vao ma tran
                BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, width, height);
                BufferedImage image = toBufferedImage(bitMatrix);
                ImageIO.write(image, "png", os);
                result.append(new String(Base64.getEncoder().encode(os.toByteArray())));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Lap trinh vien";
        System.out.println(generateQRCodeImage(input, 300, 300));
    }

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0x000000 : 0xFFFFFF); // Màu đen cho bit 1, trắng cho bit 0
            }
        }
        return image;
    }
}
