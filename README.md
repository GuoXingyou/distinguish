#   1、包结构
##  1.1、所有包格式
    com.xjy.项目简称.大模块(.小模块).功能结构包
    大模块(.小模块)：如，goods.sku
##  1.2、功能结构包
### 1.2.1、可统一放置的包
    utils：模块内的一些通用操作
    enums：模块内用到的枚举
    cache：模块内缓存相关
### 1.2.2、模块下的功能结构包（下面仅直接放类）
    entity：实体
    repository：数据库资源访问相关，继承BaseRepository<M, ID>，命名*Repository；
        如果扩展复杂查询，则新建*RepositoryImpl，并添加实现方法，同时将该方法接口加入到*Repository中
    service：业务逻辑操作，需要事务时添加注解@Transactional；
        继承BaseService<M, ID>，直接命名*Service且实现方法写在里面，不需要拆分出接口、实现类
    facade：调用多个service处理后，对外提供的方法（该包下面仅调用其他service，命名*Facade，实现类*FacadeImpl）
    task：定时任务等相关（该包下面仅调用其他service）
    dto：service层对外提供的对象（与entity一样时，可不建）
    web：与请求相关的操作放在该包下，如web.bind（实体转换）
    web.controller：控制层操作
    web.vto：控制层传输给前台的对象（与entity、dto均不一样时，才需要创建转换）
## 1.3、数据库表名
    最好按照【大模块-小模块】这样的方式命名，可多级，不需要表名前面加一个字母，一个字母也不太清楚含义