package com.ullink.slack.simpleslackapi.slackapi.message;

import com.ullink.slack.simpleslackapi.slackapi.Edited;
import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;
import java.util.Optional;

@Data
public class Message extends SubMessage {
    @NonNull
    private final String channel;
    @NonNull
    private final String user;
    @NonNull
    private final String text;
    @NonNull
    private final OffsetDateTime ts;
    @NonNull
    private final Optional<Edited> edited;
}
