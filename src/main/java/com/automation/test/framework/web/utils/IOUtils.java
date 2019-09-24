package com.automation.test.framework.web.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
@Component
public class IOUtils {
    public void cleanDirectory(){
        try {
            File directory = new File("src\\main\\resources\\screenshots\\");
            FileUtils.cleanDirectory(directory);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
