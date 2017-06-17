package com.ullink.slack.simpleslackapi.slackapi;

import com.ullink.slack.simpleslackapi.slackapi.core.Reaction;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Data
public abstract class Message extends SlackEvent {
    private String text;
    private OffsetDateTime ts;
    private Optional<List<Reaction>> reactions;
    private Optional<Boolean> hidden;
    private Optional<List<Attachment>> attachments;

}
