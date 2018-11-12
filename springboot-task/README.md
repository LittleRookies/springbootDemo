# springboot 异步任务、定时任务、邮件任务

### 异步任务

1. 在方法上加注`@Async`注解。
2. 在启动类中使用`@EnableAsync`开始异步任务。

### 定时任务

1. 在方法上加注`@Scheduled(cron = "")`注解。

   ```java
   /**
        * second(秒), minute（分）, hour（时）, day of month（日）, month（月）, day of week（周几）.
        * 0 * * * * MON-FRI
        * 【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
        * 【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
        * 【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
        * 【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次
        * 【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
        */
   ```

2. 在启动类中使用`@EnableScheduling`开启定时任务。

### 邮件任务

1. pom.xml中引入jar包

   ```xml
   <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-mail</artifactId>
           </dependency>
   ```

2. 在`application.properties`配置账号、密码、服务、是否ssl认证。

   ```properties
   spring.mail.username=
   spring.mail.password=        #这里不是添邮箱的登录密码而是授权码
   spring.mail.host=smtp.qq.com #qq服务
   spring.mail.properties.mail.smtp.ssl.enable=true
   ```

3. 发送邮件

   ```java
   public void mail() {
           SimpleMailMessage message = new SimpleMailMessage();
           //邮件设置
           message.setSubject("通知");
           message.setText("集合");
   
           message.setTo("");//邮件接收者
           message.setFrom("");//邮件发送者
   
           mailSender.send(message);
       }
   
   
       public void mail01() throws Exception {
           //1、创建一个复杂的消息邮件
           MimeMessage mimeMessage = mailSender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
   
           //邮件设置
           helper.setSubject("通知");
           helper.setText("<b style='color:red'>今天集合</b>", true);
   
           helper.setTo("");
           helper.setFrom("");
   
           //上传文件
           helper.addAttachment("1.jpg", new File("/Users/apple/Downloads/我的电脑/壁纸/2.jpg"));
           helper.addAttachment("2.jpg", new File("/Users/apple/Downloads/我的电脑/壁纸/1.jpg"));
   
           mailSender.send(mimeMessage);
   
       }
   ```
