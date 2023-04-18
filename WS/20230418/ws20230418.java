import java.time.DayOfWeek;
import java.time.LocalDate;

public class ws20230418 {
    public static void main(String[] args) {
        // 現在の日付を取得
        LocalDate today = LocalDate.now();

        // 現在の曜日を取得
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        // 曜日の値を取得
        int dayValue = dayOfWeek.getValue();

        // 曜日の文字列を取得
        String dayString = dayOfWeek.toString();

        // 結果を出力
        System.out.println("現在の曜日の値: " + dayValue); // 1(月曜日) 〜 7(日曜日)の値を返す
        System.out.println("現在の曜日の文字列: " + dayString); // "MONDAY"〜"SUNDAY"の文字列を返す
    }
}
