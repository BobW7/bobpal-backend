package script;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表格信息
 */
@Data
@EqualsAndHashCode
public class TableMyUserInfo {

    /**
     * 成员编号
     */
    @ExcelProperty("成员编号")
    private String planetCode;
    /**
     * 用户昵称
     */
    @ExcelProperty("成员昵称")
    private String username;
}