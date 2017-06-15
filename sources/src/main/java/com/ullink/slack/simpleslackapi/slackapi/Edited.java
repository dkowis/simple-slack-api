package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;

@Data
public class Edited {
    @NonNull
    private final String user;
    @NonNull
    private final OffsetDateTime ts;
}
