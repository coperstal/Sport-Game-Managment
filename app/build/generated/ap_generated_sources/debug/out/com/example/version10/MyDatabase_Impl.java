package com.example.version10;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MyDatabase_Impl extends MyDatabase {
  private volatile dao _dao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `sports` (`sport_id` INTEGER NOT NULL, `sport_name` TEXT, `sport_team` TEXT, `sport_gender` TEXT, PRIMARY KEY(`sport_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `athletes` (`athlete_id` INTEGER NOT NULL, `athlete_name` TEXT, `athlete_surname` TEXT, `athlete_city` TEXT, `athlete_country` TEXT, `athlete_sport_id` INTEGER NOT NULL, `athlete_birth_date` TEXT, PRIMARY KEY(`athlete_id`), FOREIGN KEY(`athlete_sport_id`) REFERENCES `sports`(`sport_id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `teams` (`team_id` INTEGER NOT NULL, `team_name` TEXT, `team_field_name` TEXT, `team_city` TEXT, `team_country` TEXT, `team_year` TEXT, `team_sport_id` INTEGER NOT NULL, PRIMARY KEY(`team_id`), FOREIGN KEY(`team_sport_id`) REFERENCES `sports`(`sport_id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0db525f719debf7081f249f79f88c64a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `sports`");
        _db.execSQL("DROP TABLE IF EXISTS `athletes`");
        _db.execSQL("DROP TABLE IF EXISTS `teams`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSports = new HashMap<String, TableInfo.Column>(4);
        _columnsSports.put("sport_id", new TableInfo.Column("sport_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSports.put("sport_name", new TableInfo.Column("sport_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSports.put("sport_team", new TableInfo.Column("sport_team", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSports.put("sport_gender", new TableInfo.Column("sport_gender", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSports = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSports = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSports = new TableInfo("sports", _columnsSports, _foreignKeysSports, _indicesSports);
        final TableInfo _existingSports = TableInfo.read(_db, "sports");
        if (! _infoSports.equals(_existingSports)) {
          return new RoomOpenHelper.ValidationResult(false, "sports(com.example.version10.Sport).\n"
                  + " Expected:\n" + _infoSports + "\n"
                  + " Found:\n" + _existingSports);
        }
        final HashMap<String, TableInfo.Column> _columnsAthletes = new HashMap<String, TableInfo.Column>(7);
        _columnsAthletes.put("athlete_id", new TableInfo.Column("athlete_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAthletes.put("athlete_name", new TableInfo.Column("athlete_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAthletes.put("athlete_surname", new TableInfo.Column("athlete_surname", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAthletes.put("athlete_city", new TableInfo.Column("athlete_city", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAthletes.put("athlete_country", new TableInfo.Column("athlete_country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAthletes.put("athlete_sport_id", new TableInfo.Column("athlete_sport_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAthletes.put("athlete_birth_date", new TableInfo.Column("athlete_birth_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAthletes = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysAthletes.add(new TableInfo.ForeignKey("sports", "CASCADE", "CASCADE",Arrays.asList("athlete_sport_id"), Arrays.asList("sport_id")));
        final HashSet<TableInfo.Index> _indicesAthletes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAthletes = new TableInfo("athletes", _columnsAthletes, _foreignKeysAthletes, _indicesAthletes);
        final TableInfo _existingAthletes = TableInfo.read(_db, "athletes");
        if (! _infoAthletes.equals(_existingAthletes)) {
          return new RoomOpenHelper.ValidationResult(false, "athletes(com.example.version10.Athlete).\n"
                  + " Expected:\n" + _infoAthletes + "\n"
                  + " Found:\n" + _existingAthletes);
        }
        final HashMap<String, TableInfo.Column> _columnsTeams = new HashMap<String, TableInfo.Column>(7);
        _columnsTeams.put("team_id", new TableInfo.Column("team_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("team_name", new TableInfo.Column("team_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("team_field_name", new TableInfo.Column("team_field_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("team_city", new TableInfo.Column("team_city", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("team_country", new TableInfo.Column("team_country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("team_year", new TableInfo.Column("team_year", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("team_sport_id", new TableInfo.Column("team_sport_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTeams = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTeams.add(new TableInfo.ForeignKey("sports", "CASCADE", "CASCADE",Arrays.asList("team_sport_id"), Arrays.asList("sport_id")));
        final HashSet<TableInfo.Index> _indicesTeams = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTeams = new TableInfo("teams", _columnsTeams, _foreignKeysTeams, _indicesTeams);
        final TableInfo _existingTeams = TableInfo.read(_db, "teams");
        if (! _infoTeams.equals(_existingTeams)) {
          return new RoomOpenHelper.ValidationResult(false, "teams(com.example.version10.Team).\n"
                  + " Expected:\n" + _infoTeams + "\n"
                  + " Found:\n" + _existingTeams);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "0db525f719debf7081f249f79f88c64a", "d0653712d224abfc94539e6f4f062c27");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "sports","athletes","teams");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `sports`");
      _db.execSQL("DELETE FROM `athletes`");
      _db.execSQL("DELETE FROM `teams`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public dao myDao() {
    if (_dao != null) {
      return _dao;
    } else {
      synchronized(this) {
        if(_dao == null) {
          _dao = new dao_Impl(this);
        }
        return _dao;
      }
    }
  }
}
