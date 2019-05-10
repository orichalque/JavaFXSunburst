package fr.tblf;

import fr.tblf.model.Slice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Main class for displaying JavaFX sunbursts
 */
public class Sunburst extends Application
{

    private String body;
    private static Slice slice;

    /**
     * Displays the sunburst diagram corresponding to the parameter
     * @param slice a {@link Slice}
     */
    public static void showSunburst(Slice slice) {
        Sunburst.slice = slice;
        launch(Sunburst.class);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        String body = buildBody();
        stage.setTitle("Sunburst");

        Browser browser = new Browser(body);
        Scene scene = new Scene(browser, 800, 600);

        stage.setScene(scene);
        stage.show();
    }

    class Browser extends Region {
        public Browser(String content) {
            // Create the WebView
            WebView webView = new WebView();

            // Create the WebEngine
            final WebEngine webEngine = webView.getEngine();

            webEngine.loadContent(content);
            getChildren().add(webView);
        }
    }

    /**
     * Build the html/js code for building sunbursts
     * @return a html {@link String}
     */
    private String buildBody() {
        String serializedSlice = SliceSerialisation.toJson(slice);
        body = String.format("<html>\n" +
                "    <head>\n" +
                "        <title>hello world</title>\n" +
                "        <script src=\"https://unpkg.com/sunburst-chart@1.3.1/dist/sunburst-chart.min.js\"></script>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <div id=\"chart\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            const data = %s;\n" +
                "\n" +
                "            Sunburst()\n" +
                "                .data(data)\n" +
                "                .size('size')\n" +
                "                .color('color')\n" +
                "                (document.getElementById('chart'));\n" +
                "        </script>\n" +
                "    </body>\n" +
                "</html>", serializedSlice);
        return body;
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
