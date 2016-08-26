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
		
		System.out.println("Digite a média para aprovação:");
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
		
		//Desvio Padrão
		for(i=0;i<Turma.turma.size();i++){
			somatorio = somatorio + Math.abs((Turma.turma.get(i).getNota() - mediaTurma));
		}
		desvioPadrao= somatorio/Turma.turma.size();
		
		System.out.println("\na. Número de alunos reprovados: "+nAlunosReprovados+
				"\nb. Número de alunos aprovados: "+nAlunosAprovados+
				"\nc. Porcentagem de aprovação: "+percentualAprovacao+"%"+
				"\nd. Porcentagem de reprovação: "+percentualReprovacao+"%"+
				"\ne. Média da turma: "+mediaTurma+
				"\nf. Desvio padrão: "+desvioPadrao+
				"\ng. Maior nota: "+maiorNota+
				"\nh. Menor nota: "+menorNota);
		
		Main.menu();
	}
	
}
