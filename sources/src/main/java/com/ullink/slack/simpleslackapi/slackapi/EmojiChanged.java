package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

//TODO: maybe build a custom marshaller for this guy? It varies on subtype, and I can't do nested type stuff
// see: https://github.com/FasterXML/jackson-databind/issues/1462#issuecomment-263693124
@Data
public class EmojiChanged extends SlackEvent {
    @NonNull
    private final String subtype;
    @NonNull
    private final Optional<String> name;
    @NonNull
    private final Optional<String> value;
    @NonNull
    private final Optional<List<String>> names;
    @NonNull
    private final OffsetDateTime eventTs;

}
