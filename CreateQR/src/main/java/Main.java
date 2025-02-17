import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

public class Main {
    private static String bankCode = "970436";
    private static String accountNumber = "22222";
    private static String acocuntName = "Tran Xuan Hoan";
    private static double amount = 200000;
    private static String description = "";

    public static void main(String[] args) {
        String qr = "https://img.vietqr.io/image/" + bankCode + "-" + accountNumber + "-TEMPLATE.png";
        String infomation = "?amount=" + amount;
        // if we want to add more information, follow the example:
        // https://img.vietqr.io/image/vietinbank-113366668888-compact2.jpg?amount=1000&addInfo=dong%20qop%20quy%20vac%20xin&accountName=Quy%20Vac%20Xin%20Covid
        try {
            URI url = new URI(qr);
            BufferedImage qrImage = ImageIO.read(url.toURL());
            File output = new File("qr_code.png");
            ImageIO.write(qrImage, "png", output);
            System.out.println(output.getAbsoluteFile());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*
    * In ra trong view:
    * src="qr_code.png" hoac dung output.getAbsoluteFile()
     */
}
