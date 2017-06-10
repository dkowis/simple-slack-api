package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.util.Optional;

@Data
public class DndStatus {
    @NonNull
    private final Boolean dndEnabled;
    @NonNull
    private final Long nextDndStartTs;
    @NonNull
    private final Long nextDndEndTs;
    @NonNull
    private final Optional<Boolean> snoozeEnabled;
    @NonNull
    private final Optional<Long> snoozeEndtime;
}
