package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

@Data
public class ChannelDeleted extends SlackEvent {
    private String channel;
}
