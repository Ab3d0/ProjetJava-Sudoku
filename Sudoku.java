import java.util.Random;

public class Sudoku {


    private int sudoku[][];

    public Sudoku(){
      sudoku = new int [9][9];
      nettoyerSudoku();
    }

    public boolean résoudreSudoku(){
        for (int i = 0; i < sudoku.length; i++){
            for (int j = 0; j < sudoku[0].length; j++){
                if (sudoku[i][j] == 0){
                    for (int valeur = 1; valeur <= 9; valeur++){
                        if (validerLigne(i, valeur) && validerColonne(j, valeur) && validerSousGrille(i, j, valeur)){
                            sudoku[i][j] = valeur;
                            if (résoudreSudoku()){
                                return true;
                            }
                            sudoku[i][j] = 0;
                        }
                    } 
                    return false;
                }
            }
        } 
        return true;
    }
    
    public boolean validerLigne(int i, int valeur){
        for (int j = 0; j < sudoku[i].length; j++){
            if (sudoku[i][j] == valeur){
                return false;
            }
        }
        return true;
    }
    
    public boolean validerColonne(int j, int valeur){
        for (int i = 0; i < sudoku.length; i++){
            if (sudoku[i][j] == valeur){
                return false;
            }
        }
        return true;
    }
    
    public boolean validerSousGrille(int i, int j, int valeur){
        int positionI = sousGrilleActuelle(i);
        int positionJ = sousGrilleActuelle(j);
    
        for (int k = positionI - 3; k < positionI; k++){
            for (int l = positionJ - 3; l < positionJ; l++){
                if (sudoku[k][l] == valeur){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int sousGrilleActuelle(int position){
        if (position <= 2){
            return 3;
        } else if (position <= 5){
            return 6;
        } else {
            return 9;
        }
    }
    
  

    public void nettoyerSudoku(){
        for(int i = 0; i <sudoku.length; i++){
            for(int j = 0; j <sudoku[0].length; j++){
                sudoku[i][j]=0;
            }
        }
    }

    public void genererSudoku(int nivel){
        nettoyerSudoku();
        Random random = new Random();
        
        for(int i = 0; i< 3; i++){
            for(int j = 0; j < 3 ; j++){
                int num = random.nextInt(9)+1;
                if(validerSousGrille(i, j, num)){
                    sudoku[i][j]= num;

                }else{
                    j--;
                }
            }
        }
        for(int i = 3; i< 6; i++){
            for(int j = 3; j < 6 ; j++){
                int num = random.nextInt(9)+1;
                if(validerSousGrille(i, j, num)){
                    sudoku[i][j]= num;

                }else{
                    j--;
                }
            }
        }
        for(int i = 6; i< 9; i++){
            for(int j = 6; j < 9 ; j++){
                int num = random.nextInt(9)+1;
                if(validerSousGrille(i, j, num)){
                    sudoku[i][j]= num;

                }else{
                    j--;
                }
            }
        }

        résoudreSudoku();

        for(int i = 0 ; i < sudoku.length; i++){
            for(int j = 0 ; j < sudoku[0].length; j++){
                int aux = j;
                int rand = random.nextInt(nivel + 1);
                j+=rand;
                for(int k = aux; k < j && k<sudoku.length; k++){
                    sudoku[i][k]=0;
                    
                }
            }
        }
    }

    public boolean verifierSudoku(){
        for(int i = 0; i < sudoku.length; i++){
            for(int j = 0 ; j < sudoku[0].length; j++){
                int aux = sudoku[i][j];
                sudoku[i][j] = 0;
                if(!validerLigne(i, aux)|| !validerColonne(j, aux)|| ! validerSousGrille(i, j, aux)){
                    sudoku[i][j] = aux;
                    return false;
                }
                sudoku[i][j] = aux;
            }
        }
        return true;
    }
    

    public int [][] getSudoku(){
        return sudoku;

    }
    public void setSudoku(int[][] sudoku){
        this.sudoku = sudoku;
    }
}

