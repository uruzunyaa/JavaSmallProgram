import java.util.Scanner;
public class App {
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
    public static Boolean check(int x,int y,int z,int a){
        if(x*x*x + y*y*y + z*z*z == a){
            return true;
        }else{
            return false;
        }
    }
}
