package com.epam.collectToJasonLib.flow;

import com.epam.collectToJasonLib.services.LibrariesManage;
import com.epam.collectToJasonLib.services.QuoteReader;
import com.epam.collectToJasonLib.services.QuoteWriter;
import com.epam.common.model.Quote;
import lombok.AllArgsConstructor;

import java.io.File;

@AllArgsConstructor
public class TransferToJsonLib {

    private QuoteReader quoteReader;
    private QuoteWriter quoteWriter;
    private LibrariesManage libs;


   public void runTransferAndCopy(boolean isMultiThread){
        if (isMultiThread) {
            multiThreadTransfer();
            return;
        }
        String[] paths = getRelevantPaths(libs.getInputDir());
        for (String path:paths) {
            Quote quote=quoteReader.readQuote(libs.getInputDir() + path);
            quoteWriter.writeToFile(quote, libs.getJson_output_location() + path);

        }

    }



    private void multiThreadTransfer(){
        String[] paths = getRelevantPaths(libs.getInputDir());
        for (String path:paths) {
           new Thread(path).run();

        }

    }
    private String[] getRelevantPaths(String folderPath) {
            File f = new File(folderPath);
            return f.list();
    }
}



