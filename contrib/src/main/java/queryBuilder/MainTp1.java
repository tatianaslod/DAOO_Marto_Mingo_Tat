package queryBuilder;

import queryVisitor.ConsoleVisitor;
import queryVisitor.JsonVisitor;
import queryVisitor.QueryVisitor;

import java.util.List;

import static queryBuilder.Const.cons;

public class MainTp1 {
    public static void main(String[] args) throws Exception {
        //Example
        final Table t = table("student");
        final StrColumn lastName = t.str("lastName");
        final IntColumn age = t.number("age");

        final SqlQuery query = SqlQueryBuilder.sqlQuery()
                .select(age, lastName)
                .from(t)
                .where(lastName.startsWith(cons("Lopez"))
                        .and(age.between(cons(18), cons(21)))
                        .and(age.lessThan(cons(18)).not()))
                .orderBy(age)
                .limit(5)
                .build();

        QueryVisitor visitor = new ConsoleVisitor();
        query.accept(visitor);
        System.out.println("\n*****************");
        JsonVisitor jsonVisitor = new JsonVisitor();
        query.accept(jsonVisitor);
        jsonVisitor.print();
    }


    private static Table table(List<Column> columns,String table) { return new Table(columns, table); }

    private static Table table(String table) { return new Table(table); }

    protected static Condition condition(String s) {
        return null;

    }

}
