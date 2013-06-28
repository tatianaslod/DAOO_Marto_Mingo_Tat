package queryBuilder;

import com.sun.istack.internal.NotNull;
import queryVisitor.QueryVisitor;
import queryVisitor.Visitable;

import java.util.List;


public class SqlQuery implements Visitable {
    @NotNull
    private final Select select;
    @NotNull
    private final From from;
    @NotNull
    private final Where where;
    @NotNull
    private final OrderBy orderBy;
    @NotNull
    private final GroupBy groupBy;
    @NotNull
    private final Limit limit;
    @NotNull
    private final Offset offset;
    @NotNull
    private final List<String> errorMsgList;

    SqlQuery(@NotNull List<Column> selectColumns, @NotNull List<Table> fromTables, @NotNull Condition condition, @NotNull List<Column> orderByColumns, @NotNull List<Column> groupByColumns, int limit, @NotNull List<String> errorMsgList) {
        this.errorMsgList = errorMsgList;
        this.select = new Select(selectColumns);
        this.from = new From(fromTables);
        this.where = new Where(condition);
        this.orderBy = new OrderBy(orderByColumns);
        this.groupBy = new GroupBy(groupByColumns);
        this.limit = new Limit(limit);
        this.offset = new Offset(0);


    }

    @Override
    public void accept(QueryVisitor visitor) {
        if (isValid()) {
            visitor.visit(this);
            select.accept(visitor);
            from.accept(visitor);
            where.accept(visitor);
            orderBy.accept(visitor);
            groupBy.accept(visitor);
            limit.accept(visitor);
            offset.accept(visitor);
        } else {
            visitor.visit(errorMsgList);
        }
    }

    public boolean isValid() {
        return errorMsgList.isEmpty();
    }

    public List<String> getErrorMsgList() {
        return errorMsgList;
    }

}
