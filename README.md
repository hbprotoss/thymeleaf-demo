#thymeleaf demo

## 模板使用

主文件index.html

### 方法一、静态页面引用

index.html中引用"直接引用静态页面"注释部分, 直接使用thymeleaf的fragment和replace/include语句引用模板(webapp/views/common/), 模板中的变量需要在使用者的controller中定义

### 方法二、自定义标签引用

index.html中"引用自定义element tag"部分, 使用thymeleaf的dialect自定义标签。页面模板(webapp/WEB-INF/tempates/)必须在WEB-INF目录下,否则运行时读取不到。逻辑位于`io.hbprotoss.thymeleaf.dialect`下,定义了`gt`大标签,相当于`th`这个默认标签。定义了header, footer, nav元素。

可以参考demo中的HeaderElementTagProcessor,有动态数据获取部分。

自定义属性可以参考EchoAttributeTagProcessor