import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.math.BigInteger;
public class CollatzProblem {
    public static int test = 0;
    public static void main(String[] args) throws Exception {
        //まず、試行回数を入力させる。
        Scanner scan = new Scanner(System.in);
        System.out.println("何回試行するか入力してください");
        int tryTime = scan.nextInt();
        scan.close();
        
        String[] investigations = new String[tryTime];
        Random rand = new Random();
        for(int i=0;i<tryTime;i++){
            int digits = rand.nextInt(42) + 222;
            System.out.print(digits + "桁:");
            investigations[i] = generateNum(digits);
            System.out.println(investigations[i] + ":");
            ArrayList<String> previousAnswer = new ArrayList<String>(); //既出解をの記録個数が不明なので可変長
            System.out.println(checkCollatz(investigations[i],previousAnswer));
            previousAnswer.clear();
        }
    }


    //桁数を受け取り、その桁数のランダムな値を返すメソッド
    public static String generateNum(int digits){
        Random rand = new Random();
        String numString = new String();
        for(int i=0;i<digits;i++){
            //最初の桁は0が出ないように。
            if(i == 0){
                numString = numString +Integer.toString(rand.nextInt(9)+1);
            }else{
                numString = numString +Integer.toString(rand.nextInt(10));
            }
        }
       return numString;
    }


    //コラッツ予想の計算の1回を行うメソッド
    public static String calcCollatz(String input) {
        BigInteger num = new BigInteger(input); // BigIntegerに変換
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");
        if (num.mod(two).equals(BigInteger.ZERO)) {  // 偶数か判定
            return num.divide(two).toString();  // 2で割った値を返す
        } else {
            return num.multiply(three).add(one).toString();  // 3倍して1を足した値を返す
        }
    }

    //コラッツ予想計算の履歴管理をし、1になるか、既出解が出るまで、再起呼び出しによって繰り返す。
    //1になった場合はtrueを、ならなかった場合はfalseを返す。
    public static boolean checkCollatz(String input,ArrayList previousAnswer){
        if(test > 500){
            //System.exit(0);
        }
        test += 1;
        String output = calcCollatz(input);
        //System.out.println(output);
        if(output.equals("1")){
            return true;//1になったので反例ではない。よってtrue
        }else{
            //既出解にあるかチェック
            boolean flag = false;
            for (int i = 0; i < previousAnswer.size(); i++) {
                if(previousAnswer.get(i).equals(output)){
                    flag = true;
                }
            }    
            //既出解として追加
            previousAnswer.add(output);
            if(flag == true){
                return false;//既出解と一緒になったので、反例を発見
            }else{
                //ここまで処理が来る場合、次を計算する必要があるので、次に委ねる(再起呼び出し)
                return checkCollatz(output,previousAnswer);
            }
        }
    }
}
