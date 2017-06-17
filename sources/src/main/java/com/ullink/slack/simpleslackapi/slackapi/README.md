
# What the heck is this?

This is custom marshalling logic for the Slack API. Ideally, it should be as declarative
as possible to keep the pattern simple.

## How it works
* Messages that have subtypes will have an abstract parent class. Don't set the lombok
annotations so that it requires a constructor. We'll violate the immutability principle
for simplicity's sake. 

Example: 

Parent class for the Message type, which has many subtypes:
```java 
@Data
public abstract class SubMessage extends SlackEvent {
    private String text;
    private OffsetDateTime ts;
}
```

An example implementation of a Bot Message Subtype:
```java
@Data
public class BotMessage extends SubMessage {

    @NonNull
    private final String botId;
    @NonNull
    private final Optional<String> username;

}
```



# TODO List

* [ ] Jackson-based marshaller for RTM events w/tests
* [x] Custom marshalling for timestamps
* [ ] Delete the GSON based marshallers


## Step Two TODOs
* [ ] Custom marshalling for Slack channels and Slack Users
    * look up the user ID and the channel ID, and fully resolve them into objects
    * It'd be super cool to be able to do that, but need to degrade gracefully as well
