package com.nyp.sit.dit.it2107.mycontactsdatabase;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 154406F on 12/1/2016.
 */

public class MyContacts extends Application{
    private List<String> contactList;
    private List<Integer> contactIdList;
    private static MyContacts ourInstance = new MyContacts();

    public MyContacts() {
        contactList = new ArrayList<String>();
        contactIdList = new ArrayList<Integer>();
    }
    public static MyContacts getInstance(){
        return ourInstance;
    }
    public long addToDatabase(String entryName,String entryTel,Context c){
        MyDbAdapter db = new MyDbAdapter(c);
        db.open();

        long rowIDofInsertedEntry = db.insertEntry(entryName,entryTel);
        db.close();
        return rowIDofInsertedEntry;
    }
    public boolean deleteFrmDatabase(int rowID , Context c){
        MyDbAdapter db = new MyDbAdapter(c);
        db.open();
        int id = contactIdList.get(rowID);
        boolean updateStatus = db.removeEntry(id);
        db.close();;
        return updateStatus;
    }
    public List<String> retrieveAll(Context c) {
        Cursor myCursor;
        String myString = "";
        MyDbAdapter db = new MyDbAdapter(c);
        db.open();
        contactIdList.clear();
        contactList.clear();
        myCursor = db.retrieveAllEntriesCursor();
        if(myCursor != null && myCursor.getCount()>0)
        {
            myCursor.moveToFirst();
            do{
                contactIdList.add(myCursor.getInt(db.COLUMN_KEY_ID));
                myString = myCursor.getString(db.COLUMN_NAME_ID)+"-"+myCursor.getString(db.COLUMN_TEL_ID)+"\n";
                contactList.add(myString);
            }while(myCursor.moveToNext());
        }
        db.close();
        return contactList;
    }

}
