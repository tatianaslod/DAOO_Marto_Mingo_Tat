package queryBuilder;

import com.sun.istack.internal.NotNull;
import queryVisitor.QueryVisitor;


public class Column<T extends Comparable<T>> extends Value<T>{
    @NotNull private final String columnName;

    public Column(@NotNull String columnName){
        this.columnName = columnName;
    }

    public Condition isNull() {
        return Condition.condition(Operator.IS_NULL, this);
    }

    public Condition isNotNull() {
        return Condition.condition(Operator.IS_NOT_NULL, this);
    }

    public Condition greaterThan(@NotNull Value<Integer> value) {
        return Condition.condition(Operator.GREAT, this, value);
    }

    public Condition greaterEqualThan(@NotNull Value<Integer> value) {
        return Condition.condition(Operator.GREAT, this, value);
    }

    public Condition lessThan(@NotNull Value<Integer> value) {
        return Condition.condition(Operator.LESS, this, value);
    }

    public Condition equalTo(@NotNull Value<Integer> value) {
        return Condition.condition(Operator.EQ, this, value);
    }

    public Condition ne(@NotNull Value<Integer> value) {
        return Condition.condition(Operator.NE, this, value);
    }

    public String getName(){
        return columnName;
    }

    public void accept(@NotNull QueryVisitor visitor){
        visitor.visit(this);
    }
}
