package effectives.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Coplit10 {

    private static List<String> mergeTwoStream(List<String> list1, List<String> list2) {
        //TODO..
        return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
    }
}
