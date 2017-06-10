package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

@Data
public class ChannelLeft extends SlackEvent{
    @NonNull
    private final String channel;
}
