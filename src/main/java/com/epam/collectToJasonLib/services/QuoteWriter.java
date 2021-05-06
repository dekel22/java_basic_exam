package com.epam.collectToJasonLib.services;

import com.epam.common.model.Quote;

public interface QuoteWriter {
    public void writeToFile(Quote quote,String path);
}
