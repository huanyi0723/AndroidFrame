package com.lifeix.androidbasecore;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import com.android.volley.util.VolleyManager;
import com.google.common.eventbus.EventBus;
import com.lifeix.androidbasecore.command.Response;
import com.lifeix.androidbasecore.command.Task;
import com.lifeix.androidbasecore.command.TaskManager;
import com.lifeix.androidbasecore.netstatus.NetworkStateReceiver;
import com.lifeix.androidbasecore.utils.PreferencesUtils;
import com.lifeix.androidbasecore.utils.StringUtils;
import com.lifeix.androidbasecore.utils.logger.LogLevel;
import com.lifeix.androidbasecore.utils.logger.Logger;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;

/**
 * 
 * @author KimHuang
 * 
 */
public abstract class BaseApplication extends Application {

	/******************** 网络处理类 ***********************/
	protected VolleyManager volleyManager;

	/********************* 图片加载框架 **************************/
	protected ImageLoader imageLoader;
	protected DisplayImageOptions displayImageOptionsCacheInMemory;
	protected DisplayImageOptions displayImageOptionsCacheInDisk;
	protected DisplayImageOptions displayImageOptionsCacheBoth;

	/******************* GreenDao相关 *******************/
	protected SQLiteDatabase readableDB;
	protected SQLiteDatabase writableDB;

	protected AbstractDaoMaster daoMasterReadable;
	protected AbstractDaoSession daoSessionReadble;

	protected AbstractDaoMaster daoMasterWritable;
	protected AbstractDaoSession daoSessionWritable;

	protected TaskManager taskManager;

	protected EventBus eventBus;

	protected static BaseApplication INSTANCE;

	public static BaseApplication getInstance() {
		return INSTANCE;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		init();
		INSTANCE = this;
	}

	private void init() {
		initDB();
		registerNetStatusChangeReceiver();
		initNetProccessManager();
		initImageLoader();
		initDisplayImageOptions();
		initTaskManager();
		initEventBus();
		initLogger();
	}

	private void initImageLoader() {
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				this).threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.diskCacheSize(50 * 1024 * 1024)
				// 50 Mb
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.writeDebugLogs() // Remove for release app
				.build();
		imageLoader = ImageLoader.getInstance();
		imageLoader.init(config);
	}

	private void initDisplayImageOptions() {
		displayImageOptionsCacheInMemory = generateDisplayImageOptions(true,
				false, 0, 0, 0);
		displayImageOptionsCacheInDisk = generateDisplayImageOptions(false,
				true, 0, 0, 0);
		displayImageOptionsCacheBoth = generateDisplayImageOptions(true, true,
				0, 0, 0);
	}

	private DisplayImageOptions generateDisplayImageOptions(
			boolean cacheMomory, boolean cacheDisk, int imageLoading,
			int imageUriEmpty, int loadFailed) {
		DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
				.showImageOnLoading(imageLoading)
				.showImageForEmptyUri(imageUriEmpty)
				.showImageOnFail(loadFailed).cacheInMemory(cacheMomory)
				.cacheOnDisk(cacheDisk).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565).build();
		return displayImageOptions;
	}

	private void initNetProccessManager() {
		volleyManager = VolleyManager.getInstance(this);
	}

	public void registerNetStatusChangeReceiver() {
		NetworkStateReceiver.registerNetworkStateReceiver(this);
	}

	private void initTaskManager() {
		taskManager = TaskManager.getInstance();
		taskManager.start();
	}

	private void initEventBus() {
		eventBus = new EventBus();
	}

	protected void initLogger() {
		Logger.init(getClass().getSimpleName()).setLogLevel(LogLevel.FULL)
				.needFileLog(this);
	}

	public abstract void initDB();

	// {
	// // 测试
	// DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db",
	// null);
	// // 正式
	// // OpenHelper helper = new DaoMaster.OpenHelper(this, "notes-db", null)
	// // {
	// //
	// // @Override
	// // public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
	// // // TODO Auto-generated method stub
	// // DaoMaster.dropAllTables(db, true);
	// // }
	// // };
	// readableDB = helper.getReadableDatabase();
	// writableDB = helper.getWritableDatabase();
	//
	// daoMasterReadable = new DaoMaster(readableDB);
	// daoSessionReadble = daoMasterReadable.newSession();
	//
	// daoMasterWritable = new DaoMaster(writableDB);
	// daoSessionWritable = daoMasterWritable.newSession();
	// }

	public AbstractDaoSession getDaoSessionReadble() {
		return daoSessionReadble;
	}

	public AbstractDaoSession getDaoSessionWritable() {
		return daoSessionWritable;
	}

	public AbstractDaoMaster getDaoMasterWritable() {
		return daoMasterWritable;
	}

	public AbstractDaoMaster getDaoMasterReadable() {
		return daoMasterReadable;
	}

	public VolleyManager getVolleyManager() {
		return volleyManager;
	}

	public ImageLoader getImageLoader() {
		return imageLoader;
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	public DisplayImageOptions getDisplayImageOptionsCacheInMemory() {
		return displayImageOptionsCacheInMemory;
	}

	public DisplayImageOptions getDisplayImageOptionsCacheInDisk() {
		return displayImageOptionsCacheInDisk;
	}

	public DisplayImageOptions getDisplayImageOptionsCacheBoth() {
		return displayImageOptionsCacheBoth;
	}

	public TaskManager getTaskManager() {
		return taskManager;
	}

	public void sendTask(Task<Response> task) {
		taskManager.add(task);
	}

	/**
	 * 结束任务队列
	 */
	public void stopTaskQuenen() {
		if (taskManager != null) {
			taskManager.stop();
		}
	}

	/**
	 * 取消任务
	 * 
	 * @param task
	 */
	public void cancelTask(Task<?> task) {
		cancelTask(task.getId());
	}

	/**
	 * 取消任务
	 * 
	 * @param task
	 */
	public void cancelTask(String taskId) {
		if (taskManager != null && !taskManager.isStop()) {
			taskManager.cancelTask(taskId);
		}
	}

	/**
	 * 取消任务
	 * 
	 * @param task
	 */
	public void cancelTaskEvenInExecutting(Task<?> task) {
		if (taskManager != null && !taskManager.isStop()) {
			taskManager.cancelTaskEvenInExecution(task);
		}
	}

	/**
	 * 取消任务
	 * 
	 * @param taskId
	 */
	public void cancelTaskEvenInExecutting(String taskId) {
		if (taskManager != null && !taskManager.isStop()) {
			taskManager.cancelTaskEvenInExecution(taskId);
		}
	}

	/**
	 * default preference file named "lifeix"
	 * 
	 * @return
	 */
	public PreferencesUtils getPreference() {
		return PreferencesUtils.getPreferenceConfig(this);
	}

	/**
	 * get preference file named @param preFileName
	 * 
	 * @param preFileName
	 * @return
	 */
	public PreferencesUtils getPreference(String preFileName) {
		PreferencesUtils preferencesUtils = PreferencesUtils
				.getPreferenceConfig(this);
		preferencesUtils.loadConfig(preFileName);
		return preferencesUtils;
	}
}
