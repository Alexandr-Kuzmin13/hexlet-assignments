package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) throws IllegalAccessException {

        List<String> result = new ArrayList<>();

        Field[] fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {

                    result.add(field.getName());
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) throws IllegalAccessException {

        Map<String, List<String>> result = new HashMap<>();
        List<String> resultList1 = new ArrayList<>();
        List<String> resultList2 = new ArrayList<>();

        Field[] fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            MinLength min = field.getAnnotation(MinLength.class);

            if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {

                resultList1.add("can not be null");

                result.put(field.getName(), resultList1);

            } else if (field.isAnnotationPresent(MinLength.class) && min.minLength() >= 4) {

                resultList2.add("length less than 4");

                result.put(field.getName(), resultList2);

            }
        }
        return result;
    }
}
// END
