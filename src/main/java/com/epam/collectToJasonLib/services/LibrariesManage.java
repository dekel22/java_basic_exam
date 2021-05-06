package com.epam.collectToJasonLib.services;

import com.epam.producer.services.InjectValue;
import lombok.Data;
import lombok.Getter;

@Data
public class LibrariesManage {

    @InjectValue("producer_output_location")
    private String inputDir;

    @InjectValue("json_output_location")
    private String json_output_location;
}
