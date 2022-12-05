package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@AllArgsConstructor
@Getter
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {

        ObjectMapper mapperJson = new ObjectMapper();

        return mapperJson.writeValueAsString(Car.class);
    }

    public static Car unserialize(String json) throws IOException {

        ObjectMapper mapperJson = new ObjectMapper();

        return mapperJson.readValue(json, Car.class);
    }
    // END
}
