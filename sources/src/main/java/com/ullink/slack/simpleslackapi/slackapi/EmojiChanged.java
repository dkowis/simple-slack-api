package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public abstract class EmojiChanged extends SlackEvent {
    private OffsetDateTime eventTs;

}
