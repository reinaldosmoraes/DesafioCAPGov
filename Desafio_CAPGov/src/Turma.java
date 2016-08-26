import java.util.ArrayList;
import java.util.Scanner;

public class Turma {
	
	private static Scanner input3;

	static ArrayList<Aluno> turma = new ArrayList<Aluno>();
	
public static void calcularDesempenho(){
		
		float media, percentualAprovacao, percentualReprovacao, mediaTurma = 0, desvioPadrao, somatorio = 0, maiorNota, menorNota;
		int nAlunosReprovados = 0, nAlunosAprovados = 0, i;
		input3 = new Scanner(System.in);
		maiorNota = menorNota = Turma.turma.get(0).getNota();
		
		System.out.println("Digite a m�dia para aprova��o:");
		media = input3.nextFloat();
		
		for (i = 0; i < Turma.turma.size(); i++) {
			
			if(Turma.turma.get(i).getNota() >= media)
				nAlunosAprovados++;
			
			else
				nAlunosReprovados++;
			
			
			if(maiorNota < Turma.turma.get(i).getNota())
				maiorNota = Turma.turma.get(i).getNota();
			
			if(menorNota > Turma.turma.get(i).getNota())
				menorNota = Turma.turma.get(i).getNota();
			
			mediaTurma = mediaTurma + Turma.turma.get(i).getNota();
		}
		mediaTurma= mediaTurma/Turma.turma.size();
		
		percentualAprovacao = (((float)nAlunosAprovados)/Turma.turma.size())*100;
		percentualReprovacao = (((float)nAlunosReprovados)/Turma.turma.size())*100;
		
		//Desvio Padr�o
		for(i=0;i<Turma.turma.size();i++){
			somatorio = somatorio + Math.abs((Turma.turma.get(i).getNota() - mediaTurma));
		}
		desvioPadrao= somatorio/Turma.turma.size();
		
		System.out.println("\na. N�mero de alunos reprovados: "+nAlunosReprovados+
				"\nb. N�mero de alunos aprovados: "+nAlunosAprovados+
				"\nc. Porcentagem de aprova��o: "+percentualAprovacao+"%"+
				"\nd. Porcentagem de reprova��o: "+percentualReprovacao+"%"+
				"\ne. M�dia da turma: "+mediaTurma+
				"\nf. Desvio padr�o: "+desvioPadrao+
				"\ng. Maior nota: "+maiorNota+
				"\nh. Menor nota: "+menorNota);
		
		Main.menu();
	}
	
}
