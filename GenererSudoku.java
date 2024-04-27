import javax.swing.BorderFactory;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.ArrayList;


public class GenererSudoku {

    private JTextField[][] listeTxt;
    private ArrayList<JTextField> listeTxtGenerés;
    private Color txtBackground4;
    private Color txtForeground4;
    private Sudoku sudoku;

    // Constructeur de la classe, si nécessaire
    public GenererSudoku(JTextField[][] listeTxt, ArrayList<JTextField> listeTxtGenerés, Color txtBackground4, Color txtForeground4, Sudoku sudoku) {
        this.listeTxt = listeTxt;
        this.listeTxtGenerés = listeTxtGenerés;
        this.txtBackground4 = txtBackground4;
        this.txtForeground4 = txtForeground4;
        this.sudoku = sudoku;
    }

    // Méthode pour générer un sudoku
    public void genererSudoku(int nivel) {
        NettoyerTxt nettoyeur = new NettoyerTxt(listeTxt, listeTxtGenerés, Color.WHITE, Color.BLACK, Color.BLACK);
        nettoyeur.NettoyerTxt();

        sudoku.genererSudoku(nivel);
        int[][] sudokuGenere = sudoku.getSudoku();

        for (int i = 0; i < sudokuGenere.length; i++) {
            for (int j = 0; j < sudokuGenere[0].length; j++) {
                if (sudokuGenere[i][j] != 0) {
                    listeTxt[i][j].setText(String.valueOf(sudokuGenere[i][j]));
                    listeTxt[i][j].setBackground(txtBackground4);
                    listeTxt[i][j].setForeground(txtForeground4);
                    listeTxtGenerés.add(listeTxt[i][j]);
                }
            }
        }
    }
}
