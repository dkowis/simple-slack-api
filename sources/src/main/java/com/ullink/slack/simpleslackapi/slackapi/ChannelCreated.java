package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

@Data
public class ChannelCreated extends SlackEvent{
    private Channel channel;
}
