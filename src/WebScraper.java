import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] args) {
        //while there are still new lines
        scrapeWeb("http://erdani.com/tdpl/hamlet.txt");
    }

    public static void scrapeWeb(String url) {
        String webPage = urlToString(url);
        int numOfWords = 0;
        //every new line, separate it into a string, ignoring empty lines
        //String[] webArray = webPage.split("\n");
        String[] webArray = webPage.split("prince");
        System.out.println(webArray.length);
/**
        for (int count = 0; count < 2; count++) {
            for (int count1 = 0; count1 < webArray[count].length(); count1++) {
                if (webArray[count].charAt(count1) == ' ') {
                    numOfWords += 1;
                }
                if (webArray[count].equals("\n")) {
                    break;
                }
            }
        }
 System.out.println(numOfWords);
 */
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
