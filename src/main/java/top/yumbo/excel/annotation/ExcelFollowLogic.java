package top.yumbo.excel.annotation;


import java.lang.annotation.*;

/**
 * @author jinhua
 * @date 2021/5/21 15:53
 * excel主逻辑注解，用于标注主逻辑字段
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ExcelFollowLogics.class)
public @interface ExcelFollowLogic {

    /**
     * 从逻辑
     */
    String value() default "0";
}
