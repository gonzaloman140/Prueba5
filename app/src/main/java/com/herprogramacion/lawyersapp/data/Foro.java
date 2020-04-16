package com.herprogramacion.lawyersapp.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.herprogramacion.lawyersapp.data.ForoContract.ForoEntry;

import java.util.UUID;

/**
 * Entidad "abogado"
 */
public class Foro {
    private String id;
    private String tituloPublicacion;
    private String detalle;
    private String numeroTelefono;
    private String conversacion;
    private String avatarUri;

    public Foro(String tituloPublicacion,
                  String detalle, String numeroTelefono,
                  String conversacion, String avatarUri) {
        this.id = UUID.randomUUID().toString();
        this.tituloPublicacion = tituloPublicacion;
        this.detalle = detalle;
        this.numeroTelefono = numeroTelefono;
        this.conversacion = conversacion;
        this.avatarUri = avatarUri;
    }

    public Foro(Cursor cursor) {
        id = cursor.getString(cursor.getColumnIndex(ForoEntry.ID));
        tituloPublicacion = cursor.getString(cursor.getColumnIndex(ForoEntry.TITULO_PUBLICACION));
        detalle = cursor.getString(cursor.getColumnIndex(ForoEntry.DETALLE));
        numeroTelefono = cursor.getString(cursor.getColumnIndex(ForoEntry.NUMERO_TELEFONO));
        conversacion = cursor.getString(cursor.getColumnIndex(ForoEntry.CONVERSACION));
        avatarUri = cursor.getString(cursor.getColumnIndex(ForoEntry.AVATAR_URI));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ForoEntry.ID, id);
        values.put(ForoEntry.TITULO_PUBLICACION, tituloPublicacion);
        values.put(ForoEntry.DETALLE, detalle);
        values.put(ForoEntry.NUMERO_TELEFONO, numeroTelefono);
        values.put(ForoEntry.CONVERSACION, conversacion);
        values.put(ForoEntry.AVATAR_URI, avatarUri);
        return values;
    }

    public String getId() {
        return id;
    }

    public String getTituloPublicacion() {
        return tituloPublicacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getConversacion() {
        return conversacion;
    }

    public String getAvatarUri() {
        return avatarUri;
    }
}
