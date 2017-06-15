package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;

@Data
public class EmailDomainChanged extends SlackEvent {
    @NonNull
    private final String emailDomain;
    @NonNull
    private final OffsetDateTime eventTs;
}
