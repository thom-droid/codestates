package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonMain {

    public static void main(String[] args) throws IOException {

        PojoB pojoB = new PojoB(10, null, false);
        PojoA pojoA = new PojoA(5, "kim", true, pojoB);
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(pojoA);
        System.out.println(json);

//        List<Object> list = Arrays.asList(1,"kim",3,null,5,true, pojoA, new int[]{1,2,3,4,5});
//        String json2 = om.writeValueAsString(list);
//        System.out.println(json2);

        PojoA deserialized = om.readValue(json, PojoA.class);
        System.out.println(deserialized.toString());
    }
}
