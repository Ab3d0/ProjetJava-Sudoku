import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;




public class CreerPartieSudoku {
    public static boolean creerPartie(TableauSudoku tableauSudoku) {
        Sudoku sudoku = tableauSudoku.getSudoku();
        sudoku.nettoyerSudoku();
        JTextField[][] listeTxt = tableauSudoku.getListeTxt();
        ArrayList<JTextField> listeTxtGeneres = tableauSudoku.getListeTxtGeneres();

        for (int i = 0; i < listeTxt.length; i++) {
            for (int j = 0; j < listeTxt[0].length; j++) {
                if (!(listeTxt[i][j].getText().isEmpty())) {
                    int num = Integer.valueOf(listeTxt[i][j].getText());
                    if (sudoku.validerColonne(j, num) && sudoku.validerLigne(i, num) && sudoku.validerSousGrille(i, j, num)) {
                        sudoku.getSudoku()[i][j] = num;
                        listeTxt[i][j].setBackground(tableauSudoku.getTxtBackground4());
                        listeTxt[i][j].setForeground(tableauSudoku.getTxtForeground4());
                        listeTxt[i][j].setBorder(BorderFactory.createLineBorder(tableauSudoku.getPanelBackground(), 1));
                        listeTxtGeneres.add(listeTxt[i][j]);
                    } else {
                        listeTxtGeneres.clear();
                        JOptionPane.showMessageDialog(null, "Sudoku Incorrecte", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    listeTxt[i][j].setBackground(tableauSudoku.getTxtBackground1());
                    listeTxt[i][j].setForeground(tableauSudoku.getTxtForeground1());
                    listeTxt[i][j].setBorder(BorderFactory.createLineBorder(tableauSudoku.getPanelBackground(), 1));
                }
            }
        }
        return true;
    }
}
