import dataobject.FormRegistration;
import jsonUtils.JsonUtil;

public class Main {

    public static void main(String[] args) {
        FormRegistration formRegistration = JsonUtil.dataFromJson();
        FormRegistration formRegistration1 = new FormRegistration();
        System.out.println(formRegistration);
    }
}
