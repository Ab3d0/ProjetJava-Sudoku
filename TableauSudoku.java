import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import java.awt.Cursor;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;




public class TableauSudoku extends JPanel {
    
    private JTextField[][] listeTxt;
    private int largeurTxt;
    private int hauteurTxt;
    private int margeTxt;
    private int taillePoliceTxt;
    private Color panelBackground;
    private Color txtBackground1;
    private Color txtForeground1;
    private Color txtBackground2;
    private Color txtForeground2;
    private Color txtBackground3;
    private Color txtForeground3;
    private Color txtForeground4;
    private Color txtBackground4;

    private Sudoku sudoku;
    private ArrayList<JTextField> listeTxtAux;
    private ArrayList<JTextField> listeTxtGenerés;
    
    public TableauSudoku() {
        initialiserComposants();
        creerSudoku();
    }
    
    public void initialiserComposants() {
        listeTxt = new JTextField[9][9];
        largeurTxt = 66;
        hauteurTxt = 66;
        margeTxt = 4;
        taillePoliceTxt = 27;
        panelBackground = Color.BLACK;
        txtBackground1 = Color.WHITE;
        txtForeground1  = Color.BLACK;
        txtBackground2 = Color.WHITE;
        txtForeground2 = Color.BLACK;
        txtBackground3 =  Color.WHITE;
        txtForeground3  = Color.BLACK;
        txtBackground4 = Color.BLUE;
        txtForeground4 = Color.WHITE;

        sudoku = new Sudoku();
        listeTxtAux = new ArrayList<>();
        listeTxtGenerés = new ArrayList<>();
    }

    public void creerSudoku() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(largeurTxt * 9 + (margeTxt * 4), hauteurTxt * 9 + (margeTxt * 4)));
        this.setBackground(panelBackground);
        crearComposTxt();
        
    }

    public void crearComposTxt(){
        int x = margeTxt;
        int y = margeTxt;

        GestionnaireEvenements gestionnaire = new GestionnaireEvenements();
    
        for(int i = 0 ; i < listeTxt.length; i++){
            for(int j = 0; j < listeTxt[0].length; j++){
    
                JTextField txt = new JTextField();
                this.add(txt);
                txt.setBounds(x , y , largeurTxt, hauteurTxt);
                txt.setBackground(txtBackground1);
                txt.setForeground(txtForeground1);
                txt.setFont(new Font("Montserrat" , Font.BOLD,taillePoliceTxt));
                txt.setEditable(false);
                txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
                txt.setBorder(BorderFactory.createLineBorder(panelBackground,1));
                txt.setVisible(true);
                x+=largeurTxt;
    
                if((j + 1)%3==0){
                    x+=margeTxt;
                }
                listeTxt[i][j] = txt;
                gestionnaire.genereEvents(txt);
            }
            x=margeTxt;
            y+=hauteurTxt;
            if((i + 1)%3==0){
                y+=margeTxt;
            }
               
        }
    }
    

    public void NettoyerTxt(){
        for(int i= 0; i < listeTxt.length; i++){
            for(int j = 0; j < listeTxt[0].length; j++){
                listeTxt[i][j].setText("");
                listeTxt[i][j].setBackground(txtBackground1);
                listeTxt[i][j].setForeground(txtForeground1);
                listeTxt[i][j].setBorder(BorderFactory.createLineBorder(panelBackground, 1));

            }
        }
        listeTxtGenerés.clear();

    }

    public boolean CreerPartieSudoku() {
        return CreerPartieSudoku.creerPartie(this);
    }
    
    
    public Sudoku getSudoku() {
        return sudoku;
    }
    
    public ArrayList<JTextField> getListeTxtGeneres() {
        return listeTxtGenerés;
    }
    

    public JTextField[][] getListeTxt() {
        return listeTxt;
    }
    
    public void setListeTxt(JTextField[][] listeTxt) {
        this.listeTxt = listeTxt;
    }
    
    public int getLargeurTxt() {
        return largeurTxt;
    }
    
    public void setLargeurTxt(int largeurTxt) {
        this.largeurTxt = largeurTxt;
    }
    
    public int getHauteurTxt() {
        return hauteurTxt;
    }
    
    public void setHauteurTxt(int hauteurTxt) {
        this.hauteurTxt = hauteurTxt;
    }
    
    public int getMargeTxt() {
        return margeTxt;
    }
    
    public void setMargeTxt(int margeTxt) {
        this.margeTxt = margeTxt;
    }
    
    public int getTaillePoliceTxt() {
        return taillePoliceTxt;
    }
    
    public void setTaillePoliceTxt(int taillePoliceTxt) {
        this.taillePoliceTxt = taillePoliceTxt;
    }
    
    public Color getPanelBackground(){
        return panelBackground;
    }
    public void  setPanelBackground(Color panelBackground){
        this.panelBackground = panelBackground;
    }

    public Color getTxtBackground1(){
        return txtBackground1;
    }
    public void setTxtBackground1(Color txtBackground1){
        this.txtBackground1 = txtBackground1;

    }
    public Color getTxtForeground1(){
        return txtForeground1;
    }
    public void setTxtForeground1(Color txtForeground1){
        this.txtForeground1 = txtForeground1;
        
    }
    
    public Color getTxtBackground2(){
        return txtBackground2;
    }
    public void setTxtBackground2(Color txtBackground2){
        this.txtBackground2 = txtBackground2;

    }
    public Color getTxtForeground2(){
        return txtForeground1;
    }
    public void setTxtForeground2(Color txtForeground2){
        this.txtForeground2 = txtForeground2;
        
    }
    
    public Color getTxtBackground3(){
        return txtBackground3;
    }
    public void setTxtBackground3(Color txtBackground3){
        this.txtBackground3 = txtBackground3;

    }
    public Color getTxtForeground3(){
        return txtForeground3;
    }
    public void setTxtForeground3(Color txtForeground3){
        this.txtForeground3 = txtForeground3;
        
    }
    public Color getTxtBackground4(){
        return txtBackground4;
    }
    public void setTxtBackground4(Color txtBackground4){
        this.txtBackground4 = txtBackground4;

    }
    public Color getTxtForeground4(){
        return txtForeground4;
    }
    public void setTxtForeground4(Color txtForeground4){
        this.txtForeground4 = txtForeground4;
        
    }
}