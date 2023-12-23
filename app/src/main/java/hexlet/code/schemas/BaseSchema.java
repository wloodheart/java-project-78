package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    protected final List<Predicate<Object>> conditions = new ArrayList<>();

    public boolean isValid(Object data) {
        return conditions.stream()
                .allMatch(predicate -> predicate.test(data));
    }
}
