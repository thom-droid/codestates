package json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class PojoA {
    int value1;
    String name;
    boolean bool;

    @JsonIgnore
    public String getClassName() {
        return this.getClass().getTypeName();
    }

    public void setSomething() {
        this.bool = false;
    }

    PojoB pojoB;
}
