import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        String url = "https://footballground.kr/socials";
        String dateVariables = "2022-01-02T15:00:00.000Z";

        Crawler crawler = new Crawler(url, dateVariables);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("[크롤러실행]" + new Date());
                crawler.startCrawling();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000 * 60 * 3);
    }
}
