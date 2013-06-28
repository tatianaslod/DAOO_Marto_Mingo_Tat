package queryBuilder;

import com.sun.istack.internal.NotNull;
import queryVisitor.QueryVisitor;
import queryVisitor.Visitable;

public class Limit implements Visitable {
    private final int limit;

    public Limit(int limit) {
        this.limit = limit;
    }

    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }

    public int getLimit() {
        return limit;
    }

    public boolean isEmpty() {
        return limit == 0;
    }
}
