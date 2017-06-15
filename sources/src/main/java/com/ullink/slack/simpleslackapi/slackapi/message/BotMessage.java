package com.ullink.slack.simpleslackapi.slackapi.message;

import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;
import java.util.Optional;

@Data
public class BotMessage extends SubMessage {
    @NonNull
    private final String botId;
    @NonNull
    private final Optional<String> username;
    @NonNull

}
