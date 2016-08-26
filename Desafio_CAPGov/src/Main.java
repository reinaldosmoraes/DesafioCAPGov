import java.util.Scanner;

public class Main {
	
	private static Scanner input;
	private static Scanner input2;
	private static Scanner input4;
	private static Scanner input5;
	
	
	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		
		
		//Amostra pra teste
		Aluno a1 = new Aluno();
		a1.setNome("João da Silva");
		Turma.turma.add(a1);
		
		Aluno a2 = new Aluno();
		a2.setNome("Pedro Carvalho");
		a2.setNota(5);
		Turma.turma.add(a2);
		
		Aluno a3 = new Aluno();
		a3.setNome("José Pereira");
		Turma.turma.add(a3);
		
		//Print inicial
		System.out.println("-------Desafio CAPGov - Reinaldo Moraes-------");
		
		//Login
		if(Login.fazerLogin()){
			System.out.println("\n---Bem vindo ao Desafio CAPGov----");
			menu();
		}
		
		else{
			System.out.println("Senha incorreta");
		}
		System.out.println("Fim do Programa");
	}

	//menu de opções
	public static void menu(){
	
		String opcao;
		
		System.out.print("\nEscolha uma das opções abaixo, digitando seu número correspondente.\n\n"
				+ "1. Inserir aluno\n"
				+ "2. Consultar alunos\n"
				+ "3. Lançar nota\n"
				+ "4. Calcular desempenho da turma\n"
				+ "5. Inserir aluno e nota\n"
				+ "6. Sair\n\n"
				+ "Opção:");
		opcao = input.nextLine();

		//chamada das funções pela opção escolhida
		switch (opcao){
			case "1": 
				inserirAluno();
				break;
			
			case "2":
				consultarAlunos();
				break;
				
			case "3":
				lancarNota();
				break;
				
			case "4":
				Turma.calcularDesempenho();
				break;
				
			case "5":
				inserirAlunoNota();
				break;
				
			case "6":
				break;
		}
	}
	
	//inserir um aluno
	public static void inserirAluno(){
		
		System.out.println("\n-----Inserir Aluno-----");
		
		Aluno aluno1 = new Aluno();
		
		System.out.print("Digite o nome do aluno: ");
		aluno1.setNome(input.nextLine());
		
		Turma.turma.add(aluno1);
		
		System.out.println("\nAluno inserido com sucesso.\n");
		
		menu();
	}
	
	//consulta a lista de alunos e suas notas
	public static void consultarAlunos(){
	
		System.out.println("-----Lista de Alunos-----");
		
		for (int i = 0; i < Turma.turma.size(); i++) {
			System.out.println((i+1) + ". " + Turma.turma.get(i).getNome()+" - "+Turma.turma.get(i).getNota());
		}
		
		menu();
	}
	
	//função para lançar as notas de todos os alunos em sequencia
	public static void lancarNota(){
		
		input2 = new Scanner(System.in);
		
		System.out.println("-----Lançar Nota-----\n"
				+ "Digite as notas, separando as casas decimais com vígula. Ex.: 5,5\n");
		
		
		for (int i = 0; i < Turma.turma.size(); i++) {
			System.out.print(Turma.turma.get(i).getNome()+": ");	
			Turma.turma.get(i).setNota(input2.nextFloat());
		}
		
		System.out.println("\nNotas Lançadas:");
		
		for (int i = 0; i < Turma.turma.size(); i++) {
			System.out.println(Turma.turma.get(i).getNome() + ": " + Turma.turma.get(i).getNota());
		}
		
		menu();
	}
	
	//Insere um aluno e nota, caso nao exista
	public static void inserirAlunoNota(){
		
		input4 = new Scanner(System.in);
		input5 = new Scanner(System.in);
		
		int pos, aux=0;
		String s, nome, notaTexto, inserirNovamente;
		float nota;
		
		System.out.println("\n-----Inserir aluno e nota-----\n"
				+ "Digite o nome e nota do aluno, separdos por um hífen(-) \ne a nota por ponto. Ex.:5.3");
		
		s = input4.nextLine();

		pos = s.indexOf("-");
		
		nome = s.substring(0, pos);

		notaTexto = s.substring(pos+1);
		
		nota = Float.parseFloat(notaTexto);

		
		for (int i = 0;i < Turma.turma.size();i++) {	
			
			if(Turma.turma.get(i).getNome().equals(nome)){
				
				//variavel pra controle pra acionar ou nao a criação de um novo aluno
				aux++;
				
				//verifica de a nota já foi lançada
				if(Turma.turma.get(i).getNota()!=0)
					System.out.println("O aluno já estava cadastrado e com nota lançada.");
				
				else
					Turma.turma.get(i).setNota(nota);	
			}
		}

		//aluno não existe, criar aluno
		if(aux==0) {
			
			Aluno a = new Aluno();
			a.setNome(nome);
			a.setNota(nota);
			Turma.turma.add(a);
		}
		
		System.out.println("Inserir outro aluno? Digite s para sim.");
		inserirNovamente = input5.nextLine();
		
		if(inserirNovamente.equals("s"))
			inserirAlunoNota();
		
		else
			menu();
		
	}
}