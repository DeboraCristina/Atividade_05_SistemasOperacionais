package controller;

import java.util.concurrent.Semaphore;

public class ThreadSaque extends Thread
{
	private Semaphore semaphore;
	private int numConta, saldo, valor;
	
	public ThreadSaque(Semaphore semaphore, int numConta, int saldo, int valor) 
	{
		this.semaphore = semaphore;
		this.numConta = numConta;
		this.saldo = saldo;
		this.valor = valor;
	}
	
	@Override
	public void run() 
	{
		sleepMiliseconds();
		try 
		{
			semaphore.acquire();
			saque();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			semaphore.release();
		}
	}
	
	private void sleepMiliseconds() 
	{
		int tempo = ((int) (Math.random() * 501) + 500);
		try 
		{
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void saque() 
	{
		if (saldo - valor >= 0)
			System.out.println("Conta:"+numConta+" Sacou "+valor+" RS. Saldo: "+(saldo - valor)+" RS");
		else
			System.out.println("Saldo insuficiente!");
	}
}
