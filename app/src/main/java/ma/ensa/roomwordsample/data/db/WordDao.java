package ma.ensa.roomwordsample.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ma.ensa.roomwordsample.model.Word;

@Dao
public interface WordDao {

    // Permettre l'insertion du même mot plusieurs fois en passant
    // une stratégie de résolution de conflits.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("Delete from word_table")
    void deleteAll();

    @Query("Select * from word_table order by word asc")
    LiveData<List<Word>> getAlphabetizedWords();

}
