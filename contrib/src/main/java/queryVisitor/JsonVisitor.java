package queryVisitor;

import com.sun.istack.internal.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import queryBuilder.*;

import java.util.List;

public class JsonVisitor implements QueryVisitor {

    private final JSONObject obj;
    private JSONArray query;

    public JsonVisitor() {
        obj = new JSONObject();

    }

    @Override
    public void visit(SqlQuery sqlQuery) {
        obj.put("name","sqlQuery");
    }

    @Override
    public void visit(Column column) {
        String where = (String) obj.get("where");
        obj.put("where",where+" "+column.getName());
    }

    @Override
    public void visit(Table table) {
    }

    @Override
    public void visit(Const constant) {
        String where = (String) obj.get("where");
        obj.put("where",where+" "+constant.getValue());
    }

    @Override
    public void visit(Value value) {
    }

    @Override
    public void visit(Condition condition) {
        String where = (String) obj.get("where");
        obj.put("where",where+" "+condition.getOperator().toString());
    }

    @Override
    public void visit(Select select) {
        JSONArray selectJson = new JSONArray();
        for (Column column  : select.getSelectColumns()) {
            selectJson.add(column.getName());
        }
        obj.put("select", selectJson);
    }

    @Override
    public void visit(From from) {
        JSONArray fromJson = new JSONArray();
        for (Table table  : from.getFromTables()) {
            fromJson.add(table.getName());
        }
        obj.put("from", fromJson);
    }

    @Override
    public void visit(Where where) {
        obj.put("where","");
    }

    @Override
    public void visit(GroupBy groupBy) {
        JSONArray groupByJson = new JSONArray();
        for (Column column  : groupBy.getGroupByColumns()) {
            groupByJson.add(column.getName());
        }
        obj.put("groupBy",groupByJson);
    }

    @Override
    public void visit(OrderBy orderBy) {
        JSONArray orderByJson = new JSONArray();
        for (Column column  : orderBy.getOrderByColumns()) {
            orderByJson.add(column.getName());
        }
        obj.put("orderBy",orderByJson);
    }

    @Override
    public void visit(Limit limit) {
        obj.put("limit",limit.getLimit());
    }

    @Override
    public void visit(Offset offset) {
        obj.put("offset",offset.getOffset());
    }

    @Override
    public void visit(@NotNull List<String> errorMsgList) {
        obj.put("error", errorMsgList);

    }

    public void print(){
        System.out.println(obj.toJSONString());
    }

}
