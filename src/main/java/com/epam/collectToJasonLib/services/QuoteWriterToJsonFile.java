package com.epam.collectToJasonLib.services;

import com.epam.common.model.Quote;
import com.epam.producer.services.InjectValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuoteWriterToJsonFile implements QuoteWriter {

    @InjectValue("json_output_location")
    private String json_output_location;

    @SneakyThrows
    @Override
    public void writeToFile(Quote quote,String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonText = ow.writeValueAsString(quote);
        Files.write(Paths.get(fileName),jsonText.getBytes(StandardCharsets.UTF_8));
    }


}
