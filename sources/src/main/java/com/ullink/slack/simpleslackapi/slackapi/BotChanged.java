package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

@Data
public class BotChanged extends SlackEvent {
    @NonNull
    private final Bot bot;
}
