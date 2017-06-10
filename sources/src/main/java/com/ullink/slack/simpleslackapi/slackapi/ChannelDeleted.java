package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

@Data
public class ChannelDeleted extends SlackEvent {
    @NonNull
    private final String channel;
}
