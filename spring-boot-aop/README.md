#### spring boot aop的简单示例  
##### 1、添加依赖

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```
##### 2、编写切面类  
使用 @Component，@Aspect 标记到切面类上  
##### 3、常用注解  
3.1、`@Pointcut` 切入点规则  
指在程序执行过程中某个特定的点，比如某方法调用的时候或者处理异常的时候  
  
3.2、通知（`Advice`）：指在切面的某个特定的连接点上执行的动作。Spring切面可以应用5中通知：  
- 前置通知（`@Before`）:在目标方法或者说连接点被调用前执行的通知；  
- 后置通知（`@After`）：指在某个连接点完成后执行的通知；  
- 返回通知（`@After-returning`）：指在某个连接点成功执行之后执行的通知；  
- 异常通知（`@After-throwing`）：指在方法抛出异常后执行的通知；  
- 环绕通知（`@Around`）：指包围一个连接点通知，在被通知的方法调用之前和之后执行自定义的方法。  
在springAOP中有五种通知，环绕通知是最为强大的通知。它能够让你编写的逻辑将被通知的目标方法完全包装起来。实际上就像在一个通知方法中同时编写前置通知和后置通知。一般也是用 `@Around`  
##### 4、常用切入点规则  

```
execution(public * *(..)) //任意的公共方法  
execution(* set*(..)) //以set开头的任意方法  
execution(* com.naruto.controller.SampleController.*(..))  //SampleController类所有方法  
execution(* com.naruto.controller.*.*(..)) //com.naruto.controller包下所有类的所有方法  
execution(* com.naruto.controller..*.*(..)) //com.naruto.controller包及其子包所有类的所有方法  
@annotation(org.springframework.web.bind.annotation.RequestMapping) //标注了RequestMapping注解的方法
```
多个规则可以在通知类注解上面加上 `&&` 和 `||`