package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

@Data
public class BotAdded extends SlackEvent{
    private Bot bot;
}
