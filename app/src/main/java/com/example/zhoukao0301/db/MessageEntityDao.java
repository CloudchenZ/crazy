package com.example.zhoukao0301.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MESSAGE_ENTITY".
*/
public class MessageEntityDao extends AbstractDao<MessageEntity, Void> {

    public static final String TABLENAME = "MESSAGE_ENTITY";

    /**
     * Properties of entity MessageEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Msg = new Property(0, String.class, "msg", false, "MSG");
    }


    public MessageEntityDao(DaoConfig config) {
        super(config);
    }
    
    public MessageEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MESSAGE_ENTITY\" (" + //
                "\"MSG\" TEXT NOT NULL );"); // 0: msg
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MESSAGE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MessageEntity entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getMsg());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MessageEntity entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getMsg());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public MessageEntity readEntity(Cursor cursor, int offset) {
        MessageEntity entity = new MessageEntity( //
            cursor.getString(offset + 0) // msg
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MessageEntity entity, int offset) {
        entity.setMsg(cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(MessageEntity entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(MessageEntity entity) {
        return null;
    }

    @Override
    public boolean hasKey(MessageEntity entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}