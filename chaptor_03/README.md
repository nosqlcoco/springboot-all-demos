#### springboot之自定义properties配置文件

1. 使用@PropertySource导入properties文件(必不可少)
2. 使用@Value读取properties属性
3. 使用@ConfigurationProperties将properties绑定到一个类上
4. 使用@EnableConfigurationProperties导入peroperties对应的类(第3点)