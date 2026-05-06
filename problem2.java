import java.util.*;

public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] A = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        long K = sc.nextLong();

        for (int i = 1; i < N; i++) {
            if ((A[i] - A[0]) % K != 0) {
                System.out.println(-1);
                return;
            }
        }

        long[] B = new long[N];

        for (int i = 0; i < N; i++) {
            B[i] = A[i] / K;
        }

        Arrays.sort(B);

        long median = B[N / 2];
        long operations = 0;

        for (int i = 0; i < N; i++) {
            operations += Math.abs(B[i] - median);
        }

        System.out.println(operations);
    }
}