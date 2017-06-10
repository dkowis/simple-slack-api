package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.util.Map;
import java.util.Optional;

@Data
public class Bot {
    @NonNull
    private final String id;
    @NonNull
    private final Optional<String> appId;
    @NonNull
    private final String name;
    @NonNull
    private final Map<String, String> icons;
}
