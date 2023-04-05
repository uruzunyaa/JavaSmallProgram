import java.util.Scanner;
import java.math.BigInteger;
public class BigIntVer {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("x^3+y^3+z^3=a　となるx,y,zを探します。|x|<=|y|<=|z|とします。aを決めてください。");
        int a = scan.nextInt();
        System.out.println("|z|の最大値を決めてください。894以下にしないと、3乗の足し算でINT範囲を超えるかも？");
        int maxZ = scan.nextInt();
        scan.close();
        for(int absoluteZ = 0;absoluteZ <= maxZ ;absoluteZ++){
            for(int absoluteY = 0;absoluteY <= absoluteZ ;absoluteY++){
                for(int absoluteX = 0;absoluteX <= absoluteY ;absoluteX++){
                    int z = absoluteZ;
                    int y = absoluteY;
                    int x = absoluteX;
                    for(int i = 0;i<2;i++){
                        for(int j = 0;j<2;j++){
                            for(int k = 0;k<2;k++){
                                if(check(x,y,z,a)){
                                    System.out.println(x+"^3+"+y+"^3+"+z+"^3="+a);
                                }
                                x *= -1;
                            }
                            y *= -1;
                        }
                        z *= -1; 
                    }    
                }       
            }           
        }        
    }
    //3乗の等式が正しいかをチェックするメソッド
    public static boolean check(int x, int y, int z, int a) {
        //長桁に対応する変数に変換
        BigInteger xBigInt = BigInteger.valueOf(x);
        BigInteger yBigInt = BigInteger.valueOf(y);
        BigInteger zBigInt = BigInteger.valueOf(z);
        BigInteger aBigInt = BigInteger.valueOf(a);
    
        //x,y,zを3乗する
        BigInteger xCubed = xBigInt.pow(3);
        BigInteger yCubed = yBigInt.pow(3);
        BigInteger zCubed = zBigInt.pow(3);

        //3乗した値の合計とaが等しいか比較する
        BigInteger sumOfCubed = xCubed.add(yCubed).add(zCubed);
    
        //結果を返す
        return sumOfCubed.equals(aBigInt);
    }
}
