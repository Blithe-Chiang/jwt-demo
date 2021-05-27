# jwt-demo



## 基本功能: 

* 使用JWT实现的简单的认证demo
* 解决了跨域

## 接口的介绍：

### `/token`接口:

* 访问此接口可以获得JWT

* 需要提供参数`username`

#### 获得JWT实例

![image-20210527215656261](https://gitee.com/Blithe-Chiang/pic-go-repo/raw/master/img/2021/05/27/image-20210527215656261.png)

### `/hello`接口: 

* 访问 `/hello` 的时候，需要在header中携带 JWT。如果没有携带的话，会返回错误信息。
* 访问此接口的时候，它会根据已经认证的用户，返回一个问候字符串

#### 未携带JWT

![image-20210527215835510](https://gitee.com/Blithe-Chiang/pic-go-repo/raw/master/img/2021/05/27/image-20210527215835510.png)

#### 携带JWT

![image-20210527220033572](https://gitee.com/Blithe-Chiang/pic-go-repo/raw/master/img/2021/05/27/image-20210527220033572.png)





## 致谢：

此demo的代码基本来自

[songboriceman/doubao_community_backend: 手把手vue+springboot前后端分离项目实战---豆宝社区项目后端代码 (github.com)](https://github.com/songboriceman/doubao_community_backend) 