package com.ullink.slack.simpleslackapi.slackapi.parsing;

import com.ullink.slack.simpleslackapi.slackapi.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum EventType {
    BOT_ADDED("bot_added", BotAdded.class),
    BOT_CHANGED("bot_changed", BotChanged.class),
    CHANNEL_ARCHIVE("channel_archive", ChannelArchive.class),
    CHANNEL_CREATED("channel_created", ChannelCreated.class),
    CHANNEL_DELETED("channel_deleted", ChannelDeleted.class),
    CHANNEL_HISTORY_CHANGED("channel_history_changed", ChannelHistoryChanged.class),
    CHANNEL_JOINED("channel_joined", ChannelJoined.class),
    CHANNEL_LEFT("channel_left", ChannelLeft.class),
    CHANNEL_MARKED("channel_marked", ChannelMarked.class),
    CHANNEL_RENAME("channel_rename", ChannelRename.class),
    CHANNEL_UNARCHIVE("channel_unarchive", ChannelUnarchive.class),
    COMMANDS_CHANGED("commands_changed", CommandsChanged.class),
    DND_UPDATED_USER("dnd_updated_user", DndUpdatedUser.class),
    DND_UPDATED("dnd_updated", DndUpdated.class),
    EMAIL_DOMAIN_CHANGED("email_domain_changed", EmailDomainChanged.class),
    EMOJI_CHANGED_ADD("emoji_changed", "add", EmojiChangedAdd.class),
    EMOJI_CHANGED_REMOVE("emoji_changed", "remove", EmojiChangedRemove.class),
    MESSAGE("message", SimpleMessage.class),
    FILE_CHANGE("file_change", FileChange.class),
    CHANNEL_ARCHIVE_MESSAGE("message", "channel_archive", ChannelArchiveMessage.class),

    ;

    private final Optional<String> subtype;
    private final Class<? extends SlackEvent> clazz;
    private final String type;

    @Override
    public String toString() {
        return "EventType{" +
                "subtype=" + subtype +
                ", clazz=" + clazz +
                ", type='" + type + '\'' +
                '}';
    }

    EventType(String type, Class<? extends SlackEvent> clazz) {
        this.type = type;
        this.subtype = Optional.empty();
        this.clazz = clazz;
    }

    EventType(String type, String subtype, Class<? extends SlackEvent> clazz){
        this.type = type;
        this.subtype = Optional.of(subtype);
        this.clazz = clazz;
    }

    private static class Key {
        private String type;
        private Optional<String> subtype;

        public Key(String type, Optional<String> subtype) {
            this.type = type;
            this.subtype = subtype;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "type='" + type + '\'' +
                    ", subtype=" + subtype +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (!type.equals(key.type)) return false;
            return subtype.equals(key.subtype);
        }

        @Override
        public int hashCode() {
            int result = type.hashCode();
            result = 31 * result + subtype.hashCode();
            return result;
        }
    }

    //Build a hashmap of Key to EventType
    private static Map<Key, EventType> lookupMap = Arrays.stream(EventType.values())
            .collect(
                    Collectors.toMap(eventType -> new Key(eventType.getType(), eventType.getSubtype()), et -> et)
            );

    /**
     * Provides a method to lookup an EventType by type and subtype
     * @param type type String, required
     * @param subtype subtype String, not required, could be null
     * @return the EventType that correlates, or null, I guess? TODO: should not return null
     */
    public static EventType find(String type, String subtype) {
        Key key;
        if(subtype == null || subtype.isEmpty()){
            key = new Key(type, Optional.empty());
        } else {
            key = new Key(type, Optional.of(subtype));
        }
        return lookupMap.get(key);
    }

    public Optional<String> getSubtype() {
        return subtype;
    }

    public String getType() {
        return type;
    }

    public Class<? extends SlackEvent> getClazz() {
        return clazz;
    }
}
