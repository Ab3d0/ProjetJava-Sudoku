import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;


public class ResoudreBouton {


    private JTextField[][] listeTxt;
    private ArrayList<JTextField> listeTxtGenerés;
    private Sudoku sudoku;

    // Constructeur de la classe, si nécessaire
    public ResoudreBouton(JTextField[][] listeTxt, ArrayList<JTextField> listeTxtGenerés, Sudoku sudoku) {
        this.listeTxt = listeTxt;
        this.listeTxtGenerés = listeTxtGenerés;
        this.sudoku = sudoku;
    }
    public void boutonrésoudre(){
        sudoku.nettoyerSudoku();
        for(int i = 0; i < listeTxt.length; i++){
            for(int j = 0; j < listeTxt[0].length; j++){
                for(JTextField txt : listeTxtGenerés){
                    if(txt == listeTxt[i][j]){
                        sudoku.getSudoku()[i][j] = Integer.parseInt(txt.getText());
                    }
                }
            }
        }
        if(sudoku.résoudreSudoku()){
            for(int i = 0; i < listeTxt.length; i++){
                for(int j = 0; j < listeTxt[0].length; j++){
                    listeTxt[i][j].setText(String.valueOf(sudoku.getSudoku()[i][j]));
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Pas de solution", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
