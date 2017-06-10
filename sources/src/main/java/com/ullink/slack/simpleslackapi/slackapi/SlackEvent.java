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
        @Type(value = ChannelArchive.class, name = "channel_archive"),
        @Type(value = ChannelCreated.class, name = "channel_created"),
        @Type(value = ChannelDeleted.class, name = "channel_deleted"),
        @Type(value = ChannelHistoryChanged.class, name = "channel_history_changed"),
        @Type(value = ChannelJoined.class, name = "channel_joined"),
        @Type(value = ChannelLeft.class, name = "channel_left"),
        @Type(value = ChannelMarked.class, name = "channel_marked"),
        @Type(value = ChannelRename.class, name = "channel_rename"),
        @Type(value = ChannelUnarchive.class, name = "channel_unarchive"),
        @Type(value = CommandsChanged.class, name = "commands_changed"),
        @Type(value = DndUpdated.class, name = "dnd_updated"),
        @Type(value = DndUpdatedUser.class, name = "dnd_updated_user"),
})
@Data
public abstract class SlackEvent {
    //The type property is consumed only to produce the actual type, nothing else.
}
