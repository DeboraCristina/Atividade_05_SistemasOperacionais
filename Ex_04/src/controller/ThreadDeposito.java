package controller;

import java.util.concurrent.Semaphore;

public class ThreadDeposito extends Thread
{
	private Semaphore semaphore;
	private int numConta, saldo, valor;
	
	public ThreadDeposito(Semaphore semaphore, int numConta, int saldo, int valor) 
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
			deposito();
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
	
	private void deposito() 
	{
		if (valor > 0)
			System.out.println("Conta:"+numConta+" Depositou "+valor+" RS. Saldo: "+(saldo + valor)+" RS");
		else
			System.out.println("Deposito invalido!");
	}
}
