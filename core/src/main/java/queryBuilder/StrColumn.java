package queryBuilder;


import com.sun.istack.internal.NotNull;

import static queryBuilder.Condition.condition;


public class StrColumn extends Column<String> {

    public StrColumn(String name) {
        super(name);
    }


    public Condition equals(@NotNull Value<String> value) {
        return condition(Operator.EQ, this, value);
    }

    public Condition startsWith(@NotNull Value<String> value) {
        return condition(Operator.STARTS, this, value);
    }

    public Condition contains(@NotNull Value<String> value) {
        return condition(Operator.CONTAINS, this, value);
    }


}
