package view;

import java.util.concurrent.Semaphore;

import controller.ThreadFormula1;
import model.StackDouble;

public class Main 
{
	public static void main(String[] args) 
	{
		int[] escudeiras = new int[7];
		Semaphore semaphore = new Semaphore(5);
		
		for (int i : escudeiras)
		{
			ThreadFormula1 corrida = new ThreadFormula1(semaphore);
			corrida.start();
		}
	}
}

/*
No máximo 5 carros das 7 escuderias (14 carros no total)
presentes podem entrar na pista simultaneamente, mas apenas
um carro de cada equipe. O segundo carro deve ficar à espera,
caso um companheiro de equipe já esteja na pista. Cada piloto
deve dar 3 voltas na pista. O tempo de cada volta deverá ser
exibido e a volta mais rápida de cada piloto deve ser
armazenada para, ao final, exibir o grid de largada, ordenado
do menor tempo para o maior.

*/