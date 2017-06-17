package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.util.Optional;

@Data
public class BotMessage extends Message {

    @NonNull
    private final String botId;
    @NonNull
    private final Optional<String> username;

}
