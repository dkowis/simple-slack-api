package com.ullink.slack.simpleslackapi.slackapi;

import com.ullink.slack.simpleslackapi.slackapi.core.Channel;
import lombok.Data;

@Data
public class ChannelJoined extends SlackEvent {
    private Channel channel;
}
