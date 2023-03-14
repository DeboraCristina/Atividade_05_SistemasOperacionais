package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread
{
    private final int direction;
    private final Semaphore semaphore;

    public ThreadCarro (int direction, Semaphore semaphore)
    {
        this.direction = direction;
        this.semaphore = semaphore;
    }

    @Override
    public void run()
    {
        try
        {
            semaphore.acquire();
            across();
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

    private void across()
    {
        String strDirection = "";

        switch (direction)
        {
            case 1 -> strDirection = "norte";
            case 2 -> strDirection = "sul";
            case 3 -> strDirection = "leste";
            case 4 -> strDirection = "oeste";
        }
        System.out.printf("O carro no sentido %s atravessou o cruzamento\n", strDirection);
    }
}
