package queryBuilder;

import com.sun.istack.internal.NotNull;
import queryVisitor.QueryVisitor;
import queryVisitor.Visitable;

public class Offset implements Visitable {
    private final int offset;

    public Offset(int offset) {
        this.offset = offset;
    }

    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }

    public int getOffset() {
        return offset;
    }

    public boolean isEmpty() {
        return offset == 0;
    }
}
