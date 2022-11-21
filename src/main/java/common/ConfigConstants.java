package common;

public class ConfigConstants {

    public static final String PLATFORM_BROWSER = "windows_chrome";
    public static class TimeOutVariable {
        public static final int WAITING_TIME = 10;
        public static final int WAIT_ELEMENT_TIME = 15;
    }

    enum Urls {
        ROZETKA_REGISTRATION("https://rozetka.com.ua/"),
        ROZETKA_LAPTOP("https://rozetka.com.ua/");

        private String url;

        Urls(String url){
            this.url  = url;
        }

        public String getUrl () {
            return url;
        }
   }

}
