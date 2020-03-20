package com.herprogramacion.lawyersapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.herprogramacion.lawyersapp.data.LawyersContract.LawyerEntry;













public class LawyersDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Lawyers.db";

    public LawyersDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + LawyerEntry.TABLE_NAME + " ("
                + LawyerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LawyerEntry.ID + " TEXT NOT NULL,"
                + LawyerEntry.NAME + " TEXT NOT NULL,"
                + LawyerEntry.SPECIALTY + " TEXT NOT NULL,"
                + LawyerEntry.PHONE_NUMBER + " TEXT NOT NULL,"
                + LawyerEntry.BIO + " TEXT NOT NULL,"
                + LawyerEntry.AVATAR_URI + " TEXT,"
                + "UNIQUE (" + LawyerEntry.ID + "))");



        // Insertar datos ficticios para prueba inicial
        mockData(db);

    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockLawyer(sqLiteDatabase, new Lawyer("Olla popular en zagnoli 723", "Peteco",
                "300 200 1111", "LLevo 3 kilos de arroz a las 17hs.." +
                "Colavoro con zapayos orgánicos de mihuerta,alguien puede pasar a buscarlos?.." +
                "Paso a las 17:30hs pasame dirección.." +
                "Batlle 925.",
                "OllaPopular.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Ofrezco camión 14/07/20 a partir de 20hs", "Publicado por Carlos16",
                "300 200 2222", "Nos mudamos hoy y sería de gran ayuda un camión.                                             " +
                "Pasame dirección y ahí estaré" +
                "Bautista de León 547, Gracias!!",
                "peteco.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("LLega el rìo 20:30 B. Brum 264", "Estamos a ala espera de ayuda",
                "300 200 3333", "Puedo pasar a las 19:00hs. por ahì. ",
                "rio.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Ropa de niños", "2 niñas de 7 y 9 años",
                "300 200 4444", "Se acepta ropa de abrigo e impermeable, gracias!",
                "ropa.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Se nos rompiò la puerta oribe 365", "Puerta de 2.30m x 75cm",
                "300 200 5555", "Tenemos herramientas y las bisagras, sòlo precisamos una puerta aunque sea provisoria.",
                "puerta.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Ofrezco camiòn de 17:00hs a 20:00hs", "Camiòn chico",
                "300 200 6666", "Avisen y me pongo en marcha a partir de las 17;00hs",
                "camionsito.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Ronda de comida 22:00hs.", "Tartas y empanadas",
                "300 200 1111", "Vamos a recorrer los sitios màs criticos con comida comunitaria.",
                "tartas.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Implementos de higiene", "Jabòn lìquido y agua jane",
                "300 200 1111", "Vamosa estar recorriendo con articulos de higiene el barrio Varona ",
                "limpieza.jpg"));
    }

    public long mockLawyer(SQLiteDatabase db, Lawyer lawyer) {
        return db.insert(
                LawyerEntry.TABLE_NAME,
                null,
                lawyer.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    public long saveLawyer(Lawyer lawyer) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                LawyerEntry.TABLE_NAME,
                null,
                lawyer.toContentValues());

    }

    public Cursor getAllLawyers() {
        return getReadableDatabase()
                .query(
                        LawyerEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getLawyerById(String lawyerId) {
        Cursor c = getReadableDatabase().query(
                LawyerEntry.TABLE_NAME,
                null,
                LawyerEntry.ID + " LIKE ?",
                new String[]{lawyerId},
                null,
                null,
                null);
        return c;
    }

    public int deleteLawyer(String lawyerId) {
        return getWritableDatabase().delete(
                LawyerEntry.TABLE_NAME,
                LawyerEntry.ID + " LIKE ?",
                new String[]{lawyerId});
    }

    public int updateLawyer(Lawyer lawyer, String lawyerId) {
        return getWritableDatabase().update(
                LawyerEntry.TABLE_NAME,
                lawyer.toContentValues(),
                LawyerEntry.ID + " LIKE ?",
                new String[]{lawyerId}
        );
    }
}
