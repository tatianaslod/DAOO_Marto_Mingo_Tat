package queryBuilder;

import com.sun.istack.internal.NotNull;
import queryVisitor.QueryVisitor;
import queryVisitor.Visitable;

import java.util.List;


public class From implements Visitable {
    @NotNull private final List<Table> fromTables;

    public From(@NotNull List<Table> fromTables) {
        this.fromTables = fromTables;
    }

    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }

    public List<Table> getFromTables() {
        return fromTables;
    }
}
