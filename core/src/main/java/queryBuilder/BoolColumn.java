package queryBuilder;

import com.sun.istack.internal.NotNull;

public class BoolColumn extends Column<Boolean> {

    public BoolColumn(@NotNull String name){
        super(name);
    }

    public Condition and(@NotNull Statement<Boolean> other) {
        return Condition.condition(Operator.AND, this, other);
    }
    public Condition or(@NotNull Statement<Boolean> other) {
        return Condition.condition(Operator.OR, this, other);
    }

    public Condition not() {
        return Condition.condition(Operator.NOT, this);
    }

}
