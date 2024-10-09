package Others;

public class MultiDimensionalArray {

    /**
     * arr[rowIndex][colIndex] = value;
     *
     * Trong đó:
     *
     * rowIndex là chỉ số của hàng (bắt đầu từ 0).
     * colIndex là chỉ số của cột (bắt đầu từ 0).
     * value là giá trị muốn gán cho phần tử có chỉ số tương ứng.
     * @param args
     */
    public static void main(String[] args) {
        double[][] arr = new double[3][3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count = count + 1;
                arr[i][j] = count;
            }
        }

        System.out.println(arr);
    }
}
