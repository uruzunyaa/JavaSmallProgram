import java.util.Scanner;
import java.math.BigInteger;

public class QuickVer {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        //aを取得
        System.out.println("x^3+y^3+z^3=a　となるx,y,zを探します。|x|<=|y|<=|z|とします。aを決めてください。");
        int a = scan.nextInt();

        //探索範囲の指定
        System.out.println("|y|の最大値を決めてください。");
        int maxY = scan.nextInt();

        //標準入力の読み込みを終了
        scan.close();

        //ｘとｙの絶対値を決め、整数値のＺとなるかをループで調査
        //x,yが同符号である事を前提としている
        for (int absoluteY = 0; absoluteY <= maxY; absoluteY++) {
            for (int absoluteX = 0; absoluteX <= absoluteY; absoluteX++) {
                if (calculateZ(absoluteX, absoluteY, a) != 0) {
                    System.out.println(absoluteX + "^3+" + absoluteY + "^3+" + calculateZ(absoluteX, absoluteY, a) + "^3=" + a);
                } else if (calculateZ(-absoluteX, -absoluteY, a) != 0) {
                    System.out.println(-absoluteX + "^3+" + -absoluteY + "^3+" + calculateZ(-absoluteX, -absoluteY, a) + "^3=" + a);
                }

            }
            if(absoluteY % 10000 == 9999){
                System.out.println(absoluteY);
            }
        }
    }

    //ｘとｙの値を決め、整数値のＺとなるかをループで調査するメソッド
     public static int calculateZ(int x, int y, int a) {
        //x,yを３乗し、INT範囲を超えても良いよう、BigIntegerクラスを利用
        BigInteger xCubed = BigInteger.valueOf(x).pow(3);
        BigInteger yCubed = BigInteger.valueOf(y).pow(3);

        //aを比較の為、BigIntに変換
        BigInteger aBigInt = BigInteger.valueOf(a);

        //zの３乗の値を計算
        BigInteger zCubed = aBigInt.subtract(xCubed).subtract(yCubed);

        //zの値を計算
        double z = Math.cbrt(zCubed.doubleValue());

        // zが整数でなければ0を返す
        if ((int)z == z) {
            return (int)z;
        }else{
            return 0;
        }
    }
}
