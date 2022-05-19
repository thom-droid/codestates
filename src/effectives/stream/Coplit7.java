package effectives.stream;

import java.util.Arrays;
import java.util.List;

public class Coplit7 {

    private static String[] filterName(List<String> names) {

        //TODO..
        boolean isKimIncluded = names.stream().anyMatch(name -> String.valueOf(name.charAt(0)).equals("김"));

        if (isKimIncluded) {
            return names.stream()
                    .distinct()
                    .filter(name -> String.valueOf(name.charAt(0)).equals("김"))
                    .sorted()
                    .toArray(String[]::new);
        }

        return new String[]{};

    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList();
        System.out.println(Arrays.toString(filterName(names)));
    }
}
