JAVAC = javac
JAVARUN = java
JAVASRC = $(wildcard *.java)
CLASSFILES = $(JAVASRC:.java=.class)



PREMIER_PROG_FILES = Creation.java FenetrePrincipale1.java Button.java NettoyerTxt.java TableauSudoku.java CreerPartieSudoku.java SauvegarderGrilleVersFichier.java Sudoku.java
DEUXIEME_PROG_FILES = Jouer.java FenetreJeux.java TableauSudoku.java Button.java Niveau.java EffacerBouton.java VerifierBouton.java ResoudreBouton.java ChargerGrilleVersFichier.java GenererSudoku.java Sudoku.java CreerPartieSudoku.java


PremierProg_compil :  $(PREMIER_PROG_FILES)
	$(JAVAC) $(PREMIER_PROG_FILES)

PremierProg :
	$(JAVARUN) Creation


DeuxiemeProg_compil : $(DEUXIEME_PROG_FILES)
	$(JAVAC) $(DEUXIEME_PROG_FILES)

DeuxiemeProg :
	$(JAVARUN) Jouer


clean :
	rm -f $(CLASSFILES)
