package com.epam.collectToJasonLib.flow;

import com.epam.collectToJasonLib.services.QuoteReader;
import com.epam.collectToJasonLib.services.QuoteReaderFomFile;
import com.epam.collectToJasonLib.services.QuoteWriter;
import com.epam.collectToJasonLib.services.QuoteWriterToJsonFile;
import com.epam.common.model.Quote;

public class RunnableTransferToJsonAndCopyFile extends Thread {
    String path;


    RunnableTransferToJsonAndCopyFile(String path) {
        this.path=path;
    }

    @Override
    public void run() {
        //מימשתי בלי לטעון מאובג'קט פאקטורי כדי לא לטעון מחדש כל פעם בעייתימבחינת אחזקה
        Quote quote=new QuoteReaderFomFile().readQuote(this.path);
        new QuoteWriterToJsonFile().writeToFile(quote,this.path);

    }
}
