package view;

import java.util.concurrent.Semaphore;

import controller.ThreadDeposito;
import controller.ThreadSaque;

public class Main
{
	public static void main(String[] args)
	{
		Semaphore semaphoreSaque = new Semaphore(1);
		Semaphore semaphoreDeposito = new Semaphore(1);
		for (int i = 0; i <= 20; i++)
		{
			int t = (int) (Math.random() * 101);
			if (t % 2 == 0)
			{
				ThreadSaque saque = new ThreadSaque(semaphoreSaque, random(101, 100), random(1001, 100), random(1001, 0));
				saque.start();
			}
			else
			{
				ThreadDeposito deposito = new ThreadDeposito(semaphoreDeposito, random(101, 100), random(1001, 100), random(1001, 0));
				deposito.start();
			}
		}
	}
	
	public static int random(int max, int min)
	{
		return (((int) (Math.random() * max) + min));
	}
}
