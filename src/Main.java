import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WikipediaSearch searcher = new WikipediaSearch();
        JsonParserU parser = new JsonParserU();
        BrowserOpener opener = new BrowserOpener();

        try {
            System.out.print("Введите поисковый запрос: ");
            String query = scanner.nextLine();

            String response = searcher.search(query);
            parser.parseAndPrintResults(response);

            System.out.print("Введите номер статьи для открытия: ");
            int index = scanner.nextInt();

            String url = parser.getPageUrl(response, index);
            opener.openInBrowser(url);

        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
