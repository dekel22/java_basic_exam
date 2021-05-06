package com.epam.collectToJasonLib.services;

import com.epam.common.model.Quote;

public interface QuoteReader {
    public Quote readQuote(String path);
}
