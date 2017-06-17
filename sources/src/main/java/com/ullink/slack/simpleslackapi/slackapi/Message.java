package com.ullink.slack.simpleslackapi.slackapi;

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
    private final Optional<Edited> edited;
}
