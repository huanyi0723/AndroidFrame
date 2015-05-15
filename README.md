##  android快速开发框架的使用
AndroidAnnotation使用指南
	http://www.evernote.com/l/ALr1XiQXoutAUp71WtIrcLhLV2PL92SUahs/
Android公共框架结构文档
	http://www.evernote.com/l/ALoM6uhs_5FKH4J1XL8gSfIZI9qzplSP_YM/

## AndroidAnnotation使用指南
JavaEE中有Spring框架用来做IOC，Android中也有依赖注入的框架。如Butterknife，Dagger，AndroidAnnotation，RoboGuice，ThinkAndroid等。网络上有很多关于这几个框架的对比，
现在我们先说一下各个框架的特性：
1 Butterknife：一个android视图注入框架。
2 Dagger：一个Android平台注入框架，对视图的注入支持弱
          1.使用JSR-330标准注解进行构造器注入
          2.使用@Provides注解创建对象
          3.昂贵资源延迟注入
          4.编译时验证
3 RoboGuice：Android平台上基于Google Guice开发的一个库。
          1.方便findViewById，并将其强制转换
          2.自动处理一些异常
 4 ThinkAndroid：视图注入和对象初始化（需无参构造函数）
 5 AndroidAnnotation：
          1. 依赖注入：包括view，extras，系统服务，资源等等
          2. 简单的线程模型，通过annotation表示方法运行在ui线程还是后台线程
          3. 事件绑定：通过annotation表示view的响应事件，不用在写内部类
          4. REST客户端：定义客户端接口，自动生成REST请求的实现
          5. 没有你想象的复杂：AndroidAnnotations只是在在编译时生成相应子类
          6. 不影响应用性能：仅50kb，在编译时完成，不会对运行时有性能影响。

		  对比：
          butterknife 利用annotation帮你快速完成View的初始化，减少代码
          Dagger 依赖注入，适用于Android和Java。编译时生成对应辅助类
          Roboguice通过运行时读取annotations进行反射，影响应用性能
          ThinkAndroid使用反射技术实现，影响性能
          AndroidAnnotations综合了其他的几个框架的优点，在编译的时候，将相应的注解进行转换，生成对应类。
		  AndroidAnnotatios的缺点是，生成的对应类会在类名末尾加“_”，AndroidManifest.xml中配置需对应修改。
		  
## Android项目如何使用AndroidAnnotations框架（Eclipse环境）
1 添加AndroidAnnoations Jar包，
	创建compile-libs，放入androidannotations-3.2.jar，
	在libs下放入androidannotation-api-3.2.jar.
2 右键选择项目->Properties
	Annotation Processing插件 如果没有需要安装 http://download.eclipse.org/releases/juno 
	勾选"Enable project specific settings"，将如图所示“.apt_generated"改为”src-gen"。该文字即为androidannotations注解生成类所在目录的名称，若以“."开头则Eclipse不会显示该目录。
	接下来选择”Factory Path“，并勾选”Enable project specific settings"，点击“Add JARS...”  添加compile-libs下androidannotation-3.2.jar
3  使用Eclipse的Export->Export Android Application方式生成apk文件时，发现apk包无法安装，安装程序报“文件解析错误” 的解决办法

## Android公共框架结构文档
1 AndroidBaseCore项目
com.lifeix.androidbasecore
	command //任务处理模块
		通过TaskManager.getInstance()获取任务管理器实例，add(Task<Response>)添加任务到任务执行队列
		在项目开发中，具体业务的task应继承TaskBase并实现execute方法，在execute方法中，执行具体的业务，并回调结果。具体请参考TaskCounter.java。
		整个任务处理模块是一个生产~消费模型，核心逻辑请参考TaskQueue.java和TaskDispatcher.java。
	download //下载模块
		  因Volley主要处理小数据量网络请求，且不能友好反馈网络处理进度，故引进ThinkAndroid中的文件下载模块。
          通过DownloadManager.getDownloadManager()获取下载器实例，默认下载目录为Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "lifeix/"。
          通过DownloadManager.getDownloadManager(String)自定义下载目录
          addHandler(String)：添加一个下载任务，参数为文件下载地址
          setDownloadCallBack(DownloadCallback)：设置下载回调监听，一个下载器只有一个下载回调监听
          DownloadCallback如下，继承自Handler，一般需重写红色框中的方法。且这些方法均在handleMessae中被调用，即这些方法体中可直接更新UI。
		  setDownloadThreadSize(int)：设置并发下载线程数量
	netstatus //网络监听模块
	utils //工具类 log日志打印类
	BaseApplication
		 在BaseApplication的onCreate方法中，执行了init操作，包括图片加载器的初始化（和图片缓存策略初始化设置）、网络监听器初始化、任务处理器初始化、事件分发（EventBus）初始化、日志管理器初始化
		 和数据库初始化。并且开放对应实例的get接口。另外，提供了任务处理器更便捷的接口，如发送任务、取消任务、停止任务管理器、SharePreference实例获取，网络状态监听等。
		 可以通过BaseApplication.getInstance()获取该实例。注意，在实际开发中，XXXApplication继承该类后，必须实现initDB()方法，根据项目实际需求实现逻辑。
	BaseFragment
		
	BaseFragmentActivity
		 BaseFragment.java继承android.support.v4.app.FragmentActivity，并实现com.lifeix.androidbasecore.netstatus.NetChangeObserver网络监听接口。项目开发中，Activity应该继承该类。
		 若Activity需要监听网络状态变化，调用方法registerNetChangeListener()，并重写方法onConnect(NetType)和onDisconnect()，调用方法unRegisterNetChangeListener()取消网络状态监听。
		 getDaoSession():获取数据库Dao管理器，可通过DaoSession获取实例的对应dao进行数据库增删改查等操作。
		 doCommand(Task<Response>):执行任务，将耗时或复杂操作封装到Task中，添加到任务处理器中执行，并回调结果刷新UI，实现业务逻辑和页面的分离
		 sendNetReqeust(Request<T>):发送网络请求
		 BaseFragment.java 与BaseFragmentActivity类似
		 BaseFragmentActivity和BaseFragment都已整合友盟数据统计功能
Jar包部分
	gson.jar //改良的json~bean映射工具包，支持value为null的情况。git仓库地址：https://github.com/google/gson.git
	guava-18.0.jar //google为java工程做的核心库，包括集合、缓存、IO等。git仓库地址：https://github.com/google/guava.git
	httpmime-4.1.3.jar //DownloadManager模块支撑包
	lib-greendaocore.jar //GreenDao数据库处理框架核心包。 git仓库地址：https://github.com/greenrobot/greenDAO.git
	org.springframework.core-3.1.0.M1.jar //guava支持包，后续考虑简化可能
	umeng-analytics-v5.4.2.jar //友盟统计jar包
	universalimageloader.jar //图片加载框架。 git仓库地址：https://github.com/nostra13/Android-Universal-Image-Loader.git
	volley.jar //网络请求处理框架。 git仓库地址：https://github.com/mcxiaoke/android-volley.git

2 AndroidBaseWidgetCore项目 //常用控件 特效动画

3 AndroidBaseCoreDemo //示例Demo

4 android-support-v7-appcompat
5 cardview































