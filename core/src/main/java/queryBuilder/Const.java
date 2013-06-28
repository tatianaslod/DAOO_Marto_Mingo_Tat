package queryBuilder;

import com.sun.istack.internal.NotNull;
import queryVisitor.QueryVisitor;

public class Const<T> extends Value<T>{
    @NotNull private final T str;

    private Const(@NotNull T str) {
        this.str = str;
    }

    public static Const<String> cons(@NotNull String str) {
        return new Const<String>(str);
    }

    public static Const<Integer> cons(@NotNull Integer integer) {
        return new Const<Integer>(integer);
    }

    @Override
    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }

    public T getValue(){
        return str;
    }

}
