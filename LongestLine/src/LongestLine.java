public class LongestLine {
    public static int findLongestLine(int[][] matrix) {
        int longest = 1;
        int height = matrix.length, width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            int len = 1;
            for (int j = 0; j < width - 1; j++) {
                if (matrix[i][j] != matrix[i][j + 1]) {
                    break;
                }

                len++;
            }

            if (longest < len) {
                longest = len;
            }
        }

        for (int i = 0; i < width; i++) {
            int len = 1;
            for (int j = 0; j < height - 1; j++) {
                if (matrix[j][i] != matrix[j + 1][i]) {
                    break;
                }

                len++;
            }

            if (longest < len) {
                longest = len;
            }
        }

        for (int i = 1; i < height + width - 2; i++) {
            int len = 1;

            int j = 0;
            int k = i;

            if (width - 1 < i) {
                j = i - width + 1;
                k = width - 1;
            }

            for (; j < i && j < height - 1; j++, k--) {
                if (matrix[j][k] != matrix[j + 1][k - 1]) {
                    break;
                }

                len++;
            }

            if (longest < len) {
                longest = len;
            }
        }

        for (int i = 1; i < height + width - 2; i++) {
            int len = 1;

            int j = 0;
            int k = width - i - 1;

            if (width - 1 < i) {
                j = i - width + 1;
                k = 0;
            }

            for (; j < i && j < height - 1; j++, k++) {
                if (matrix[j][k] != matrix[j + 1][k + 1]) {
                    break;
                }

                len++;
            }

            if (longest < len) {
                longest = len;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 1}
        };

        System.out.println(findLongestLine(matrix1));

        int[][] matrix2 = {
                {1, 1, 1, 1},
                {0, 1, 1, 0},
                {0, 0, 0, 1}
        };

        System.out.println(findLongestLine(matrix2));

        int[][] matrix3 = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 1},
                {0, 0, 1}
        };

        System.out.println(findLongestLine(matrix3));
    }
}
