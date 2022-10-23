package com.example.practica_exa_1.data;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.practica_exa_1.model.Examen;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ExamenDao_Impl implements ExamenDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Examen> __insertionAdapterOfExamen;

  private final EntityDeletionOrUpdateAdapter<Examen> __deletionAdapterOfExamen;

  private final EntityDeletionOrUpdateAdapter<Examen> __updateAdapterOfExamen;

  public ExamenDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExamen = new EntityInsertionAdapter<Examen>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `estado` (`id`,`Nombre`,`Capital`,`Población`,`Abreviatura`,`latitud`,`longitud`,`Medida`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Examen value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        if (value.getCapital() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCapital());
        }
        if (value.getPoblación() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getPoblación());
        }
        if (value.getAbreviatura() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAbreviatura());
        }
        if (value.getLatitud() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getLatitud());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getLongitud());
        }
        if (value.getMedida() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getMedida());
        }
      }
    };
    this.__deletionAdapterOfExamen = new EntityDeletionOrUpdateAdapter<Examen>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `estado` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Examen value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfExamen = new EntityDeletionOrUpdateAdapter<Examen>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR IGNORE `estado` SET `id` = ?,`Nombre` = ?,`Capital` = ?,`Población` = ?,`Abreviatura` = ?,`latitud` = ?,`longitud` = ?,`Medida` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Examen value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        if (value.getCapital() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCapital());
        }
        if (value.getPoblación() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getPoblación());
        }
        if (value.getAbreviatura() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAbreviatura());
        }
        if (value.getLatitud() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getLatitud());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getLongitud());
        }
        if (value.getMedida() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getMedida());
        }
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public Object addItem(final Examen examen, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfExamen.insert(examen);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteItem(final Examen examen, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfExamen.handle(examen);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object upadateItem(final Examen examen, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfExamen.handle(examen);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Examen>> getItems() {
    final String _sql = "SELECT * FROM estado";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"estado"}, false, new Callable<List<Examen>>() {
      @Override
      public List<Examen> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "Nombre");
          final int _cursorIndexOfCapital = CursorUtil.getColumnIndexOrThrow(_cursor, "Capital");
          final int _cursorIndexOfPoblaciN = CursorUtil.getColumnIndexOrThrow(_cursor, "Población");
          final int _cursorIndexOfAbreviatura = CursorUtil.getColumnIndexOrThrow(_cursor, "Abreviatura");
          final int _cursorIndexOfLatitud = CursorUtil.getColumnIndexOrThrow(_cursor, "latitud");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "longitud");
          final int _cursorIndexOfMedida = CursorUtil.getColumnIndexOrThrow(_cursor, "Medida");
          final List<Examen> _result = new ArrayList<Examen>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Examen _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpCapital;
            if (_cursor.isNull(_cursorIndexOfCapital)) {
              _tmpCapital = null;
            } else {
              _tmpCapital = _cursor.getString(_cursorIndexOfCapital);
            }
            final Double _tmpPoblación;
            if (_cursor.isNull(_cursorIndexOfPoblaciN)) {
              _tmpPoblación = null;
            } else {
              _tmpPoblación = _cursor.getDouble(_cursorIndexOfPoblaciN);
            }
            final String _tmpAbreviatura;
            if (_cursor.isNull(_cursorIndexOfAbreviatura)) {
              _tmpAbreviatura = null;
            } else {
              _tmpAbreviatura = _cursor.getString(_cursorIndexOfAbreviatura);
            }
            final Double _tmpLatitud;
            if (_cursor.isNull(_cursorIndexOfLatitud)) {
              _tmpLatitud = null;
            } else {
              _tmpLatitud = _cursor.getDouble(_cursorIndexOfLatitud);
            }
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            final Double _tmpMedida;
            if (_cursor.isNull(_cursorIndexOfMedida)) {
              _tmpMedida = null;
            } else {
              _tmpMedida = _cursor.getDouble(_cursorIndexOfMedida);
            }
            _item = new Examen(_tmpId,_tmpNombre,_tmpCapital,_tmpPoblación,_tmpAbreviatura,_tmpLatitud,_tmpLongitud,_tmpMedida);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
