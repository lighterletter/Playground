package john.lighterletter.com.galileo.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import john.lighterletter.com.galileo.model.Person;

@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySinglePerson(Person movies);

    @Insert
    void insertMultiplePeople(List<Person> moviesList);

    @Query("SELECT * FROM Person WHERE firstName = :firstName")
    Person fetchOneMoviesbyMovieId(int firstName);

    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);
}