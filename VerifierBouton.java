import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;



public class VerifierBouton {

    private JTextField[][] listeTxt;
    private ArrayList<JTextField> listeTxtGenerés;
    private Sudoku sudoku;


    // Constructeur de la classe, si nécessaire
    public VerifierBouton(JTextField[][] listeTxt, ArrayList<JTextField> listeTxtGenerés, Sudoku sudoku) {
        this.listeTxt = listeTxt;
        this.listeTxtGenerés = listeTxtGenerés;
        this.sudoku = sudoku;
    }

    public void verifierBouton(){
        int sudo[][] = new int [9][9];
        for(int i = 0; i < listeTxt.length; i++){
            for(int j = 0; j < listeTxt[0].length; j++){
                if(listeTxt[i][j].getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Sudoku imcomplet", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    sudo[i][j] = Integer.parseInt(listeTxt[i][j].getText());
                }
            }
        }
        sudoku.setSudoku(sudo);
        if(sudoku.verifierSudoku()){
            JOptionPane.showMessageDialog(null, "Sudoku correcte", "Sudoku", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Pas de solution", "Sudoku", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
