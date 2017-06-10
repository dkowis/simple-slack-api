package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;

@Data
public class ChannelHistoryChanged extends SlackEvent {
    @NonNull
    private final OffsetDateTime latest;
    @NonNull
    private final OffsetDateTime ts;
    @NonNull
    private final OffsetDateTime eventTs;
}
