package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

@Data
public class BotAdded extends SlackEvent{
    @NonNull
    private final Bot bot;
}
