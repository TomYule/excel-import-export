package top.yumbo.test.excel.importDemo;


import lombok.Data;
import top.yumbo.excel.annotation.core.TitleBind;
import top.yumbo.excel.annotation.core.TableHeader;
import top.yumbo.excel.enums.ExceptionMsg;
import top.yumbo.excel.util.BigDecimalUtils;
import java.math.BigDecimal;

/**
 * @author jinhua
 * @date 2021/5/19 16:39
 */
@Data
@TableHeader(height = 4, tableName = "区域年度数据")// 表头占4行
public class ImportForYear {


    /**
     * 地区代码，存储最末一级的地区代码就可以
     */
    @TitleBind(title = "地区", width = 2, exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION)
    private String regionCode;

    /**
     * 年份
     */
    @TitleBind(title = "年份", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION)
    private Integer year;

    /**
     * 地区GDP
     */
    @TitleBind(title = "地区GDP", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal regionGdp;

    /**
     * 地区人均GDP
     */
    @TitleBind(title = "地区人均GDP", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.TEN_THOUSAND_STRING)
    private BigDecimal regionGdpPerCapita;
    /**
     * 地区GDP在同级别地区排名
     */
    @TitleBind(title = "地区GDP在同级别地区排名", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION)
    private BigDecimal regionGdpRank;
    /**
     * 地区人均GDP在同级别地区排名
     */
    @TitleBind(title = "地区人均GDP在同级别地区排名", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = "0.01")
    private BigDecimal regionGdpPerCapitaRank;


    /**
     * GDP增速
     */
    @TitleBind(title = "GDP增速", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = "0.01")
    private BigDecimal regionGdpGrowth;

    /**
     * 二三产业合计对GDP贡献比例
     */
    @TitleBind(title = "二三产业合计对GDP贡献比例", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = "0.01")
    private BigDecimal industryContributeGdp;

    /**
     * 常住人口城镇化率
     */
    @TitleBind(title = "常住人口城镇化率", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = "0.01")
    private BigDecimal generalUrbanizationRate;

    /**
     * 城镇居民人均可支配收入
     */
    @TitleBind(title = "城镇居民人均可支配收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal enableIncomePerCapita;

    /**
     * 财政总收入
     */
    @TitleBind(title = "财政总收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal financeTotalIncome;

    /**
     * 综合财力
     */
    @TitleBind(title = "综合财力", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal comprehensiveFinance;

    /**
     * 一般预算收入
     */
    @TitleBind(title = "一般预算收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal generalBudgetIncome;

    /**
     * 税收收入
     */
    @TitleBind(title = "税收收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal taxIncome;

    /**
     * 非税收收入
     */
    @TitleBind(title = "非税收收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal nonTaxIncome;

    /**
     * 政府性基金收入
     */
    @TitleBind(title = "政府性基金收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal governmentFundIncome;

    /**
     * 上级补助收入
     */
    @TitleBind(title = "上级补助收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal superiorSubsidyIncome;

    /**
     * 返还性收入
     */
    @TitleBind(title = "返还性收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal returnIncome;

    /**
     * 一般性转移支付收入
     */
    @TitleBind(title = "一般性转移支付收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal generalTransferIncome;

    /**
     * 专项转移支付收入
     */
    @TitleBind(title = "专项转移支付收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal specialTransferIncome;

    /**
     * 财政总支出
     */
    @TitleBind(title = "财政总支出", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal financeTotalOutcome;

    /**
     * 一般预算支出
     */
    @TitleBind(title = "一般预算支出", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal generalBudgetOutcome;

    /**
     * 一般预算收入在同级别地区排名
     */
    @TitleBind(title = "一般预算收入在同级别地区排名", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = "0.01")
    private BigDecimal generalBudgetIncomeRank;
    /**
     * 财政总收入在同级别地区排名
     */
    @TitleBind(title = "财政总收入在同级别地区排名", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = "0.01")
    private BigDecimal totalIncomeRank;

    /**
     * 税收收入/一般预算收入
     */
    private BigDecimal calTaxDivGeneralIncome;
    /**
     * 一般预算支出/财政总支出
     */
    private BigDecimal calGeneralDivFinanceOutcome;
    /**
     * 一般预算收入/一般预算支出
     */
    private BigDecimal calGeneralIncomeDivOutcome;
    /**
     * 上级政府GDP
     */
    @TitleBind(title = "上级政府GDP", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal superiorGovernmentGdp;

    /**
     * 上级政府财政总收入
     */
    @TitleBind(title = "上级政府财政总收入", exception = ExceptionMsg.INCORRECT_FORMAT_EXCEPTION, size = BigDecimalUtils.ONE_HUNDRED_MILLION_STRING)
    private BigDecimal superiorGovernmentTotalIncome;


    /**
     * 地区GDP规模/上级政府GDP
     */
    private BigDecimal calRegionDivSuperiorGdp;

    /**
     * 地区财政总收入/上级政府总收入
     */
    private BigDecimal calFinanceIncomeRegionDivSuperior;

}
