package com.ullink.slack.simpleslackapi.slackapi.core;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

//TODO: I don't think this guy is quite finished yet....
@Data
public class Channel {
    private String id;
    private String name;
    private Long created;

    //Appears everything else is optional, or I should use a simpler type for other things....
    private Optional<Boolean> isChannel;
    private Optional<String> creator;
    private Optional<Boolean> isArchived;
    private Optional<Boolean> isGeneral;
    private Optional<List<String>> members; //TODO: possibly slack user resolution
    private Optional<Topic> topic;
    private Optional<Purpose> purpose;
    private Optional<Boolean> isMember;
    //TODO: "latest" is the latest message in the channel (structure?)
    private Optional<OffsetDateTime> lastRead;
    private Optional<Long> unreadCount;
    private Optional<Long> unreadCountDisplay;

}
