package com.ullink.slack.simpleslackapi.slackapi.parsing;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ullink.slack.simpleslackapi.slackapi.message.Message;
import com.ullink.slack.simpleslackapi.slackapi.message.BotMessage;
import com.ullink.slack.simpleslackapi.slackapi.message.SubMessage;

import java.io.IOException;

public class MessageDeserializer extends StdDeserializer<SubMessage> {

    protected MessageDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SubMessage deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        //TODO: needs to parse the multiple types for the message subtypes, because there are subtypes
        JsonNode node = p.getCodec().readTree(p);

        String subtype = node.get("subtype").asText();
        //TODO: should I use "reflection" and naming magic to find the type to marshall automatically?
        // yes, because that's less typing, convention over configuration, speed should be okay

        if(subtype == null) {
            //There's no subtype, so marshal the thing directly
            SubMessage m = ctxt.readValue(p, Message.class);
            return ctxt.readValue(p, Message.class);
        }

        switch(subtype) {
            case "bot_message":
                //Call deserialization for a different class type?
                return ctxt.readValue(p, BotMessage.class);
                break;
            case "channel_archive":
                break;
            case "channel_join":
                break;
            case "channel_leave":
                break;

        }

        return null;
    }
}
