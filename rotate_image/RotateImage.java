public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        
        for (int offset = 0; offset < matrix.length / 2; offset++) {
            rotate(matrix, offset);
        }
    }
    
    private void rotate(int[][] matrix, int offset) {
        for (int i = offset; i < matrix.length - offset - 1; i++) {
            int tmp = matrix[i][offset];
            matrix[i][offset] = matrix[matrix.length - offset - 1][i];
            matrix[matrix.length - offset - 1][i] = matrix[matrix.length - 1 - i][matrix[0].length - 1 - offset];
            matrix[matrix.length - 1 - i][matrix[0].length - 1 - offset] = matrix[offset][matrix[0].length - 1 - i];
            matrix[offset][matrix[0].length - 1 - i] = tmp;
        }
    }
}