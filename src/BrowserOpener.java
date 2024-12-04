import java.awt.Desktop;
import java.net.URI;

public class BrowserOpener {
    public void openInBrowser(String url) throws Exception {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(url));
        } else {
            System.out.println("Ваше устройство не поддерживает открытие браузера.");
        }
    }
}
