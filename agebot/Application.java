package agebot;

import com.slack.api.Slack;
import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.request.Request;
import com.slack.api.bolt.response.Response;
import com.slack.api.bolt.socket_mode.SocketModeApp;
import com.slack.api.model.event.MessageEvent;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

    public static void main(String[] args) throws Exception {

        // initialize a new Slack API client using Bot User OAuth Access Token and App-Level Token
        Slack slack = Slack.getInstance();
        String botUserOAuthAccessToken = "YOUR_BOT_USER_OAUTH_ACCESS_TOKEN";
        String appLevelToken = "YOUR_APP_LEVEL_TOKEN";
        slack.methods(botUserOAuthAccessToken, appLevelToken);

        // create a new Slack Bolt app with the specified configuration
        AppConfig appConfig = new AppConfig();
        appConfig.setSingleTeamBotToken(botUserOAuthAccessToken);
        App app = new App(appConfig);

        // create an ExecutorService with 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // add a listener for incoming messages
        app.message(DATE_PATTERN, (request, response) -> {
            String text = request.getPayload().getText();
            Matcher matcher = DATE_PATTERN.matcher(text);
            if (matcher.find()) {
                String dateString = matcher.group();
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate now = LocalDate.now();
                int age = Period.between(date, now).getYears();
                String message = "You are " + age + " years old!";
                Request chatPostMessageRequest = Request.builder()
                        .withToken(botUserOAuthAccessToken)
                        .withChannel(request.getPayload().getChannelId())
                        .withText(message)
                        .build();
                try {
                    app.client().chatPostMessage(chatPostMessageRequest).get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            return response.ack();
        });

        // start the app
        SocketModeApp socketModeApp = new SocketModeApp(app, appLevelToken);
        socketModeApp.start();
    }
}
