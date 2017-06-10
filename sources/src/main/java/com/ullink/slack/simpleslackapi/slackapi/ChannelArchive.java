package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

@Data
public class ChannelArchive extends SlackEvent{
    @NonNull
    private final String channel;
    @NonNull
    private final String user;
}
