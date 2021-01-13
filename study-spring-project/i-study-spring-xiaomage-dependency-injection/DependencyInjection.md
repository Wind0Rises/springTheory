# 依赖注入
## 一、依赖注入
### 1.1 注入方式
* 手动注入：XML资源配置元信息、Java注解配置元信息、API配置元信息
* 自动注入：Autowiring自动绑定

### 1.2 依赖注入的类型
* Setter方法注入：<property name="user" ref="userBean"
* 构造器注入：<constructor name="user" ref="userBean" ..
* 字段：@Autowiring User user;
* 方法：@Autowiring public void User(User user) {...}
* 接口回调：class MyBean implements BeanFactoryAware {...}

### 1.3 自动绑定的模式
* no
* byName：
* byType：
* constructor：