package queryBuilder;

import com.sun.istack.internal.NotNull;
import queryVisitor.QueryVisitor;
import queryVisitor.Visitable;

import java.util.List;

public class OrderBy implements Visitable {
    @NotNull
    private final List<Column> orderByColumns;

    public OrderBy(@NotNull List<Column> orderByColumns) {
        this.orderByColumns = orderByColumns;
    }

    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
   }

    public List<Column> getOrderByColumns() {
        return orderByColumns;
    }

    public boolean isEmpty() {
        return orderByColumns.isEmpty();
    }
}
