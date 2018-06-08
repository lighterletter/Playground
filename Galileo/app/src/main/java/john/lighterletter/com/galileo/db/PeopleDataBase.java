package john.lighterletter.com.galileo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import john.lighterletter.com.galileo.model.Person;

@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class PeopleDataBase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
