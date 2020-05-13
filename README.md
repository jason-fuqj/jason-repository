# jason-repository
项目描述：搭建一个图书管理系统，实现功能是后端管理功能
1、开发工具：IntelliJ IDEA
2、技术框架：
    springboot,
    mybatis,
    Shiro,
    Swagger2
3、数据库：
    mysql
4、使用步骤：
    (1)从Github上拉取项目到本地
    (2)执行初始化数据库脚本，脚本位于resources/sql目录下的bookdb.sql
    (3)修改数据库配置，修改application-xxx.properties
    (4)启动项目，运行BookApplication.java类
5、打开浏览器，输入：localhost:8080/swagger-ui.html，打开swagger页面
6、点击页面上的【Authorize】按钮，输入需要认证的token信息“Authorization”
7、开始访问对应的接口

说明：
    1、由于我本地安装H2数据库一直连接不上，最后改用mysql数据库，还请见谅。
    2、由于时间关系，有些功能还未完善。
    3、部署过程中如有任何问题，欢迎电话联系。