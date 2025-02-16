package top.yumbo.excel.annotation.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表头注解，表示excel的表头占据多少行（后面都是数据）
 *
 * @author 诗水人间
 * @link 博客:{https://yumbo.blog.csdn.net/}
 * @link github:{https://github.com/1015770492}
 * @date 2021/9/1 22:04
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableHeader {
    /**
     * 表头的高度，默认表头高1行
     */
    int height() default 1;

    /**
     * 表名
     */
    String tableName() default "Sheet1";

    /**
     * 模板Excel的在线访问路径，用于导出功能。
     * 相当于获取到了模板数据后我们只需要往里面添加数据即可。
     * http/https协议的以协议名开头，例如: https://top.yumbo/excel/template/1.xlsx
     * 本地文件使用 path:// 开头即可。
     *      绝对路径示例->例如：path:///D:/excel/template/1.xlsx（模板excel文件要和程序在同一台服务器上才可以读取到文件流，否则建议使用http协议）
     *      相对路径示例->例如：path://templates/区域季度数据.xlsx （如果不打包成jar，要确认编译后的路径下有对于的模板文件，
     *      因此本地项目建议使用绝对路径作为测试）
     */
    String resource() default "";

    /**
     * excel的格式，xls于xlsx不兼容所致，默认xlsx
     */
    String type() default "xlsx";

    /**
     * 默认密码，可编辑/不可编辑单元格需要用到
     */
    String password() default "123456";
}
