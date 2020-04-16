package com.herprogramacion.lawyersapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.herprogramacion.lawyersapp.data.ForoContract.ForoEntry;


public class
ForoDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Foro.db";

    public ForoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ForoEntry.TABLE_NAME + " ("
                + ForoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ForoEntry.ID + " TEXT NOT NULL,"
                + ForoEntry.TITULO_PUBLICACION + " TEXT NOT NULL,"
                + ForoEntry.DETALLE + " TEXT NOT NULL,"
                + ForoEntry.NUMERO_TELEFONO + " TEXT NOT NULL,"
                + ForoEntry.CONVERSACION + " TEXT NOT NULL,"
                + ForoEntry.AVATAR_URI + " TEXT,"
                + "UNIQUE (" + ForoEntry.ID + "))");



        // Insertar datos ficticios para prueba inicial
        mockData(db);

    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockForo(sqLiteDatabase, new Foro("Olla popular en zagnoli 723", "Peteco",
                "099 203 986", "LLevo 3 kilos de arroz a las 17hs.." +
                "Colavoro con zapayos orgánicos de mihuerta,alguien puede pasar a buscarlos?.." +
                "Paso a las 17:30hs pasame dirección.." +
                "Batlle 925.",
                "OllaPopular.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ofrezco camión 14/07/20 a partir de 20hs", "Publicado por Carlos16",
                "099 147 251", "Nos mudamos hoy y sería de gran ayuda un camión.                                             " +
                "Pasame dirección y ahí estaré" +
                "Bautista de León 547, Gracias!!",
                "camionFlete.jpg"));
        mockForo(sqLiteDatabase, new Foro("LLega el rìo 20:30 B. Brum 264", "B. Brum 264",
                "094 126 411", "Puedo pasar a las 19:00hs. por ahì. ",
                "rio.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ropa de niños", "2 niñas de 7 y 9 años",
                "091 342 609", "Se acepta ropa de abrigo e impermeable, gracias!",
                "donaciones.jpg"));
        mockForo(sqLiteDatabase, new Foro("Se nos rompiò la puerta oribe 365", "Puerta de 2.30m x 75cm",
                "098 143 555", "Tenemos herramientas y las bisagras, sòlo precisamos una puerta aunque sea provisoria.",
                "puerta.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ofrezco camiòn de 17:00hs a 20:00hs", "Camiòn chico",
                "098 789 745", "Avisen y me pongo en marcha a partir de las 17;00hs",
                "camionsito.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ronda de comida 22:00hs.", "Tartas y empanadas",
                "099 627 524", "Vamos a recorrer los sitios màs criticos con comida comunitaria.",
                "tartas.jpg"));
        mockForo(sqLiteDatabase, new Foro("Implementos de higiene", "Jabòn lìquido y agua jane",
                "096 199 627", "Vamosa estar recorriendo con articulos de higiene el barrio Varona ",
                "limpieza.jpg"));
        mockForo(sqLiteDatabase, new Foro("Olla popular en zagnoli 723", "Peteco",
                "099 203 986", "LLevo 3 kilos de arroz a las 17hs.." +
                "Colavoro con zapayos orgánicos de mihuerta,alguien puede pasar a buscarlos?.." +
                "Paso a las 17:30hs pasame dirección.." +
                "Batlle 925.",
                "OllaPopular.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ofrezco camión 14/07/20 a partir de 20hs", "Publicado por Carlos16",
                "099 147 251", "Nos mudamos hoy y sería de gran ayuda un camión.                                             " +
                "Pasame dirección y ahí estaré" +
                "Bautista de León 547, Gracias!!",
                "camionFlete.jpg"));
        mockForo(sqLiteDatabase, new Foro("LLega el rìo 20:30 B. Brum 264", "Estamos a ala espera de ayuda, Gracias!",
                "094 126 411", "Puedo pasar a las 19:00hs. por ahì. ",
                "rio.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ropa de niños", "2 niñas de 7 y 9 años",
                "091 342 609", "Se acepta ropa de abrigo e impermeable, gracias!",
                "ropaNiños.jpg"));
        mockForo(sqLiteDatabase, new Foro("Se nos rompiò la puerta oribe 365", "Puerta de 2.30m x 75cm",
                "098 143 555", "Tenemos herramientas y las bisagras, sòlo precisamos una puerta aunque sea provisoria.",
                "puerta.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ofrezco camiòn de 17:00hs a 20:00hs", "Camiòn chico",
                "098 789 745", "Avisen y me pongo en marcha a partir de las 17;00hs",
                "camionsito.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ronda de comida 22:00hs.", "Tartas y empanadas",
                "099 627 524", "Vamos a recorrer los sitios màs criticos con comida comunitaria.",
                "tartas.jpg"));
        mockForo(sqLiteDatabase, new Foro("Implementos de higiene", "Jabòn lìquido y agua jane",
                "096 199 627", "Vamosa estar recorriendo con articulos de higiene el barrio Varona ",
                "limpieza.jpg"));
        mockForo(sqLiteDatabase, new Foro("Olla popular en zagnoli 723", "Peteco",
                "099 203 986", "LLevo 3 kilos de arroz a las 17hs.." +
                "Colavoro con zapayos orgánicos de mihuerta,alguien puede pasar a buscarlos?.." +
                "Paso a las 17:30hs pasame dirección.." +
                "Batlle 925.",
                "OllaPopular.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ofrezco camión 14/07/20 a partir de 20hs", "Publicado por Carlos16",
                "099 147 251", "Nos mudamos hoy y sería de gran ayuda un camión.                                             " +
                "Pasame dirección y ahí estaré" +
                "Bautista de León 547, Gracias!!",
                "camionFlete.jpg"));
        mockForo(sqLiteDatabase, new Foro("LLega el rìo 20:30 B. Brum 264", "Estamos a ala espera de ayuda, Gracias!",
                "094 126 411", "Puedo pasar a las 19:00hs. por ahì. ",
                "rio.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ropa de niños", "2 niñas de 7 y 9 años",
                "091 342 609", "Se acepta ropa de abrigo e impermeable, gracias!",
                "ropaNiños.jpg"));
        mockForo(sqLiteDatabase, new Foro("Se nos rompiò la puerta oribe 365", "Puerta de 2.30m x 75cm",
                "098 143 555", "Tenemos herramientas y las bisagras, sòlo precisamos una puerta aunque sea provisoria.",
                "puerta.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ofrezco camiòn de 17:00hs a 20:00hs", "Camiòn chico",
                "098 789 745", "Avisen y me pongo en marcha a partir de las 17;00hs",
                "camionsito.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ronda de comida 22:00hs.", "Tartas y empanadas",
                "099 627 524", "Vamos a recorrer los sitios màs criticos con comida comunitaria.",
                "tartas.jpg"));
        mockForo(sqLiteDatabase, new Foro("Implementos de higiene", "Jabòn lìquido y agua jane",
                "096 199 627", "Vamosa estar recorriendo con articulos de higiene el barrio Varona ",
                "limpieza.jpg"));
        mockForo(sqLiteDatabase, new Foro("Olla popular en zagnoli 723", "Peteco",
                "099 203 986", "LLevo 3 kilos de arroz a las 17hs.." +
                "Colavoro con zapayos orgánicos de mihuerta,alguien puede pasar a buscarlos?.." +
                "Paso a las 17:30hs pasame dirección.." +
                "Batlle 925.",
                "OllaPopular.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ofrezco camión 14/07/20 a partir de 20hs", "Publicado por Carlos16",
                "099 147 251", "Nos mudamos hoy y sería de gran ayuda un camión.                                             " +
                "Pasame dirección y ahí estaré" +
                "Bautista de León 547, Gracias!!",
                "camionFlete.jpg"));
        mockForo(sqLiteDatabase, new Foro("LLega el rìo 20:30 B. Brum 264", "Estamos a ala espera de ayuda, Gracias!",
                "094 126 411", "Puedo pasar a las 19:00hs. por ahì. ",
                "rio.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ropa de niños", "2 niñas de 7 y 9 años",
                "091 342 609", "Se acepta ropa de abrigo e impermeable, gracias!",
                "ropaNiños.jpg"));
        mockForo(sqLiteDatabase, new Foro("Se nos rompiò la puerta oribe 365", "Puerta de 2.30m x 75cm",
                "098 143 555", "Tenemos herramientas y las bisagras, sòlo precisamos una puerta aunque sea provisoria.",
                "puerta.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ofrezco camiòn de 17:00hs a 20:00hs", "Camiòn chico",
                "098 789 745", "Avisen y me pongo en marcha a partir de las 17;00hs",
                "camionsito.jpg"));
        mockForo(sqLiteDatabase, new Foro("Ronda de comida 22:00hs.", "Tartas y empanadas",
                "099 627 524", "Vamos a recorrer los sitios màs criticos con comida comunitaria.",
                "tartas.jpg"));
        mockForo(sqLiteDatabase, new Foro("Implementos de higiene", "Jabòn lìquido y agua jane",
                "096 199 627", "Vamosa estar recorriendo con articulos de higiene el barrio Varona ",
                "limpieza.jpg"));
    }

    public long mockForo(SQLiteDatabase db, Foro foro) {
        return db.insert(
                ForoEntry.TABLE_NAME,
                null,
                foro.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    public long saveForo(Foro foro) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                ForoEntry.TABLE_NAME,
                null,
                foro.toContentValues());

    }

    public Cursor getAllForo() {
        return getReadableDatabase()
                .query(
                        ForoEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getForoById(String foroId) {
        Cursor c = getReadableDatabase().query(
                ForoEntry.TABLE_NAME,
                null,
                ForoEntry.ID + " LIKE ?",
                new String[]{foroId},
                null,
                null,
                null);
        return c;
    }

    public int deleteForo(String foroId) {
        return getWritableDatabase().delete(
                ForoEntry.TABLE_NAME,
                ForoEntry.ID + " LIKE ?",
                new String[]{foroId});
    }

    public int updateForo(Foro foro, String foroId) {
        return getWritableDatabase().update(
                ForoEntry.TABLE_NAME,
                foro.toContentValues(),
                ForoEntry.ID + " LIKE ?",
                new String[]{foroId}
        );
    }


}
