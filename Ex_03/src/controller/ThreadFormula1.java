package controller;

import java.util.concurrent.Semaphore;

import model.StackDouble;

public class ThreadFormula1 extends Thread
{
	StackDouble tempoCarros = new StackDouble();
	Semaphore semaphore;
	int piloto = 1;
	
	public ThreadFormula1(Semaphore semaphore) 
	{
		this.semaphore = semaphore;
	}

	@Override
	public void run() 
	{
		for (int i = 0; i < 2; i++)
		{
			try
			{
				semaphore.acquire();
				entraNaPista();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			finally
			{
				semaphore.release();
			}
		}
	}
	
	public void entraNaPista()
	{
		StackDouble tempoVolta = new StackDouble();
		
		for (int i = 0; i < 3; i++)
		{
			int tempo = (int) ((Math.random() * 10) + 1);

			try
			{
				sleep(tempo*1000);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println("Piloto " + piloto + " da equipe #"+getId()+" completou a "+i+"a volta em "+tempo+" minutos.");
			tempoVolta.push(tempo);
		}
		piloto++;
		System.out.println("O menor tempo do piloto " + piloto + " da equipe #" + getId() + " é " + tempoVolta.min() + "minutos.");
		tempoCarros.push(tempoVolta.min());
	}
}

/*
No máximo 5 carros das 7 escuderias (14 carros no total) presentes podem entrar na pista simultaneamente, mas apenas
um carro de cada equipe. O segundo carro deve ficar à espera, caso um companheiro de equipe já esteja na pista. Cada piloto
deve dar 3 voltas na pista. O tempo de cada volta deverá ser exibido e a volta mais rápida de cada piloto deve ser
armazenada para, ao final, exibir o grid de largada, ordenado do menor tempo para o maior.
*/