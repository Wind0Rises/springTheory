##
## 一、单一类型的依赖查找
## 二、集合类型依赖查找
ListableBeanFactory：一种是查询Bean的名称，一种是查询Bean实例。
类的getBeansOfType(...)方法会进行初始化，会导致Bean的初始化不完全。
建议首先通过名称判断在通过类型判断。

## 内建可查找的依赖
| Bean名称 | Bean实例 | 使用场景 |
| ---- | ---- | ---- |
| environment | Environment对象 | 外部化配置以及Profiles | 
| systemProperties | java.util.Properties 对象 | Java系统属性 |
| systemEnvironment | java.util.Map 对象 | 操作系统环境变量 |
| messageSource | MessageSource 对象 | 国际化文案 |
| lifecycleProcessor | LifecycleProcessor 对象 | Lifecycle Bean 处理器 |
| applicationEventMulticaster | ApplicationEventMulticaster 对象| Spring事件广播 |

