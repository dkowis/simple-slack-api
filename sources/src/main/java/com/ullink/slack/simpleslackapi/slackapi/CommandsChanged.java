package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;

/**
 * As of 10 June 2017, this event should be ignored, and is only used by Slack's Web Client
 */
@Data
public class CommandsChanged extends SlackEvent{
    @NonNull
    private final OffsetDateTime eventTs;
}
