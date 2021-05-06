package com.epam.collectToJasonLib;

import com.epam.collectToJasonLib.flow.TransferToJsonLib;
import com.epam.infra.ApplicationContext;
import com.epam.infra.JavaConfig;
import lombok.SneakyThrows;

public class MainCollectToJasonLib {

    @SneakyThrows
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(JavaConfig.builder().packagesToScan("com.epam").build());
        TransferToJsonLib jsonCollector = context.getObject(TransferToJsonLib.class);

        while (true){
            jsonCollector.runTransferAndCopy(false);
            Thread.sleep(10000);
        }

    }




}
