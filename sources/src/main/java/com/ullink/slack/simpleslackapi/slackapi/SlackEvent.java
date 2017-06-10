package com.ullink.slack.simpleslackapi.slackapi;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        //Todo, enumerate the types that go here, kinda gross, but not horrible
        @Type(value = BotAdded.class, name = "bot_added"),
        @Type(value = BotChanged.class, name = "bot_changed"),
        @Type(value = ChannelArchive.class, name = "channel_archive")
})
@Data
public abstract class SlackEvent {
    //The type property is consumed only to produce the actual type, nothing else.
}
