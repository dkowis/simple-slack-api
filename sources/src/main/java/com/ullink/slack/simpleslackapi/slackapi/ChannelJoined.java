package com.ullink.slack.simpleslackapi.slackapi;

import com.ullink.slack.simpleslackapi.slackapi.core.Channel;
import lombok.Data;
import lombok.NonNull;

@Data
public class ChannelJoined extends SlackEvent {
    @NonNull
    private final Channel channel;
}
