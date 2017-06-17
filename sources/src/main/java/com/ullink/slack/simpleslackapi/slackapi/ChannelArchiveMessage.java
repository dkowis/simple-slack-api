package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class ChannelArchiveMessage extends Message {
    @NonNull
    private final String user;
    @NonNull
    private final List<String> members;
}
