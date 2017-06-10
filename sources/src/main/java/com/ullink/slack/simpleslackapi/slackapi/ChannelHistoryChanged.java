package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ChannelHistoryChanged extends SlackEvent {
    private OffsetDateTime latest;
    private OffsetDateTime ts;
    private OffsetDateTime eventTs;
}
