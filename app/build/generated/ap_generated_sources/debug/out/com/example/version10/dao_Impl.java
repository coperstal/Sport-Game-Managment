package com.example.version10;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class dao_Impl implements dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Athlete> __insertionAdapterOfAthlete;

  private final EntityInsertionAdapter<Sport> __insertionAdapterOfSport;

  private final EntityInsertionAdapter<Team> __insertionAdapterOfTeam;

  private final EntityDeletionOrUpdateAdapter<Athlete> __deletionAdapterOfAthlete;

  private final EntityDeletionOrUpdateAdapter<Sport> __deletionAdapterOfSport;

  private final EntityDeletionOrUpdateAdapter<Team> __deletionAdapterOfTeam;

  private final EntityDeletionOrUpdateAdapter<Athlete> __updateAdapterOfAthlete;

  private final EntityDeletionOrUpdateAdapter<Sport> __updateAdapterOfSport;

  private final EntityDeletionOrUpdateAdapter<Team> __updateAdapterOfTeam;

  public dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAthlete = new EntityInsertionAdapter<Athlete>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `athletes` (`athlete_id`,`athlete_name`,`athlete_surname`,`athlete_city`,`athlete_country`,`athlete_sport_id`,`athlete_birth_date`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Athlete value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getSurname() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSurname());
        }
        if (value.getCity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCity());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCountry());
        }
        stmt.bindLong(6, value.getSport_id());
        if (value.getBirth_date() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBirth_date());
        }
      }
    };
    this.__insertionAdapterOfSport = new EntityInsertionAdapter<Sport>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `sports` (`sport_id`,`sport_name`,`sport_team`,`sport_gender`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Sport value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getTeam() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTeam());
        }
        if (value.getGender() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGender());
        }
      }
    };
    this.__insertionAdapterOfTeam = new EntityInsertionAdapter<Team>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `teams` (`team_id`,`team_name`,`team_field_name`,`team_city`,`team_country`,`team_year`,`team_sport_id`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Team value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getField_name() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getField_name());
        }
        if (value.getTeam_city() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTeam_city());
        }
        if (value.getTeam_country() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTeam_country());
        }
        if (value.getTeam_year() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTeam_year());
        }
        stmt.bindLong(7, value.getTeam_sport_id());
      }
    };
    this.__deletionAdapterOfAthlete = new EntityDeletionOrUpdateAdapter<Athlete>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `athletes` WHERE `athlete_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Athlete value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__deletionAdapterOfSport = new EntityDeletionOrUpdateAdapter<Sport>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `sports` WHERE `sport_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Sport value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__deletionAdapterOfTeam = new EntityDeletionOrUpdateAdapter<Team>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `teams` WHERE `team_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Team value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfAthlete = new EntityDeletionOrUpdateAdapter<Athlete>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `athletes` SET `athlete_id` = ?,`athlete_name` = ?,`athlete_surname` = ?,`athlete_city` = ?,`athlete_country` = ?,`athlete_sport_id` = ?,`athlete_birth_date` = ? WHERE `athlete_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Athlete value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getSurname() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSurname());
        }
        if (value.getCity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCity());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCountry());
        }
        stmt.bindLong(6, value.getSport_id());
        if (value.getBirth_date() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBirth_date());
        }
        stmt.bindLong(8, value.getId());
      }
    };
    this.__updateAdapterOfSport = new EntityDeletionOrUpdateAdapter<Sport>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `sports` SET `sport_id` = ?,`sport_name` = ?,`sport_team` = ?,`sport_gender` = ? WHERE `sport_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Sport value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getTeam() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTeam());
        }
        if (value.getGender() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGender());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__updateAdapterOfTeam = new EntityDeletionOrUpdateAdapter<Team>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `teams` SET `team_id` = ?,`team_name` = ?,`team_field_name` = ?,`team_city` = ?,`team_country` = ?,`team_year` = ?,`team_sport_id` = ? WHERE `team_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Team value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getField_name() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getField_name());
        }
        if (value.getTeam_city() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTeam_city());
        }
        if (value.getTeam_country() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTeam_country());
        }
        if (value.getTeam_year() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTeam_year());
        }
        stmt.bindLong(7, value.getTeam_sport_id());
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void AddAthlete(final Athlete athlete) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAthlete.insert(athlete);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void AddSport(final Sport sport) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSport.insert(sport);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void AddTeam(final Team team) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTeam.insert(team);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAthlete(final Athlete athlete) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAthlete.handle(athlete);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSport(final Sport sport) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSport.handle(sport);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTeam(final Team team) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTeam.handle(team);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAthlete(final Athlete athlete) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAthlete.handle(athlete);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateSport(final Sport sport) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSport.handle(sport);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateTeam(final Team team) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTeam.handle(team);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Athlete> getQuery11() {
    final String _sql = "select * from athletes where athlete_id=2";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_name");
      final int _cursorIndexOfSurname = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_surname");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_city");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_country");
      final int _cursorIndexOfSportId = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_sport_id");
      final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_birth_date");
      final List<Athlete> _result = new ArrayList<Athlete>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Athlete _item;
        _item = new Athlete();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpSurname;
        _tmpSurname = _cursor.getString(_cursorIndexOfSurname);
        _item.setSurname(_tmpSurname);
        final String _tmpCity;
        _tmpCity = _cursor.getString(_cursorIndexOfCity);
        _item.setCity(_tmpCity);
        final String _tmpCountry;
        _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        _item.setCountry(_tmpCountry);
        final int _tmpSport_id;
        _tmpSport_id = _cursor.getInt(_cursorIndexOfSportId);
        _item.setSport_id(_tmpSport_id);
        final String _tmpBirth_date;
        _tmpBirth_date = _cursor.getString(_cursorIndexOfBirthDate);
        _item.setBirth_date(_tmpBirth_date);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Team> getQuery22() {
    final String _sql = "select * from teams where team_id=8";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "team_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "team_name");
      final int _cursorIndexOfFieldName = CursorUtil.getColumnIndexOrThrow(_cursor, "team_field_name");
      final int _cursorIndexOfTeamCity = CursorUtil.getColumnIndexOrThrow(_cursor, "team_city");
      final int _cursorIndexOfTeamCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "team_country");
      final int _cursorIndexOfTeamYear = CursorUtil.getColumnIndexOrThrow(_cursor, "team_year");
      final int _cursorIndexOfTeamSportId = CursorUtil.getColumnIndexOrThrow(_cursor, "team_sport_id");
      final List<Team> _result = new ArrayList<Team>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Team _item;
        _item = new Team();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpField_name;
        _tmpField_name = _cursor.getString(_cursorIndexOfFieldName);
        _item.setField_name(_tmpField_name);
        final String _tmpTeam_city;
        _tmpTeam_city = _cursor.getString(_cursorIndexOfTeamCity);
        _item.setTeam_city(_tmpTeam_city);
        final String _tmpTeam_country;
        _tmpTeam_country = _cursor.getString(_cursorIndexOfTeamCountry);
        _item.setTeam_country(_tmpTeam_country);
        final String _tmpTeam_year;
        _tmpTeam_year = _cursor.getString(_cursorIndexOfTeamYear);
        _item.setTeam_year(_tmpTeam_year);
        final int _tmpTeam_sport_id;
        _tmpTeam_sport_id = _cursor.getInt(_cursorIndexOfTeamSportId);
        _item.setTeam_sport_id(_tmpTeam_sport_id);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Sport> getQuery33() {
    final String _sql = "select * from sports where sport_id=1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "sport_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "sport_name");
      final int _cursorIndexOfTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "sport_team");
      final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "sport_gender");
      final List<Sport> _result = new ArrayList<Sport>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Sport _item;
        _item = new Sport();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpTeam;
        _tmpTeam = _cursor.getString(_cursorIndexOfTeam);
        _item.setTeam(_tmpTeam);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _item.setGender(_tmpGender);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ResultStringInt> getQuery2() {
    final String _sql = "select athlete_name as field1,athlete_surname as field2,team_name as field3, sport_name as field4,sport_gender as field5 from teams inner join sports on team_sport_id=sport_id inner join athletes on athlete_sport_id=sport_id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfField1 = CursorUtil.getColumnIndexOrThrow(_cursor, "field1");
      final int _cursorIndexOfField2 = CursorUtil.getColumnIndexOrThrow(_cursor, "field2");
      final int _cursorIndexOfField3 = CursorUtil.getColumnIndexOrThrow(_cursor, "field3");
      final int _cursorIndexOfField4 = CursorUtil.getColumnIndexOrThrow(_cursor, "field4");
      final int _cursorIndexOfField5 = CursorUtil.getColumnIndexOrThrow(_cursor, "field5");
      final List<ResultStringInt> _result = new ArrayList<ResultStringInt>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ResultStringInt _item;
        _item = new ResultStringInt();
        final String _tmpField1;
        _tmpField1 = _cursor.getString(_cursorIndexOfField1);
        _item.setField1(_tmpField1);
        final String _tmpField2;
        _tmpField2 = _cursor.getString(_cursorIndexOfField2);
        _item.setField2(_tmpField2);
        final String _tmpField3;
        _tmpField3 = _cursor.getString(_cursorIndexOfField3);
        _item.setField3(_tmpField3);
        final String _tmpField4;
        _tmpField4 = _cursor.getString(_cursorIndexOfField4);
        _item.setField4(_tmpField4);
        final String _tmpField5;
        _tmpField5 = _cursor.getString(_cursorIndexOfField5);
        _item.setField5(_tmpField5);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ResultStringInt> getQuery3() {
    final String _sql = "select athlete_id as field1,athlete_name as field2,athlete_surname as field3,athlete_birth_date as field4,sport_name as field5,sport_team as field6 from athletes inner join sports on athlete_sport_id=sport_id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfField1 = CursorUtil.getColumnIndexOrThrow(_cursor, "field1");
      final int _cursorIndexOfField2 = CursorUtil.getColumnIndexOrThrow(_cursor, "field2");
      final int _cursorIndexOfField3 = CursorUtil.getColumnIndexOrThrow(_cursor, "field3");
      final int _cursorIndexOfField4 = CursorUtil.getColumnIndexOrThrow(_cursor, "field4");
      final int _cursorIndexOfField5 = CursorUtil.getColumnIndexOrThrow(_cursor, "field5");
      final int _cursorIndexOfField6 = CursorUtil.getColumnIndexOrThrow(_cursor, "field6");
      final List<ResultStringInt> _result = new ArrayList<ResultStringInt>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ResultStringInt _item;
        _item = new ResultStringInt();
        final String _tmpField1;
        _tmpField1 = _cursor.getString(_cursorIndexOfField1);
        _item.setField1(_tmpField1);
        final String _tmpField2;
        _tmpField2 = _cursor.getString(_cursorIndexOfField2);
        _item.setField2(_tmpField2);
        final String _tmpField3;
        _tmpField3 = _cursor.getString(_cursorIndexOfField3);
        _item.setField3(_tmpField3);
        final String _tmpField4;
        _tmpField4 = _cursor.getString(_cursorIndexOfField4);
        _item.setField4(_tmpField4);
        final String _tmpField5;
        _tmpField5 = _cursor.getString(_cursorIndexOfField5);
        _item.setField5(_tmpField5);
        final String _tmpField6;
        _tmpField6 = _cursor.getString(_cursorIndexOfField6);
        _item.setField6(_tmpField6);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Athlete> getAthletes() {
    final String _sql = "select * from athletes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_name");
      final int _cursorIndexOfSurname = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_surname");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_city");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_country");
      final int _cursorIndexOfSportId = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_sport_id");
      final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "athlete_birth_date");
      final List<Athlete> _result = new ArrayList<Athlete>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Athlete _item;
        _item = new Athlete();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpSurname;
        _tmpSurname = _cursor.getString(_cursorIndexOfSurname);
        _item.setSurname(_tmpSurname);
        final String _tmpCity;
        _tmpCity = _cursor.getString(_cursorIndexOfCity);
        _item.setCity(_tmpCity);
        final String _tmpCountry;
        _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        _item.setCountry(_tmpCountry);
        final int _tmpSport_id;
        _tmpSport_id = _cursor.getInt(_cursorIndexOfSportId);
        _item.setSport_id(_tmpSport_id);
        final String _tmpBirth_date;
        _tmpBirth_date = _cursor.getString(_cursorIndexOfBirthDate);
        _item.setBirth_date(_tmpBirth_date);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Sport> getSports() {
    final String _sql = "select * from sports";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "sport_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "sport_name");
      final int _cursorIndexOfTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "sport_team");
      final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "sport_gender");
      final List<Sport> _result = new ArrayList<Sport>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Sport _item;
        _item = new Sport();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpTeam;
        _tmpTeam = _cursor.getString(_cursorIndexOfTeam);
        _item.setTeam(_tmpTeam);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _item.setGender(_tmpGender);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Team> getTeams() {
    final String _sql = "select * from teams";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "team_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "team_name");
      final int _cursorIndexOfFieldName = CursorUtil.getColumnIndexOrThrow(_cursor, "team_field_name");
      final int _cursorIndexOfTeamCity = CursorUtil.getColumnIndexOrThrow(_cursor, "team_city");
      final int _cursorIndexOfTeamCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "team_country");
      final int _cursorIndexOfTeamYear = CursorUtil.getColumnIndexOrThrow(_cursor, "team_year");
      final int _cursorIndexOfTeamSportId = CursorUtil.getColumnIndexOrThrow(_cursor, "team_sport_id");
      final List<Team> _result = new ArrayList<Team>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Team _item;
        _item = new Team();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpField_name;
        _tmpField_name = _cursor.getString(_cursorIndexOfFieldName);
        _item.setField_name(_tmpField_name);
        final String _tmpTeam_city;
        _tmpTeam_city = _cursor.getString(_cursorIndexOfTeamCity);
        _item.setTeam_city(_tmpTeam_city);
        final String _tmpTeam_country;
        _tmpTeam_country = _cursor.getString(_cursorIndexOfTeamCountry);
        _item.setTeam_country(_tmpTeam_country);
        final String _tmpTeam_year;
        _tmpTeam_year = _cursor.getString(_cursorIndexOfTeamYear);
        _item.setTeam_year(_tmpTeam_year);
        final int _tmpTeam_sport_id;
        _tmpTeam_sport_id = _cursor.getInt(_cursorIndexOfTeamSportId);
        _item.setTeam_sport_id(_tmpTeam_sport_id);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
