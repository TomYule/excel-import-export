package top.yumbo.test.excel.exportDemo;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import top.yumbo.excel.entity.CellStyleBuilder;
import top.yumbo.excel.util.ExcelImportExportUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author jinhua
 * @date 2021/5/28 14:28
 */
public class ExportExcelDemo {

    public static void main(String[] args) throws Exception {
        /**
         * 得到List集合
         */
        System.out.println("=====导入季度数据======");
        String areaQuarter = "src/test/java/top/yumbo/test/excel/2_1.xlsx";
        final List<ExportForQuarter> quarterList = ExcelImportExportUtils.importExcel(new FileInputStream(areaQuarter), ExportForQuarter.class, "xlsx");

        /**
         * 将其导出
         */
        if (quarterList != null) {
            quarterList.forEach(System.out::println);
            // 将数据导出到本地文件,如果要导出到web暴露出去只要传入输出流即可
            /**
             * 原样式导出
             */
            ExcelImportExportUtils.exportExcel(quarterList, new FileOutputStream("D:/季度数据-原样式导出.xlsx"));
            /**
             * 高亮行
             */
            ExcelImportExportUtils.exportExcelRowHighLight(quarterList,
                    new FileOutputStream("D:/季度数据-高亮行导出.xlsx"),
                    (t) -> {
                        if (t.getQuarter() == 1) {
                            return IndexedColors.YELLOW;
                        } else if (t.getQuarter() == 2) {
                            return IndexedColors.ROSE;
                        } else if (t.getQuarter() == 3) {
                            return IndexedColors.SKY_BLUE;
                        } else if (t.getQuarter() == 4) {
                            return IndexedColors.GREY_25_PERCENT;
                        } else {
                            return IndexedColors.WHITE;
                        }
                    });
//            ExcelImportExportUtils.exportExcelRowHighLightRGBColor(quarterList, new FileOutputStream("D:/季度数据-自定义颜色高亮行导出.xlsx"),
//                    (t) -> {
//                        return null;
//                    });
        }
        /**
         * 行高亮并且符合条件的单元格高亮
         */
//        rowHighLight(quarterList);
//        rowHighLight(quarterList);

    }

    /**
     * 高亮行（断言方式高亮示例代码）
     * 高亮符合条件的行
     */
    private static void rowHighLight(List<ExportForQuarter> quarterList) throws Exception {
        quarterList.forEach(System.out::println);
        /**
         * 某些行高亮展示，字体等其他样式继续进行链式调用即可设置
         */
        // 3种样式
        final List<CellStyle> cellStyleList = Arrays.asList(
                CellStyleBuilder.builder().foregroundColor(51).fontName("微软雅黑").build().getCellStyle(),// 灰色
                CellStyleBuilder.builder().foregroundColor(12).build().getCellStyle(),// 蓝色
                CellStyleBuilder.builder().foregroundColor(13).build().getCellStyle(),// 黄色
                CellStyleBuilder.builder().foregroundColor(17).build().getCellStyle(),// 绿色
                CellStyleBuilder.builder().build().getCellStyle()// 绿色
        );
        // 根据逻辑得到样式的下标,
        // 例如：技术违约->黄色背景，实质违约->灰色背景，管理违约->蓝色背景
        final Function<ExportForQuarter, Integer> functional = (one) -> {
            if ("管理失误违约".equals(one.getRiskNature())) {
                // 管理失误违约的用蓝色高亮
                return 1;
            } else if ("标准债券".equals(one.getRiskVarieties())) {
                // 风险品种是标准债券的用黄色高亮
                return 2;
            } else if ("无部署".equals(one.getSctDeployStatus())) {
                //"无部署"的用灰色高亮
                return 0;
            } else {
                return 4;
            }
        };
        // 符合条件的数据行将会启用
//        ExcelImportExportUtils.rowHighLight(quarterList, cellStyleList, functional, new FileOutputStream("D:/季度数据-行高亮显示.xlsx"));
        //cellHighLight(quarterList,workbook);
    }

//    /**
//     * 指定标题下的单元格 部分高亮
//     */
//    private static void cellHighLight(List<ExportForQuarter> quarterList, Workbook workbook) throws Exception {
//        final CellStyle cellStyle = CellStyleBuilder.builder().fontName("微软雅黑").bold(true).fontSize(12).build().getCellStyle(workbook);
//        final CellStyle cellStyle3 = CellStyleBuilder.builder().fontSize(12).fontColor(14).foregroundColor(13).build().getCellStyle(workbook);
//        final CellStyle cellStyle4 = CellStyleBuilder.builder().fontSize(12).fontColor(10).bold(true).fontColor(14).foregroundColor(40).build().getCellStyle(workbook);
//        final TitlePredicateList<ExportForQuarter> predicateList = new TitlePredicateList<>();
//        // 提供断言处理
//        Predicate<ExportForQuarter> predicate = (e) -> {
//            String regex = ".*市";// 高亮市
//            final Pattern pattern = Pattern.compile(regex);
//            // 对XX市,XX区 的XX市进行截取断言
//            final Matcher matcher = pattern.matcher(e.getRegionCode().split(",")[0]);
//            if (matcher.matches()) {
//                return true;
//            }
//            return false;
//        };
//        Predicate<ExportForQuarter> predicate2 = (e) -> {
//            String regex = ".*市";// 高亮市
//            final Pattern pattern = Pattern.compile(regex);
//            final Matcher matcher = pattern.matcher(e.getRegionCode().split(",")[1]);
//            if (matcher.matches()) {
//                return true;
//            }
//            return false;
//        };
//        Predicate<ExportForQuarter> predicate3 = (e) -> {
//            if (e.getRiskNature().equals("管理失误违约")) {
//                return true;
//            }
//            return false;
//        };
//        // 高亮时间，第3季度的背景色设置为蓝色，字体红色加粗
//        Predicate<ExportForQuarter> predicate4 = (e) -> {
//            if (e.getQuarter() == 3) {
//                return true;
//            }
//            return false;
//        };
//
//        final List<TitleCellStylePredicate<ExportForQuarter>> titlePredicateList = predicateList
//                .add("市州", cellStyle, predicate)
//                .add("区县", cellStyle, predicate2)
//                .add("时间", cellStyle4, predicate4)
//                .getTitlePredicateList();
//        // 高亮一些单元格
//        ExcelImportExportUtils.updateCellStyleByBatchTitleCellStylePredicate(quarterList, titlePredicateList);
//    }

//    private static String getConcurrentPath() {
//        File directory = new File("");//设定为当前文件夹
//        String currentAbsolutePath = directory.getAbsolutePath();
//        return currentAbsolutePath;
//    }


}
