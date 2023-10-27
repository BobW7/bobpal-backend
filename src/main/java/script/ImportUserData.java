package script;

import com.alibaba.excel.EasyExcel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 导入用户数据到数据库
 */
public class ImportUserData {
    public static void main(String[] args) {
        String fileName ="D:\\planetProject\\bobpal-backend\\src\\main\\resources\\UserData.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<TableMyUserInfo> userInfoList =
                EasyExcel.read(fileName).head(TableMyUserInfo.class).sheet().doReadSync();
        System.out.println("总数 = "+userInfoList.size());
        //过滤
        //首先将昵称相同的用户的信息放到同一组下
        Map<String, List<TableMyUserInfo>> listMap =
                userInfoList.stream()
                        .filter(item -> StringUtils.isNotEmpty(item.getUsername()))
                        .collect(Collectors.groupingBy(TableMyUserInfo::getUsername));
        for (Map.Entry<String, List<TableMyUserInfo>> stringListEntry : listMap.entrySet()) {
            if(stringListEntry.getValue().size() > 1){
                System.out.println("userName = "+stringListEntry.getKey());
                System.out.println(1);
            }
        }
        System.out.println("无重复的昵称数 = "+listMap.keySet().size());

    }
}
