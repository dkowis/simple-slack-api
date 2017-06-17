package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public abstract class SubMessage extends SlackEvent {
    private String text;
    private OffsetDateTime ts;
}
