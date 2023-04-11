import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;

public class ws20230411 {
    public static void main(String[] args) {
        
        //no dataを出力する機構
        if (args.length == 0){
            System.out.println("no data");
            System.exit(0);
        }else if (args.length == 1){
            //入力値が1つの時
            System.out.println(args[0]);
            System.exit(0);
        }
        
        System.out.println(calcGcd(args[0],0,args));
    }
    
    public static String calcGcd(String nowGcd,int finished,String [] data){
        //ライブラリを利用するため変換
        BigInteger bigNowGcd = new BigInteger(nowGcd);
        BigInteger addNum = new BigInteger(data[finished+1]);
        String resultNew = bigNowGcd.gcd(addNum).toString();
        
        if(finished < data.length-2){
            return calcGcd(resultNew,finished+1,data);
        }else{
            return resultNew;
        }
    }
}



