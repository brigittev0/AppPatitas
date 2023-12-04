package pe.edu.idat.appidatpatitas.bd;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import pe.edu.idat.appidatpatitas.bd.entity.Persona;
import pe.edu.idat.appidatpatitas.dao.PersonaDao;

@Database(entities = {Persona.class},version = 1)
public abstract class IdatRoomDataBase extends RoomDatabase
{
    public abstract PersonaDao personaDao();

    private static volatile IdatRoomDataBase INSTANCIA;

    public static IdatRoomDataBase getDatabase(final Context context) {
        if (INSTANCIA == null){
            synchronized (IdatRoomDataBase.class){
                INSTANCIA = Room.databaseBuilder(
                        context.getApplicationContext(),
                        IdatRoomDataBase.class,
                        "idatbd").build();
            }
        }
        return INSTANCIA;
    }
}
