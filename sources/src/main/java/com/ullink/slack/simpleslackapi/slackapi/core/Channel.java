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
    private Boolean isChannel;
    private Long created;
    private String creator;
    private Boolean isArchived;
    private Boolean isGeneral;
    private List<String> members; //TODO: possibly slack user resolution
    private Topic topic;
    private Purpose purpose;
    private Boolean isMember;
    //TODO: "latest" is the latest message in the channel (structure?)
    private Optional<OffsetDateTime> lastRead;
    private Optional<Long> unreadCount;
    private Optional<Long> unreadCountDisplay;

}
