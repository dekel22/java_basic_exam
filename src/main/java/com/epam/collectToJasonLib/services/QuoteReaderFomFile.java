package com.epam.collectToJasonLib.services;

import com.epam.common.model.Quote;
import com.epam.producer.services.InjectValue;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;

@Data
public class QuoteReaderFomFile implements QuoteReader{

    @InjectValue("producer_output_location")
    private String inputDir;


    @SneakyThrows
    @Override
    public Quote readQuote(String path) {
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        return (Quote)in.readObject();
    }
}
