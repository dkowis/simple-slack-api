package com.ullink.slack.simpleslackapi.slackapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.ullink.slack.simpleslackapi.slackapi.parsing.SlackApiObjectMapper;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimpleMarshallingTest {

    @Test
    public void marshallsABotAddedEvent() throws Exception {
        ObjectMapper mapper = SlackApiObjectMapper.mapper();

        String json = "{\n" +
                "    \"type\": \"bot_added\",\n" +
                "    \"bot\": {\n" +
                "        \"id\": \"B024BE7LH\",\n" +
                "        \"app_id\": \"A4H1JB4AZ\",\n" +
                "        \"name\": \"hugbot\",\n" +
                "        \"icons\": {\n" +
                "            \"image_48\": \"https:\\/\\/slack.com\\/path\\/to\\/hugbot_48.png\"\n" +
                "        }\n" +
                "    }\n" +
                "}\n";

        SlackEvent event = mapper.readValue(json, SlackEvent.class);

        assertThat("Object is not null", event, notNullValue());
        assertThat("object is marshalled correctly", event, instanceOf(BotAdded.class));

        BotAdded added = (BotAdded) event;
        assertThat("bot id", added.getBot().getId(), is("B024BE7LH"));
    }
}
