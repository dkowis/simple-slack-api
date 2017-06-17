package com.ullink.slack.simpleslackapi.slackapi.parsing;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ullink.slack.simpleslackapi.slackapi.BotAdded;
import com.ullink.slack.simpleslackapi.slackapi.SlackEvent;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class SlackEventDeserializer extends StdDeserializer<SlackEvent> {

    public SlackEventDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SlackEvent deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        JsonNode typeNode = node.get("type");
        JsonNode subtypeNode = node.get("subtype");

        //Look up the event type from the Enum, and then marshall it!
        EventType eventType;
        if(subtypeNode != null) {
            eventType = EventType.find(typeNode.asText(), subtypeNode.asText());
        } else {
            eventType = EventType.find(typeNode.asText(), null);
        }

        return p.getCodec().treeToValue(node, eventType.getClazz());
    }
}
