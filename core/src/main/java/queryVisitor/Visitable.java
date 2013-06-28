package queryVisitor;

import com.sun.istack.internal.NotNull;

public interface Visitable {

    public void accept(@NotNull QueryVisitor visitor);

}
