//入力された日付の曜日を出力するプログラム
//入力方法はスペース区切り。"2020 3 5"　のように、コマンドライン引数に入力する。

//日付管理系のクラス等をインポート
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ws20230418 {
    public static void main(String[] args) {
        
        //曜日の略称を定義
        String[] weekdays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        
        //入力値を"yyyy-MM-dd"の形に変換、これがないと一桁の数字でエラーが起きるため。
        String formattedDateString = args[0]+"-"+String.format("%02d", Integer.parseInt(args[1]))+"-"+String.format("%02d", Integer.parseInt(args[2]));
        
        //日付をLocalDateクラスのインスタンスに変換
        LocalDate date = LocalDate.parse(formattedDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        //曜日の値を取得　0(月曜日) 〜 6(日曜日)　の形式にする
        int dayValue = date.getDayOfWeek().getValue()-1;

        //曜日を出力
        System.out.println(weekdays[dayValue]);
        
    }
}
