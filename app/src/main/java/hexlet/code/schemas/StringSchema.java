package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema {

    private final List<Predicate<String>> conditions = new ArrayList<>();

    public boolean isValid(String data) {

        for (Predicate condition : conditions) {
            if (!condition.test(data)){
                return false;
            }
        }
        return true;
    }

    public StringSchema required() {
        conditions.add(Objects::nonNull);
        conditions.add(s -> !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength) {
        conditions.add(s -> s.toString().length() >= minLength);
        return this;
    }

    public StringSchema contains(String contains) {
        conditions.add(s -> s.toString().contains(contains));
        return this;
    }
}
