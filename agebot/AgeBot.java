package agebot;

import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.bolt.response.Response;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.model.event.MessageEvent;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;

public class AgeBot {

    private final ExecutorService executorService;

    public AgeBot(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public Response handleHello(EventsApiPayload<MessageEvent> payload, EventContext context) throws SlackApiException, IOException {
        //Write your code here
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);

        // Calculate period between input date and current date
        Period period = Period.between(date, LocalDate.now());

        // Extract number of years from the period
        int age = period.getYears();

        return age;
    }
    //Uncomment the below function when needed
    // public Response handleAgeMessage(EventsApiPayload<MessageEvent> payload, EventContext context) throws SlackApiException, IOException {
        
    // }
}