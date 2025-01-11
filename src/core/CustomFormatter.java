package core;
import java.util.Map;


public class CustomFormatter {
    public static String format(String template, Map<String,String>values) {
        for(Map.Entry<String,String> entry:values.entrySet()){
            template = template.replace("{"+entry.getKey()+"}", entry.getValue());
        }
        return template;
    }

    public static void main(String[] args) {
        String template = "Hi! I am {name} and age is {age}";
        Map<String,String> values = Map.of("name","Pratiksha","age","22");
        System.out.println(CustomFormatter.format(template, values));
        System.out.println();
    }
}
