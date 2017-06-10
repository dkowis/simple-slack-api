package com.ullink.slack.simpleslackapi.slackapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

@RunWith(Parameterized.class)
public class SlackAPITest {

    //Needs to end in a . because we're going to tack on the class name
    private final String API_PACKAGE = "com.ullink.slack.simpleslackapi.slackapi.";

    private final String filename;

    @Parameterized.Parameters(name = "{index}: {0} marshalls correctly")
    public static Collection<Object[]> data() throws Exception {
        //TODO: load in all the JSON files, and yeah.
        List<String> files = getJsonEntries();
        return files.stream()
                .map(fileName -> new Object[]{fileName})
                .collect(Collectors.toList());
    }

    private static List<String> getJsonEntries() throws Exception {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(SlackAPITest.class.getClassLoader().getResourceAsStream("slackpayloads")))) {
            return buffer.lines()
                    .filter(line -> line.trim().endsWith(".json"))
                    .collect(Collectors.toList());
        }
    }


    public SlackAPITest(String filename) {
        this.filename = filename;
    }

    private static String readEntireStream(InputStream stream) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            return reader.lines()
                    .collect(Collectors.joining("\n"));
        }
    }

    @Test
    public void objectMarshallsCorrectly() throws Exception {
        //TODO: need a singleton with the object mapper that I can use
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        //END TODO

        //Load in the json file:
        InputStream stream = this.getClass().getResourceAsStream("/slackpayloads/" + filename);
        String payload = readEntireStream(stream);

        //Examine the JSON by hand, to extract the type to make sure we're marshalling to the right type
        JsonNode root = mapper.readTree(payload);
        //Convert type_name to TypeName
        String type = WordUtils.capitalizeFully(root.get("type").textValue(), '_').replaceAll("_", "");
        System.out.println("TYPE: " + type);

        Class clazz = Class.forName(API_PACKAGE + type);

        //Marshall it to a slack event
        SlackEvent event = mapper.readValue(payload, SlackEvent.class);
        //Assert that it got marshalled to the right subtype, according to the type name convention
        assertThat("Type is marshalled to " + type, event, instanceOf(clazz));

        //Remarshall it into JSON
        String reMarshalled = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(event);

        //Make sure the marshalled json matches the original!
        assertThat("Marshalled JSON matches incoming", reMarshalled, sameJSONAs(payload));
    }
}
