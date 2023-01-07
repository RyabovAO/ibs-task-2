package jsonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import dataobject.FormRegistration;
import java.io.File;
import java.io.IOException;

public class JsonUtil {

    public static FormRegistration dataFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        FormRegistration form = null;
        try {
            form = mapper.readValue(new File("src/test/resources/Data.json"), FormRegistration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return form;
    }
}
