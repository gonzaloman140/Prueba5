package com.herprogramacion.lawyersapp.data;

import android.provider.BaseColumns;

/**
 * Esquema de la base de datos para abogados
 */
public class ForoContract {

    public static abstract class ForoEntry implements BaseColumns{
        public static final String TABLE_NAME ="Foro";

        public static final String ID = "id";
        public static final String TITULO_PUBLICACION = "tituloPublicacion";
        public static final String DETALLE = "detalle";
        public static final String NUMERO_TELEFONO = "numeroTelefono";
        public static final String AVATAR_URI = "avatarUri";
        public static final String CONVERSACION = "conversacion";
    }
}
