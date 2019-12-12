package com.maycur.thirdapitest.common.util;

import java.util.List;
import java.util.Map;

/**
 * Create by HuQiuYue on 2019-11-21
 */
public class SqlUtil {
    public String createWhereClause(Map<String,Object> conditions){
        StringBuffer whereClause = new  StringBuffer().append("where 1 =1");
        for(String key:conditions.keySet()){
            Object value = conditions.get(key);
            if(value == null)
                whereClause.append(" and ").append(key).append(" is null");
            else if(value instanceof List){
                whereClause.append(" and ").append(key).append(" in( ");
                if (!(((List) value).isEmpty())) {
                    for(Object item:(List) value){
                        whereClause.append("'").append(item).append("',");
                    }
                    whereClause.deleteCharAt(whereClause.length()-1);
                }
                whereClause.append(")");
            }
            else if(value instanceof String){
                if(((String) value).contains("%") ){
                    whereClause.append(" and ").append(key).append(" like '").append((String) value).append("'");
                }
                else{
                    whereClause.append(" and ").append(key).append(" = ' ").append((String) value).append("' ");
                }
            }
            else{
                whereClause.append(" and ").append(key).append(" = ").append(value.toString());
            }

        }
        return whereClause.toString();
    }

    public String createDeleteSql(String tableName,Map<String,Object> conditions){
        if(conditions != null && conditions.size() != 0){
            StringBuffer sql = new StringBuffer().append("Delete from ").append(tableName);
            sql.append(createWhereClause(conditions));
            return sql.toString();
        }
        return null;
    }

    public String createUpdateSql(String tableName,Map<String,Object> targets,Map<String,Object> conditions){
        if(targets != null && targets.size() != 0 && conditions != null && conditions.size() != 0){
            StringBuffer sql = new StringBuffer().append("Update ").append(tableName).append(" set ");
            for(String key:targets.keySet()){
                sql.append(key).append(" = ");
                Object value = targets.get(key);
                if(value instanceof String){
                    sql.append(" '").append(value).append("' ");
                }
                else
                    sql.append(value).append(",");
            }
            sql.deleteCharAt(sql.length()-1);
            sql.append(createWhereClause(conditions));
            return sql.toString();
        }
        return null;
    }

    public String createInsertSql(String tableName,Map<String,Object> conditions) {
        if (conditions != null && conditions.size() != 0) {
            StringBuffer sql = new StringBuffer().append("inset into ").append(tableName);
            StringBuffer fields = new StringBuffer().append(" (");
            StringBuffer values = new StringBuffer().append(" values(");
            for (String key : conditions.keySet()) {
                fields.append(key).append(", ");
                Object value = conditions.get(key);
                if (value != null && value instanceof String)
                    values.append(" '").append(value).append(",");
                else
                    values.append(value).append(",");
            }
            fields.deleteCharAt(fields.length() - 1);
            values.deleteCharAt(values.length() - 1);
            sql.append(fields).append(")").append(values).append(")");
            return sql.toString();
        } else
            return null;

    }
}
