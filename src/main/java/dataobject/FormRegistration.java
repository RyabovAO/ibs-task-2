package dataobject;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jsonUtils.JsonUtil;
import lombok.Data;
import java.util.Arrays;
import java.util.List;

@Data
@JsonAutoDetect
public class FormRegistration {

    private String name;
    private String phone;
    private String mail;
    private String address;

    public FormRegistration generateData() {
        this.name = "Алексей Рябов";
        this.phone = "8000000000";
        this.mail = "qweasd";
        this.address = "Asd";
        return this;
    }

    public FormRegistration() {
        generateData();
    }

    public List<String> getListValue() {
        return Arrays.asList(name, formatPhone(), mail, address);
    }

    public String formatPhone() {
        return "+7 (" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6);
    }

}
