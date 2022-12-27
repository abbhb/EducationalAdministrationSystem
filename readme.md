``安全检测功能： 修改密码的时候如果异常标识账号状态为异常,可以手动封禁``
# UserController
* (*)为needToken注解标记
* 登录-->/login-->post
* 手动检验token-->/login/checktoken-->post
* (*)安全退出（手动删除token）-->/logout-->get
* (*)更新用户信息-->/updataforuser-->post
* (*)修改用户密码-->/user/changepassword-->post
