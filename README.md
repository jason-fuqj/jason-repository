# jason-repository操作说明
项目描述：完成一个图书管理系统，包含对图书的增、删、改、查功能。<p>
1、开发工具：IntelliJ IDEA<p>
2、技术框架：
    springboot,
    mybatis,
    Shiro,
    Redis,
    Swagger2
    <p>
3、数据库：
    mysql
    <p>
4、使用步骤：<p>
    (1)从Github上拉取项目到本地<p>
    (2)执行初始化数据库脚本，脚本位于resources/sql目录下的bookdb.sql<p>
    (3)修改数据库配置信息，位置位于application-xxx.properties<p>
    (4)修改Redis配置信息，位置位于application-xxx.properties<p>
    (5)启动项目，运行BookApplication.java类<p>
5、打开浏览器，输入：localhost:8080/swagger-ui.html，打开swagger页面<p>
6、点击页面上的【Authorize】按钮，输入需要认证的token信息“Authorization”<p>
7、测试账号：<p>
    管理员：admin/123456，
    普通用户：jason/123456<p>
说明：<p>
    1、由于我本地安装H2数据库一直连接不上，最后改用mysql数据库，还请见谅。<p>
    2、由于时间关系，有些功能还未完善。<p>
    3、部署过程中如有任何问题，欢迎电话联系。<p>