package script;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class ImportExcel {

    /**
     * 读取数据
     */
    public static void main(String[] args) {
        String fileName ="D:\\planetProject\\bobpal-backend\\src\\main\\resources\\UserData.xls";
 //       readByListener(fileName);
        synchronousRead(fileName);
    }

    /**
     * 监听器
     * @param fileName
     */
    public static void readByListener(String fileName){
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, TableMyUserInfo.class, new TableListener()).sheet().doRead();
    }

    /**
     * 同步读
     * @param fileName
     */
    public static void synchronousRead(String fileName) {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<TableMyUserInfo> totalDataList =
                EasyExcel.read(fileName).head(TableMyUserInfo.class).sheet().doReadSync();

        for (TableMyUserInfo tableMyUserInfo : totalDataList) {
            System.out.println(tableMyUserInfo);
        }
    }
}
