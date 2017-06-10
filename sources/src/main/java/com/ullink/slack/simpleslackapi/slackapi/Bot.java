package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

import java.util.Map;
import java.util.Optional;

@Data
public class Bot {
    private String id;
    private Optional<String> appId;
    private String name;
    private Map<String, String> icons;
}
