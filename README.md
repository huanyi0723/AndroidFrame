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

































