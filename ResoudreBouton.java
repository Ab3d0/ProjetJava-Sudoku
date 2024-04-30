import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;


public class ResoudreBouton {


    private JTextField[][] listeTxt;
    private ArrayList<JTextField> listeTxtGenerés;
    private Sudoku sudoku;
    private double tempsRésolution;


    // Constructeur de la classe, si nécessaire
    public ResoudreBouton(JTextField[][] listeTxt, ArrayList<JTextField> listeTxtGenerés, Sudoku sudoku) {
        this.listeTxt = listeTxt;
        this.listeTxtGenerés = listeTxtGenerés;
        this.sudoku = sudoku;
    }
    public void boutonrésoudre(){
        sudoku.nettoyerSudoku();

        double startTime = System.nanoTime();

        
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
            
            double endTime = System.nanoTime();

            tempsRésolution =(double) (endTime - startTime) / 1000000;

            for(int i = 0; i < listeTxt.length; i++){
                for(int j = 0; j < listeTxt[0].length; j++){
                    listeTxt[i][j].setText(String.valueOf(sudoku.getSudoku()[i][j]));
                }
            }
            JOptionPane.showMessageDialog(null, "Sudoku résolu en " + tempsRésolution + "microsecondes.", "Succès", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Pas de solution", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double getTempsRésolution(){
        return tempsRésolution;
    }
}
