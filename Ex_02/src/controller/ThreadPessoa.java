package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread
{
    private int corridorLength = 200;
    private final Semaphore semaphore;
    private int distance;

    public ThreadPessoa(Semaphore semaphore)
    {
        this.semaphore = semaphore;
    }

    @Override
    public void run()
    {
        across();
        try
        {
            semaphore.acquire();
            enter();
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

    private void enter()
    {
        int time = (int) ((Math.random() * 2) + 1);

        sleepSeconds(time);
        System.out.printf("Pessoa $%d entrou.\n", (int) getId());
    }

    private void across()
    {
        System.out.printf("Pessoa $%d esta atravessando o corredor.\n", (int) getId());
        while (distance < corridorLength)
        {
            sleepSeconds(1);
            distance += (int) ((Math.random() * 3) + 4);
            //System.out.printf("Pessoa $%d percorreu %dM.\n", (int) getId(), distance);
        }
    }

    private void sleepSeconds(int sec)
    {
        int mili = sec * 1000;
        try {
            sleep(mili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
