# SpringBoot 配置druid

**application.yml配置文件**



```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&connectionCollation=utf8_general_ci&characterSetResults=utf8&zeroDateTimeBehavior=convertToNull
    username: root
    password: 123456
    druid:
      # 配置监控统计拦截的filters，去掉后监控界面sql无法统计
      filters: stat,wall
      # 初始化时建立物理连接的个数
      initial-size: 5
      # 最大连接池数量
      max-active: 30
      # 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
      max-pool-prepared-statement-per-connection-size: 50
      # 获取连接时最大等待时间，单位毫秒
      max-wait: 60000
      # 连接保持空闲而不被驱逐的最小时间
      min-evictable-idle-time-millis: 300000
      # 最小连接池数量
      min-idle: 5
      # 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
      pool-prepared-statements: true
      # 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
      test-on-borrow: false
      # 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
      test-on-return: false
      # 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
      test-while-idle: true
      # 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
      time-between-eviction-runs-millis: 60000
      # 合并多个DruidDataSource的监控数据
      use-global-data-source-stat: true
      # 用来检测连接是否有效的sql，要求是一个查询语句
      validation-query: SELECT 1 FROM DUAL
      # druid连接池监控
      stat-view-servlet:
        # 用户名
        login-username: admin
        # 密码
        login-password: 123
        # 允许访问（默认或者空代表所有人）
        allow: ""
        # 禁止访问
        deny: "10.1.255.213"
      # 排除一些静态资源，以提高效率
      web-stat-filter:
        exclusions: '*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*'

```

**druid监控**

1. 通过application.yml配置
2. 使用springbootdruid/config/DruidConfig.java。