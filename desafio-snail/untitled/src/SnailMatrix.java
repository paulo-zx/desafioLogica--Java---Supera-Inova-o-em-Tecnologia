import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnailMatrix {
    public static List<Integer> snail(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Percorre da esquerda para a direita
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Percorre de cima para baixo
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Verifica se ainda há elementos para percorrer
            if (top <= bottom) {
                // Percorre da direita para a esquerda
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Verifica se ainda há elementos para percorrer
            if (left <= right) {
                // Percorre de baixo para cima
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o valor de N para a matriz NxN: ");
        int N = scanner.nextInt();


        int[][] matrix = new int[N][N];


        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }


        List<Integer> resultado = snail(matrix);


        System.out.println("Resultado em padrão caracol: " + resultado);

        scanner.close();
    }
}
