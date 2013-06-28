package queryBuilder;
import com.sun.istack.internal.NotNull;
import queryVisitor.QueryVisitor;
import queryVisitor.Visitable;

public abstract class Statement<T> implements Visitable {
    public abstract void accept(@NotNull QueryVisitor visitor);
}
