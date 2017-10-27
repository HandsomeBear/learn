元注解：
	@Documented---指明有这个注解的元素可以被JavaDoc工具文档化
	@Target---指明该注解可以注解的程序元素范围，如果Target元注解没有出现，默认可以用于任何元素
		ElementType.TYPE:类，接口(包括注解)，枚举
		ElementType.FIELD:字段，枚举
		ElementType.METHOD:方法
		ElementType.PARAMETER:参数
		ElementType.CONSTRUCTOR:构造器
		ElementType.LOCAL_VARIABLE:局部变量
		ElementType.ANNOTATION_TYPE:注解
		ElementType.PACKAGE:包
	@Retention---指明了该Annotation被保留的时间长短
		RetentionPolicy.SOURCE:仅存在于源码
		RetentionPolicy.CLASS:默认的保留策略，注解会在class字节码文件中存在，但运行时无法获取
		RetentionPolicy.RUNTIME:注解会在class文件中存在，在运行时可以通过反射获取到
	@Inherited---说明子类可以继承父类中的该注解
	
一般使用情况：
	1.为编译期提供辅助信息---便于检测错误，一直警告等---@Override等
	2.编译源代码时进行额外操作---软件工具可以通过注解来生成源代码，xml文件等---注解处理器Annotation Processor
	3.在运行时被检测，使用---反射API操作注解
	
注解处理器：Annotation Processor
	1.基本概念：
		1.1 javac的一个工具它用来在编译时扫描和处理注解，你可以自定义注解，并注册相应的注解处理器
		1.2    一个注解的注解处理器，以Java代码(或者编译过的字节码)，作为输入，生成文件(通常是.java文件)作为输出
	2.AbstractProcessor
		2.1  每一个注解处理器都是继承于AbstractProcessor.
			2.1.1 public synchronized void init(ProcessingEnvironment env) {}
				每个注解处理器类都必须有一个空的构造函数。然而，这里有一个特殊的init()方法，他会被注册处理工具调用，并输入ProcessingEnvironment参数
				该参数提供很多有用的工具类Elements,Types,Filter.
			2.1.2 public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {}
				这相当于，每个处理器的main函数，你在这里写你的扫描，评估和处理注解的代码，以及生成java文件。输入参数RoundEnvironment，可以让你查询出
				包含特定注解的被注解元素。
			2.1.3 public Set<String> getSupportAnnotationTypes() {}
				必须指定，这个注解处理器是注册给哪些注解的。
			2.1.4 public SourceVersion getSupportSourceVersion() {}
				用来指定你使用的java版本。通常这里返回SourceVersion.latestSupported()。然而，如果你有足够的理由只支持Java6的话，你也可以返回
				SourceVersion.RELEASE_6.推荐使用前者。
		2.2  在Java7中，你也可以使用注解来替代getSupportAnnotationTypes()和getSupportSourceVersion()
			2.2.1 @SupportedSourceVersion(SourceVersion.latestSupported())
			2.2.2
				@SupportedAnnotationTypes({
   					// 合法注解全名的集合
 				})
 	3.注册你的处理器
 		必须提供一个.jar文件，你打包你的注解处理器到此文件中。并且在你的jar中，你需要打包一个特定的文件javax.annotation.processing.Processor到META-INF
 		.services路径下
 		打包进jar里javax.annotation.processing.Processor的内容是com.example.MyProcessor，多个以换行符分隔
	
动态代理

