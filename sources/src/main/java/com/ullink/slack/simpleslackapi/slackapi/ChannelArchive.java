package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

@Data
public class ChannelArchive extends SlackEvent{
    private String channel;
    private String user;
}
