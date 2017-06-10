package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;

@Data
public class ChannelMarked extends SlackEvent {
    @NonNull
    private final String channel;
    @NonNull
    private final OffsetDateTime ts;
}
