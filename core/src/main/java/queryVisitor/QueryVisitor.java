package queryVisitor;

import com.sun.istack.internal.NotNull;
import queryBuilder.*;

import java.util.List;

public interface QueryVisitor {

    public void visit(@NotNull SqlQuery sqlQuery);

    public void visit(@NotNull Column column);

    public void visit(@NotNull Table table);

    public void visit(@NotNull Const constant);

    public void visit(@NotNull Value value);

    public void visit(@NotNull Condition condition);

    public void visit(@NotNull Select select);

    void visit(@NotNull From from);

    void visit(@NotNull Where where);

    void visit(@NotNull GroupBy groupBy);

    void visit(@NotNull OrderBy orderBy);

    void visit(@NotNull Limit limit);

    void visit(@NotNull Offset offset);

    void visit(@NotNull List<String> errorMsgList);

}
