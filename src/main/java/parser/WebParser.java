package parser;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.List;

@Getter
public abstract class WebParser<Type> {
    private String URL;

    protected Document doc;

    public WebParser(String URL) {
        this.URL = URL;

        try {
            doc = Jsoup.connect(this.URL)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract List<Type> getContent();
}
