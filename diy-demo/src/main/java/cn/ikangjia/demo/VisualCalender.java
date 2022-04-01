package cn.ikangjia.demo;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * 可视化日历
 *
 * @author kangjia
 * @email 2466267753@qq.com
 * @since 2021/11/8 17:46
 */
public class VisualCalender {
    public static void main(String[] args) {
        System.out.println("请输入年月【2021-02】");
        Scanner scanner = new Scanner(System.in);
        final String date = scanner.nextLine();

        System.out.println("星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t星期日");
        final String[] split = date.split("-");
        final LocalDate firstDay = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), 1);

        // 获取所输入月份的天数
        final int dayLength = firstDay.getMonth().length(firstDay.isLeapYear());

        // 所输入当月第一天的星期，星期一为 1，以此类推
        int weekday = firstDay.getDayOfWeek().getValue();

        // 换行标志，a = 7 的时候该换行了
        int a = 1;
        for (int i = 1; i <= dayLength; i++) {
            if (i == 1) {
                for (int j = 1; j < weekday; j++) {
                    System.out.print("\t\t");
                    a++;
                }
            }
            System.out.print(i + "\t\t");
            a++;
            if (a > 7) {
                System.out.println();
                a = 1;
            }
        }

    }
}
