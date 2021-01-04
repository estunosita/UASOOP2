package com.example.oop2.data.keluarga;

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
public final class keluargaDao_Impl implements keluargaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Keluarga> __insertionAdapterOfKeluarga;

  private final EntityDeletionOrUpdateAdapter<Keluarga> __deletionAdapterOfKeluarga;

  private final EntityDeletionOrUpdateAdapter<Keluarga> __updateAdapterOfKeluarga;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllKeluarga;

  public keluargaDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKeluarga = new EntityInsertionAdapter<Keluarga>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `data_keluarga` (`id`,`nama_kepala`,`alamat_keluarga`,`jumlah_anak`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Keluarga value) {
        stmt.bindLong(1, value.getId());
        if (value.getNama_kepala() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_kepala());
        }
        if (value.getAlamat_keluarga() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlamat_keluarga());
        }
        stmt.bindLong(4, value.getJumlah_anak());
      }
    };
    this.__deletionAdapterOfKeluarga = new EntityDeletionOrUpdateAdapter<Keluarga>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `data_keluarga` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Keluarga value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfKeluarga = new EntityDeletionOrUpdateAdapter<Keluarga>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `data_keluarga` SET `id` = ?,`nama_kepala` = ?,`alamat_keluarga` = ?,`jumlah_anak` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Keluarga value) {
        stmt.bindLong(1, value.getId());
        if (value.getNama_kepala() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_kepala());
        }
        if (value.getAlamat_keluarga() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlamat_keluarga());
        }
        stmt.bindLong(4, value.getJumlah_anak());
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllKeluarga = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM data_keluarga";
        return _query;
      }
    };
  }

  @Override
  public Object addKeluarga(final Keluarga keluarga, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfKeluarga.insert(keluarga);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteKeluarga(final Keluarga keluarga, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfKeluarga.handle(keluarga);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateKeluarga(final Keluarga keluarga, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfKeluarga.handle(keluarga);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAllKeluarga(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllKeluarga.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllKeluarga.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public LiveData<List<Keluarga>> readAllKeluarga() {
    final String _sql = "SELECT * FROM data_keluarga ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"data_keluarga"}, false, new Callable<List<Keluarga>>() {
      @Override
      public List<Keluarga> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNamaKepala = CursorUtil.getColumnIndexOrThrow(_cursor, "nama_kepala");
          final int _cursorIndexOfAlamatKeluarga = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat_keluarga");
          final int _cursorIndexOfJumlahAnak = CursorUtil.getColumnIndexOrThrow(_cursor, "jumlah_anak");
          final List<Keluarga> _result = new ArrayList<Keluarga>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Keluarga _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNama_kepala;
            _tmpNama_kepala = _cursor.getString(_cursorIndexOfNamaKepala);
            final String _tmpAlamat_keluarga;
            _tmpAlamat_keluarga = _cursor.getString(_cursorIndexOfAlamatKeluarga);
            final int _tmpJumlah_anak;
            _tmpJumlah_anak = _cursor.getInt(_cursorIndexOfJumlahAnak);
            _item = new Keluarga(_tmpId,_tmpNama_kepala,_tmpAlamat_keluarga,_tmpJumlah_anak);
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
