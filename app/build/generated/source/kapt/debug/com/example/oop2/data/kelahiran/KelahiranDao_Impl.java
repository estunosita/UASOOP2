package com.example.oop2.data.kelahiran;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class KelahiranDao_Impl implements KelahiranDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Kelahiran> __insertionAdapterOfKelahiran;

  private final EntityDeletionOrUpdateAdapter<Kelahiran> __deletionAdapterOfKelahiran;

  private final EntityDeletionOrUpdateAdapter<Kelahiran> __updateAdapterOfKelahiran;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllKelahiran;

  public KelahiranDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKelahiran = new EntityInsertionAdapter<Kelahiran>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `data_kelahiran` (`id`,`nama_kelahiran`,`panjang`,`berat`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Kelahiran value) {
        stmt.bindLong(1, value.getId());
        if (value.getNama_kelahiran() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_kelahiran());
        }
        stmt.bindLong(3, value.getPanjang());
        stmt.bindLong(4, value.getBerat());
      }
    };
    this.__deletionAdapterOfKelahiran = new EntityDeletionOrUpdateAdapter<Kelahiran>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `data_kelahiran` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Kelahiran value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfKelahiran = new EntityDeletionOrUpdateAdapter<Kelahiran>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `data_kelahiran` SET `id` = ?,`nama_kelahiran` = ?,`panjang` = ?,`berat` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Kelahiran value) {
        stmt.bindLong(1, value.getId());
        if (value.getNama_kelahiran() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_kelahiran());
        }
        stmt.bindLong(3, value.getPanjang());
        stmt.bindLong(4, value.getBerat());
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllKelahiran = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM data_kelahiran";
        return _query;
      }
    };
  }

  @Override
  public Object addKelahiran(final Kelahiran kelahiran, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfKelahiran.insert(kelahiran);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteKelahiran(final Kelahiran kelahiran, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfKelahiran.handle(kelahiran);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateKElahiran(final Kelahiran kelahiran, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfKelahiran.handle(kelahiran);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAllKelahiran(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllKelahiran.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllKelahiran.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public LiveData<List<Kelahiran>> readAllKelahiran() {
    final String _sql = "SELECT * FROM data_kelahiran ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"data_kelahiran"}, false, new Callable<List<Kelahiran>>() {
      @Override
      public List<Kelahiran> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNamaKelahiran = CursorUtil.getColumnIndexOrThrow(_cursor, "nama_kelahiran");
          final int _cursorIndexOfPanjang = CursorUtil.getColumnIndexOrThrow(_cursor, "panjang");
          final int _cursorIndexOfBerat = CursorUtil.getColumnIndexOrThrow(_cursor, "berat");
          final List<Kelahiran> _result = new ArrayList<Kelahiran>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Kelahiran _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNama_kelahiran;
            _tmpNama_kelahiran = _cursor.getString(_cursorIndexOfNamaKelahiran);
            final int _tmpPanjang;
            _tmpPanjang = _cursor.getInt(_cursorIndexOfPanjang);
            final int _tmpBerat;
            _tmpBerat = _cursor.getInt(_cursorIndexOfBerat);
            _item = new Kelahiran(_tmpId,_tmpNama_kelahiran,_tmpPanjang,_tmpBerat);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
