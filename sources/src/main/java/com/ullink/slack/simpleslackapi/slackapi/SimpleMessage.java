package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.util.Optional;

@Data
public class SimpleMessage extends Message {

    @NonNull
    private final String channel;
    @NonNull
    private final String user;
    @NonNull
    private final Optional<Edited> edited;
}
