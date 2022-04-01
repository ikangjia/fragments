package cn.ikangjia.demo;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

/**
 * 文件批量重命名
 *
 * @author kangjia
 * @email 2466267753@qq.com
 * @since 2021/11/8 16:52
 */
public class FileRenameBatchHandler {
    private static final String TIP = """
             /*************************** 文件批量重命名小工具 V0.1 ******************************/
             您好，欢迎使用文件名批量修改小工具，我是批量修改文件名的机器人~~文痞秀~~（文批修）！
             使用说明：
             1. 输入要批量重命名的所有文件的父级目录；
             2. 输入要批量去掉（替换掉）的字符串；
             3. 输入要批量替换成的字符串，如果只是批量删除某通用字符串请按下 Enter 忽略此输入
            """;

    /**
     * 文件批量重命名方法
     */
    public static void fileBatchRename() {
        System.out.println(TIP);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要操作的父级目录（绝对路径）：");
        String parentPath = scanner.nextLine();

        System.out.println("要把名字里的啥替换掉？");
        String oldStr = scanner.nextLine();

        System.out.println("批量替换成啥？");
        String destStr = scanner.nextLine();

        destStr = (null == destStr || "".equals(destStr)) ? "" : destStr;
        //
        File file = new File(parentPath);
        if (file.isDirectory()) {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                String originalName = listFile.getName();
                if (listFile.isDirectory()) {
                    System.out.println("[" + originalName + "] 是目 1录，已自动跳过");
                    continue;
                }
                if (!originalName.contains(oldStr)) {
                    System.out.println(originalName + "不包含 [" + oldStr + "]，已自动跳过");
                    continue;
                }

                String newName = originalName.replace(oldStr, destStr);
                System.out.println("原始名称-->新名称：" + originalName + "-->" + newName);
                boolean ifSuccess = listFile.renameTo(new File(parentPath, newName));
                if (!ifSuccess) {
                    System.out.println(listFile.getName() + "重命名失败");
                }
            }
        } else {
            System.out.println("您输入的不是目录，请检查输入");
        }
    }
}
