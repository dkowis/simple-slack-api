package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

@Data
public class BotChanged extends SlackEvent{
    private Bot bot;
}
