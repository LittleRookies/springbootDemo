# spirngboot+shiro+jpa

shiro中默认的过滤器

| 过滤器名称        | 过滤器类                                                     | 描述                                                     |
| ----------------- | ------------------------------------------------------------ | -------------------------------------------------------- |
| anon              | [org.apache.shiro.web.filter.authc.AnonymousFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authc/AnonymousFilter.html) | 匿名过滤器                                               |
| authc             | [org.apache.shiro.web.filter.authc.FormAuthenticationFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authc/FormAuthenticationFilter.html) | 如果继续操作，需要做对应的表单验证否则不能通过           |
| authcBasic        | [org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authc/BasicHttpAuthenticationFilter.html) | 基本http验证过滤，如果不通过，跳转屋登录页面             |
| logout            | [org.apache.shiro.web.filter.authc.LogoutFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authc/LogoutFilter.html) | 登录退出过滤器                                           |
| noSessionCreation | [org.apache.shiro.web.filter.session.NoSessionCreationFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/session/NoSessionCreationFilter.html) | 没有session创建过滤器                                    |
| perms             | [org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authz/PermissionsAuthorizationFilter.html) | 权限过滤器                                               |
| port              | [org.apache.shiro.web.filter.authz.PortFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authz/PortFilter.html) | 端口过滤器，可以设置是否是指定端口如果不是跳转到登录页面 |
| rest              | [org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authz/HttpMethodPermissionFilter.html) | http方法过滤器，可以指定如post不能进行访问等             |
| roles             | [org.apache.shiro.web.filter.authz.RolesAuthorizationFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authz/RolesAuthorizationFilter.html) | 角色过滤器，判断当前用户是否指定角色                     |
| ssl               | [org.apache.shiro.web.filter.authz.SslFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authz/SslFilter.html) | 请求需要通过ssl，如果不是跳转回登录页                    |
| user              | [org.apache.shiro.web.filter.authc.UserFilter](http://shiro.apache.org/static/current/apidocs/org/apache/shiro/web/filter/authc/UserFilter.html) | 如果访问一个已知用户，比如记住我功能，走这个过滤器       |