package ru.mirea.inbo02.laba7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
class Main
{
    static void game(Stack<Integer> first, Stack<Integer> second)
    {
        int step = 0;

        while (!first.isEmpty() && !second.isEmpty() && step < 106)
        {
            step++;

            Integer t1 = first.pop();
            Integer t2 = second.pop();

            if (t1 > t2)
            {
                second.push(t1);
                second.push(t2);
            }
            else if (t1 < t2)
            {
                first.push(t1);
                first.push(t2);
            }
            else
            {
                first.push(t1);
                second.push(t2);
            }
        }

        if (first.isEmpty()) System.out.println("first " + step);
        else if (second.isEmpty()) System.out.println("second " + step);
        else System.out.println("botva");
    }

    public static void main(String[] args) throws Exception
    {
        Stack<Integer> first  = new Stack<Integer>();
        Stack<Integer> second = new Stack<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Ввод данных для 1ого игрока

        String input = reader.readLine();
        String[] splited = input.split(" ");

        for (String t : splited)
        {
            first.push(Integer.parseInt(t));
        }

        // Ввод данных для 2ого игрока

        input = reader.readLine();
        splited = input.split(" ");

        for (String t : splited)
        {
            second.push(Integer.parseInt(t));
        }

        // Собственно сама реализация игры

        game(first, second);
        //main(args);
    }
}
