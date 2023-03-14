package view;

import controller.ThreadPessoa;

import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(1);

        for (int i = 1; i <= 4; i++)
        {
            ThreadPessoa pessoa = new ThreadPessoa(semaphore);
            pessoa.start();
        }
    }
}
