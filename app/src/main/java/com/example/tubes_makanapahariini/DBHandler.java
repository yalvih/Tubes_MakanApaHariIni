package com.example.tubes_makanapahariini;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    protected static final int database_version = 1;
    protected static final String database_name = "Food_List";
    private static final String TABLE_FOOD = "Food_Table";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESC = "descripton";
    private static final String KEY_INGREDIENTS = "ingredient";
    private static final String KEY_LOCATION_RESTAURANT = "location_restaurant";
    private static final String KEY_NAME_RESTAURANT = "name_restarant";

    public DBHandler(Context context) {
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_FOOD + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_DESC + " TEXT,"
                + KEY_INGREDIENTS + " TEXT,"
                + KEY_LOCATION_RESTAURANT + " TEXT,"
                + KEY_NAME_RESTAURANT + " TEXT" +" )";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
        onCreate(db);
    }

    public void addRecord(Food food) {
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, food.getTitle());
        values.put(KEY_DESC, food.getDescription());
        values.put(KEY_INGREDIENTS, food.getIngredients());
        values.put(KEY_LOCATION_RESTAURANT, food.getRestaurant_location());
        values.put(KEY_NAME_RESTAURANT, food.getName_restaurant());

        db.insert(TABLE_FOOD, null, values);
        db.close();
    }

    public Food getFood(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOOD, new String[] {KEY_ID, KEY_NAME, KEY_DESC, KEY_INGREDIENTS, KEY_LOCATION_RESTAURANT, KEY_NAME_RESTAURANT}, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null) cursor.moveToFirst();

        Food food = new Food(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5));

        return food;
    }

    public List<Food> getAllRecord() {
        List<Food> foodList = new ArrayList<>();
        // Select all query
        String selectQuery = "SELECT * FROM " + TABLE_FOOD;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Food food = new Food(); //THIS
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setDescription(cursor.getString(2));
                food.setIngredients(cursor.getString(3));
                food.setRestaurant_location(cursor.getString(4));
                food.setRestaurant_name(cursor.getString(5));

                foodList.add(food);
            } while (cursor.moveToNext());
        }

        // Return contact list
        return foodList;
    }

    public List<Food> getSearchResults(String query) {
        List<Food> foodList = new ArrayList<>();
        StringBuilder searchQuery = new StringBuilder("SELECT * FROM " + TABLE_FOOD);;
        // Split keywords if query contains whitespace
        String[] keywords = query.split(" ");
        // Match names
        searchQuery.append(" WHERE " + KEY_NAME + " LIKE '%");
        for (int i = 0; i < keywords.length; i++) {
            if (i == keywords.length - 1) {
                searchQuery.append(keywords[i]).append("%");
            }
            else searchQuery.append(keywords[i]).append("%' OR ").append(KEY_NAME).append(" LIKE '%");
        }
        // Match description
        searchQuery.append("' OR " + KEY_DESC + " LIKE '%");
        for (int i = 0; i < keywords.length; i++) {
            if (i == keywords.length - 1) {
                searchQuery.append(keywords[i]).append("%");
            }
            else searchQuery.append(keywords[i]).append("%' OR ").append(KEY_DESC).append(" LIKE '%");
        }
        searchQuery.append("' ORDER BY " + KEY_ID);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(searchQuery.toString(), null);

        if (cursor.moveToFirst()) {
            Log.d("Cursor number", Boolean.toString(cursor.moveToFirst()));
            do {
                Food food = new Food(); //THIS
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setDescription(cursor.getString(2));
                food.setIngredients(cursor.getString(3));
                food.setRestaurant_location(cursor.getString(4));
                food.setRestaurant_name(cursor.getString(5));

                foodList.add(food);
            } while (cursor.moveToNext());
        }

        // Return contact list
        return foodList;
    }

    public int getFoodCount() {
        String countQuery = "SELECT * FROM " + TABLE_FOOD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // Return number of food in database
        return count;
    }

    public int updateFood(Food contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getTitle());
        values.put(KEY_DESC, contact.getDescription());
        values.put(KEY_INGREDIENTS, contact.getIngredients());
        values.put(KEY_LOCATION_RESTAURANT, contact.getRestaurant_location());
        values.put(KEY_NAME_RESTAURANT, contact.getName_restaurant());

        // Update row
        return db.update(TABLE_FOOD, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
    }

    public void deleteAllFood() {
        String deleteQuery = "DELETE FROM " + TABLE_FOOD;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
        db.close();
    }

    public void deleteModel(Food contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FOOD, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        db.close();
    }
}
