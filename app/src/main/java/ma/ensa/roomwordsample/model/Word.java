package ma.ensa.roomwordsample.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "word")
    private String word;

    // Constructeur
    public Word(@NonNull String word) {
        this.word = word;
    }

    // Getter pour 'id'
    public int getId() {
        return id;
    }

    // Setter pour 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour 'word'
    @NonNull
    public String getWord() {
        return word;
    }

    // Setter pour 'word'
    public void setWord(@NonNull String word) {
        this.word = word;
    }
}
