package IMFramework;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class IDatabaseHandler extends SQLiteOpenHelper {
  private static final int DB_VERSION = 1;
  private static final String DB_NAME = "partDB";
  private static final String TABLE_NAME_KALA = "tblKala";
  private static final String TABLE_NAME_SELL = "tblSell";
  private static final String KEY_ID = "id";
  private static final String KEY_ID_KALA = "idKala";
  private static final String KEY_NAME = "name";
  private static final String KEY_FI = "fi";
  private static final String KEY_FI_MAYE = "fiMaye";
  private static final String KEY_OFFER = "offer";
  private static final String KEY_COUNT = "countK";
  private static final String KEY_PRICE_NO_OFFER = "priceNoOffer";
  private static final String KEY_PRICE_OFFER = "priceOffer";
  private static final String KEY_PROFIT = "profit";




  public IDatabaseHandler(@Nullable Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

    String CREATE_TABLE_KALA = "CREATE TABLE " + TABLE_NAME_KALA + "("
      + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
      + KEY_ID_KALA + " INTEGER,"
      + KEY_NAME + " TEXT,"
      + KEY_FI + " INTEGER,"
      + KEY_FI_MAYE + " INTEGER,"
      + KEY_OFFER + " INTEGER"
      + ")";

    String CREATE_TABLE_SELL = "CREATE TABLE " + TABLE_NAME_SELL + "("
      + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
      + KEY_ID_KALA + " INTEGER,"
      + KEY_NAME + " TEXT,"
      + KEY_FI + " INTEGER,"
      + KEY_FI_MAYE + " INTEGER,"
      + KEY_OFFER + " INTEGER,"
      + KEY_COUNT + " INTEGER,"
      + KEY_PRICE_NO_OFFER + " INTEGER,"
      + KEY_PRICE_OFFER + " INTEGER,"
      + KEY_PROFIT + " INTEGER"
      + ")";






    db.execSQL(CREATE_TABLE_KALA);
    db.execSQL(CREATE_TABLE_SELL);

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_KALA);
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SELL);
    onCreate(db);
  }

  public void insertData() {

  }

  public void searchData() {

  }

  public void updateData() {

  }

  public void deleteData() {


  }

  public void deleteAllData() {

  }




}
