package ma.ensa.roomwordsample.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ma.ensa.roomwordsample.data.db.WordDao;
import ma.ensa.roomwordsample.data.db.WordRoomDatabase;
import ma.ensa.roomwordsample.model.Word;

public class WordRepository {

    private final WordDao mwordDao;
    private final LiveData<List<Word>> mAllWords;

    public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mwordDao = db.wordDao();
        mAllWords = mwordDao.getAlphabetizedWords();
    }

    // Room exécute toutes les requêtes sur un thread distinct.
    // Les données LiveData observées avertiront l'observateur lorsque les données auront changé.
    public LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    // Vous devez appeler cela sur un thread non-UI ou votre application lancera une exception.
    // Room garantit que vous n'effectuez aucune opération longue sur le thread principal, bloquant l'interface utilisateur.
    public void insert(Word word){
        WordRoomDatabase.datebaseWriteExecutor.execute(()-> mwordDao.insert(word));
    }
}
