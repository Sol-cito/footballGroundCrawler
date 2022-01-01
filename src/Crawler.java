import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
    private String url;
    private String dateVariables;

    public Crawler(String url, String dateVariables) {
        this.url = url;
        this.dateVariables = dateVariables;
    }

    public void startCrawling() {
        try {
            Document doc = Jsoup.connect(url).post();
            this.parseCrawlingResult(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseCrawlingResult(Document doc) {
        Elements matches = doc.getElementsByClass("matches").get(0).getElementsByTag("a");
        for (Element ele : matches) {
            String playTime = ele.getElementsByClass("time").get(0).text();
            String title = ele.getElementsByClass("title").get(0).text();
            String status = ele.getElementsByClass("status").get(0).text();
            if (!"신청 마감".equals(status)) {
                System.out.println(playTime + " / " + title + " / " + status);
            }
        }
    }
}

