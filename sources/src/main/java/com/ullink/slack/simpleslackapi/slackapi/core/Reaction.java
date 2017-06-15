package com.ullink.slack.simpleslackapi.slackapi.core;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Reaction {
    @NonNull
    private final String name;
    @NonNull
    private final Integer count;
    @NonNull
    private final List<String> users;
}
