package com.alford.grappler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by WilliamAlford on 4/8/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {







    //Database Version and Name

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "positions.db";

    //POSITION TABLE

    public static final String TABLE_POSITIONS = "positions";

    //POSITION TABLE ROWS

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_IMAGE_BIG = "big_image";
    public static final String COL_IMAGE_SMALL = "small_image";
    public static final String COL_OFFENSIVE = "offensive";
    public static final String COL_DEFENSIVE = "defensive";
    public static final String COL_COST = "cost";
    public static final String COL_QUANTITY = "quantity";

    //PROFESSOR TABLE

    public static final String TABLE_PROFESSOR = "professor";

    //PROFESSOR TABLE ROWS
//
//    public static final String COL_PROF_ID = "id";
//    public static final String COL_PROF_POS_ID ="positionId";
//    public static final String COL_QUANTITY = "quantity";


    private static final String CREATE_TABLE_POSITIONS = "CREATE_TABLE " + TABLE_POSITIONS + "(" +
            COL_ID + " INTEGER NOT NULLPRIMARY KEY " +
            COL_NAME + " TEXT " +
            COL_DESCRIPTION + " TEXT " +
            COL_OFFENSIVE + " TEXT " +
            COL_DEFENSIVE + " TEXT " +
            COL_IMAGE_BIG + " TEXT " +
            COL_IMAGE_SMALL + " TEXT " +
            COL_COST + " INTEGER " +
            COL_QUANTITY + " INTEGER " +

            " ) ";


//    private static final String CREATE_TABLE_PROFESSOR = "CREATE_TABLE " + TABLE_PROFESSOR + "(" +
//            COL_PROF_ID + " INTEGER PRIMARY KEY " +
//            COL_PROF_POS_ID + "INTEGER" +
//            COL_QUANTITY + "INTEGER" +
//            " ) ";





    //Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);



    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(CREATE_TABLE_POSITIONS);
    }



    

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSITIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFESSOR);

        onCreate(db);

    }
    
//
//public void professorRemovesMoves(int mQuantity){
//    SQLiteDatabase db = getWritableDatabase();
//
//    db.execSQL(" DELETE FROM " + TABLE_PROFESSOR + " WHERE " + COL_PROF_POS_ID + " ");
//
//    }

    //Singleton

    private static DatabaseHelper sInstance;

    public static DatabaseHelper getInstance(Context context){
        if(sInstance == null){
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }




    public List<Positions> getAllPostions() {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_POSITIONS,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        List<Positions> positions = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()){


                Log.d("name", DatabaseUtils.dumpCursorToString(cursor));


                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                String bigimage = cursor.getString(cursor.getColumnIndex(COL_IMAGE_BIG));
                String smallinmage = cursor.getString(cursor.getColumnIndex(COL_IMAGE_SMALL));
                boolean offensive = cursor.getString(cursor.getColumnIndex(COL_OFFENSIVE)).equals("true");
                boolean defensive = cursor.getString(cursor.getColumnIndex(COL_DEFENSIVE)).equals("true");
                int cost = cursor.getInt(cursor.getColumnIndex(COL_COST));
                int quantity = cursor.getInt(cursor.getColumnIndex(COL_QUANTITY));
                Positions newPosition = new Positions(id, name, description, bigimage, smallinmage, defensive, offensive,cost,quantity );
                        positions.add(newPosition);
                cursor.moveToNext();
            }
        }

        cursor.close();
        return positions;


    }

    public void addToCArt(Positions positions, int add){
        int currentQuantity = positions.getmQuantity()+add;

        updateCart(positions.getmId() ,currentQuantity);




    }

    public void clearPositionsCartByQuant(){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_QUANTITY, 0);
        db.update(TABLE_POSITIONS,
                contentValues,
                COL_QUANTITY + " > 0",
                null);





            db.close();







    }

    public  void updateCart(long id, int currentQuantity) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_QUANTITY, currentQuantity);

        db.update(TABLE_POSITIONS,
                values,
                COL_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
        db.close();

    }


    public List<Positions> getAllPostionsInCart() {

        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.query(TABLE_POSITIONS,
                null,
                COL_QUANTITY + " > ?",
                new String[]{String.valueOf(0)},
                null,
                null,
                null);

        List<Positions> positions = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()){


                Log.d("name", DatabaseUtils.dumpCursorToString(cursor));


                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                String bigimage = cursor.getString(cursor.getColumnIndex(COL_IMAGE_SMALL));
                String smallinmage = cursor.getString(cursor.getColumnIndex(COL_IMAGE_BIG));
                boolean offensive = cursor.getString(cursor.getColumnIndex(COL_OFFENSIVE)).equals("true");
                boolean defensive = cursor.getString(cursor.getColumnIndex(COL_DEFENSIVE)).equals("true");
                int cost = cursor.getInt(cursor.getColumnIndex(COL_COST));
                int quantity = cursor.getInt(cursor.getColumnIndex(COL_QUANTITY));
                Positions newPosition = new Positions(id, name, description, bigimage, smallinmage, defensive, offensive,cost,quantity );
                positions.add(newPosition);
                cursor.moveToNext();
            }
        }

        cursor.close();
        return positions;


    }















    public Positions getPositionById(long id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_POSITIONS,
                null,
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        Positions positions = null;

        if (cursor.moveToFirst()) {

            positions = new Positions(

                    cursor.getLong(cursor.getColumnIndex(COL_ID)),
                    cursor.getString(cursor.getColumnIndex(COL_NAME)),
                    cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION)),
                    cursor.getString(cursor.getColumnIndex(COL_IMAGE_SMALL)),
                    cursor.getString(cursor.getColumnIndex(COL_IMAGE_BIG)),
                    cursor.getString(cursor.getColumnIndex(COL_OFFENSIVE)).equals("true"),
                    cursor.getString(cursor.getColumnIndex(COL_DEFENSIVE)).equals("true"),
                    cursor.getInt(cursor.getColumnIndex(COL_COST)),
                    cursor.getInt(cursor.getColumnIndex(COL_QUANTITY))


            );


//                Positions newPosition = new Positions(id, name, description, bigimage, smallinmage, defensive, offensive,cost,quantity );
//                positions.add(newPosition);


        }
        cursor.close();
        return positions;





        }



    public void addToCheckOut( int id, int thisQuantity) {
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_QUANTITY, thisQuantity);

        db.update(TABLE_POSITIONS,
                values,
                COL_ID + " = ?",
                new String[]{String.valueOf(id)}
                );




    }

    public List<Positions> searchPositions(String query){
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(TABLE_POSITIONS, // a. table
                null, // b. column names
                COL_NAME +" LIKE ? OR " + COL_COST + " LIKE ?", // c. selections
                new String[]{"%" + query +"%", "%" + query +"%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        List<Positions> positions = new ArrayList<>();

        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                positions.add(new Positions(
                        cursor.getLong(cursor.getColumnIndex(COL_ID)),
                        cursor.getString(cursor.getColumnIndex(COL_NAME)),
                        cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(COL_IMAGE_SMALL)),
                        cursor.getString(cursor.getColumnIndex(COL_IMAGE_BIG)),
                        cursor.getString(cursor.getColumnIndex(COL_OFFENSIVE)).equals("true"),
                        cursor.getString(cursor.getColumnIndex(COL_DEFENSIVE)).equals("true"),
                        cursor.getInt(cursor.getColumnIndex(COL_COST)),
                        cursor.getInt(cursor.getColumnIndex(COL_QUANTITY))));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return positions;
    }

//
//    public List<Positions> searchOffensively(String query){
//        SQLiteDatabase db = this.getReadableDatabase();
//
//
//        Cursor cursor = db.query(TABLE_POSITIONS, // a. table
//                COL_DEFENSIVE, // b. column names
//                COL_NAME +" LIKE ?", // c. selections
//                new String[]{query+"%"}, // d. selections args
//                null, // e. group by
//                null, // f. having
//                null, // g. order by
//                null); // h. limit
//
//        List<Positions> positions = new ArrayList<>();
//
//        if(cursor.moveToFirst()){
//            while (!cursor.isAfterLast()){
//                Positions p = new Positions(cursor.getString(cursor.getColumnIndex(COL_NAME)),
//                        cursor.getInt(cursor.getColumnIndex(COL_OFFENSIVE)));
//                Positions.add(p);
//
//                cursor.moveToNext();
//            }
//        }
//
//        return positions;
//    }





}






