package com.example.teoria_lengexamen.configuracion;

public class ConfigCF
{
    // Configuracion de los parametros de la base de datos local en sqlite
    //Nombre de la base de datos
    public static final String namebd = "ANTLeng";

    // Tablas de las bases de datos
    public static final String tblfutbolistas = "FUTBOLISTAS";

    // Campos de la tabla futbolistas
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String pais = "pais";
    public static final String posicion = "posicion";
    public static final String edad = "edad";

    // Creacion de objetos DDL - CREATE - DROP - ALTER
    public static final String CreateTBFutbolistas = "CREATE TABLE FUTBOLISTAS (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT," +
            "apellidos TEXT, pais TEXT, posicion TEXT, edad INTEGER)";

    public static final String DropTBFutbolistas = "DROP TABLE IF EXISTS FUTBOLISTAS";

    // Creacion de objetos DML para poder seleccionar informacion de la base de datos

    public static final String SelectTBFutbolistas = "SELECT * FROM " + ConfigCF.tblfutbolistas;

    public static final String Empty = "";
}
