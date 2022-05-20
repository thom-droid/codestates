package effectives.stream;

import java.util.List;

public class Coplit4 {

    public double computeAverageOfMaleMember(List<Member> members) {
        //구현된 Member 클래스의 getName(), getGender(), getAge() 메소드로 해당 Member 클래스의 name, gender, age를 확인할 수 있습니다.
        //TODO..
        return members.stream().filter(member -> member.gender.equals("Male")).mapToInt(m -> m.age).average().orElse(0.0);
    }

    // 아래 코드는 변경하지 마세요.
    static class Member {
        String name;
        int age;
        String gender;

        public Member(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }
    }
}
