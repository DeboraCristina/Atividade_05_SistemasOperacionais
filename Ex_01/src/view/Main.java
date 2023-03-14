package view;

import controller.ThreadCarro;

import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(1);

        for (int i = 1; i < 5; i++)
        {
            ThreadCarro carro = new ThreadCarro(i, semaphore);
            carro.start();
        }
    }
}
