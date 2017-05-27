package com.brulser.graduationproject.javabean;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "NEWITEM".
*/
public class NewitemDao extends AbstractDao<Newitem, Long> {

    public static final String TABLENAME = "NEWITEM";

    /**
     * Properties of entity Newitem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Type = new Property(1, String.class, "type", false, "TYPE");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Time = new Property(3, String.class, "time", false, "TIME");
        public final static Property Src = new Property(4, String.class, "src", false, "SRC");
        public final static Property Category = new Property(5, String.class, "category", false, "CATEGORY");
        public final static Property Pic = new Property(6, String.class, "pic", false, "PIC");
        public final static Property Content = new Property(7, String.class, "content", false, "CONTENT");
        public final static Property Url = new Property(8, String.class, "url", false, "URL");
        public final static Property Weburl = new Property(9, String.class, "weburl", false, "WEBURL");
    }


    public NewitemDao(DaoConfig config) {
        super(config);
    }
    
    public NewitemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"NEWITEM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TYPE\" TEXT," + // 1: type
                "\"TITLE\" TEXT UNIQUE ," + // 2: title
                "\"TIME\" TEXT," + // 3: time
                "\"SRC\" TEXT," + // 4: src
                "\"CATEGORY\" TEXT," + // 5: category
                "\"PIC\" TEXT," + // 6: pic
                "\"CONTENT\" TEXT," + // 7: content
                "\"URL\" TEXT," + // 8: url
                "\"WEBURL\" TEXT);"); // 9: weburl
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NEWITEM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Newitem entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(2, type);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
 
        String src = entity.getSrc();
        if (src != null) {
            stmt.bindString(5, src);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(6, category);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(7, pic);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(8, content);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(9, url);
        }
 
        String weburl = entity.getWeburl();
        if (weburl != null) {
            stmt.bindString(10, weburl);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Newitem entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(2, type);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
 
        String src = entity.getSrc();
        if (src != null) {
            stmt.bindString(5, src);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(6, category);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(7, pic);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(8, content);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(9, url);
        }
 
        String weburl = entity.getWeburl();
        if (weburl != null) {
            stmt.bindString(10, weburl);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Newitem readEntity(Cursor cursor, int offset) {
        Newitem entity = new Newitem( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // type
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // time
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // src
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // category
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // pic
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // content
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // url
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // weburl
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Newitem entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setType(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSrc(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCategory(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPic(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setContent(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setUrl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setWeburl(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Newitem entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Newitem entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Newitem entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
