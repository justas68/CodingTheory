/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingtheory.logic;

/**
 *
 * @author tvari
 */
public class Matrix {
    private final int[][] matrix;
    private final int rows;
    private final int columns;
    private final int q;
    
    public  Matrix (final int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        q = 2;
    }
    
    public Matrix(final int n, final int k) {
    this.matrix = new int[k][n];
     for(int i = 0; i < k; i++){
        int[] row = new int[n];
        for(int j = 0; j < n; j++){
            //standartinio pavidalo langeliai
            if(k-j > 0){
                row[j] = (i == j ? 1 : 0);//vienetukai ant įstrižainės
            }else{ // nestarndartinio pavidalo
                row[j] = Math.random() > 0.2 ? 1 : 0;
            }
        }
        matrix[i] = row;   
    }
     this.q = 2;
     this.rows = k;
     this.columns = n;
    }
    
    public Matrix getParityCheckMatrix() {
    int k = rows;
    int n = columns;
    int[][] matrix = new int[n-k][n];
    for (int i = 0; i < k; i++) {
        for (int j = 0; j < n-k; j ++) {
            matrix[j][i] = this.matrix[i][j+k];
        }
    }
    for (int i = k; i < n; i++) {
        for (int j = 0; j < n-k; j++) {
            if (i - k == j) {
                matrix[j][i] = 1;
            } else {
                matrix[j][i] = 0;
            }
        }
    }
    return new Matrix(matrix);
}
    
    public Vector multiplicationByVector(final int[] vector) {
        if (vector.length != rows) return new Vector(new int[0]);
        int[] result = new int[this.columns];
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < columns; j++) {
                result[j] += matrix[i][j] * vector[i];
                result[j] = result[j] % q;
            }
        return new Vector(result);
    }
    
    public Vector multiplicationByVectorT(final int[] vector) {

        int[] result = new int[rows];
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < columns; j++) {
                result[i] += matrix[i][j] * vector[j];
                result[i] = result[i] % q;
            }
        return new Vector(result);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    
    
}
