package com.lifeix.androidbasecoredemo;

import org.androidannotations.annotations.EApplication;

import com.lifeix.androidbasecore.BaseApplication;

import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.db.DaoMaster;
import de.greenrobot.db.DaoMaster.DevOpenHelper;
import de.greenrobot.db.DaoSession;

@EApplication
public class DemoApplication extends BaseApplication {

	@Override
	public void initDB() {
		// 测试
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db",
				null);
		// 正式
		// OpenHelper helper = new DaoMaster.OpenHelper(this, "notes-db",
		// null)
		// {
		//
		// @Override
		// public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// // TODO Auto-generated method stub
		// DaoMaster.dropAllTables(db, true);
		// }
		// };
		readableDB = helper.getReadableDatabase();
		writableDB = helper.getWritableDatabase();

		daoMasterReadable = new DaoMaster(readableDB);
		daoSessionReadble = daoMasterReadable.newSession();

		daoMasterWritable = new DaoMaster(writableDB);
		daoSessionWritable = daoMasterWritable.newSession();
	}

	public DaoSession getDaoSessionReadble() {
		return (DaoSession) daoSessionReadble;
	}

	public DaoSession getDaoSessionWritable() {
		return (DaoSession) daoSessionWritable;
	}

	public AbstractDaoMaster getDaoMasterWritable() {
		return daoMasterWritable;
	}

	public AbstractDaoMaster getDaoMasterReadable() {
		return daoMasterReadable;
	}
}
