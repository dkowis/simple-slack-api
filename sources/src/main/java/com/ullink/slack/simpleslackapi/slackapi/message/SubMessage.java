package com.ullink.slack.simpleslackapi.slackapi.message;

import com.ullink.slack.simpleslackapi.slackapi.SlackEvent;
import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;

@Data
public abstract class SubMessage extends SlackEvent {
    @NonNull
    private final String subtype;
    @NonNull
    private final String text;
    @NonNull
    private final OffsetDateTime ts;
}
