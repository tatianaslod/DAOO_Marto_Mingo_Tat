package queryBuilder;

import com.sun.istack.internal.NotNull;
import queryVisitor.QueryVisitor;

public class Value<T> extends Statement<T> {
    @NotNull private T value;

    private Value(T val) {
        this.value = val;
    }

    public Value() {

    }

    public static Value<String> val(@NotNull String str) {
        return new Value<String>(str);
    }

    public static Value<Integer> val(@NotNull Integer integer) {
        return new Value<Integer>(integer);
    }

    @Override
    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }

    public T getValue(){
        return value;
    }
}
