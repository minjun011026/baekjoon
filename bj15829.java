import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String sentence = br.readLine();
        BigInteger sum = BigInteger.valueOf(0);
        for(int i = 0; i<L; i++){
            BigInteger pow31 = BigInteger.valueOf(31);
            pow31 = pow31.pow(i);
            pow31=pow31.multiply(BigInteger.valueOf((int)sentence.charAt(i)-96));
            sum=sum.add(pow31);
        }
        sum =sum.remainder(BigInteger.valueOf(1234567891));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}