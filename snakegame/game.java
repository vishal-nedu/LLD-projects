package Playground.SD.snakegame;

import java.util.*;

public class game
{
   private char direction;
    private pair head;
   private ArrayList<pair> body;
    private char[][] board;
    private pair food;
     private final int rows=6;
     private final int cols=6;
    public game()
    {
        this.direction='R';
        head=new pair(0,0);
        body=new ArrayList<>();
        board=new char[rows][cols];
    }
    public void play()
    {
        Scanner sc=new Scanner(System.in);
        boolean lose=false;
       food=generatefood(head,body);
       body.add(new pair(head.i,head.j));
        boolean taken=false;
        while(!lose)
        {
            if(taken)
            {
                food=generatefood(head,body);
                taken=false;
            }
            display(head,direction,board,food,body);
            System.out.println("Enter the direction(R/L/U/D):");
            char dir=sc.next().charAt(0);
            if(dir!='R'&&dir!='L'&&dir!='U'&&dir!='D')
            {
                System.out.println("Enter the correct direction ");
                continue;
            }
            direction=dir;
            if(!move(dir,head,board,food,body))
            {
                System.out.println("Game over");
                lose=true;
            }
            if(food.i==-1&&food.j==-1)
            {
                taken=true;
            }
        }
        sc.close();
    }

    public boolean move(char dir, pair head, char[][] board, pair food, ArrayList<pair> body)
    {
        int i=this.head.i;
        int j=this.head.j;
        if(dir=='R')
        {
            if(j+1>=board[0].length)
            {
                return false;
            }

            else
            {
                    if(checkselfcollision(head.i,head.j,dir,body))
                    {
                        return false;
                    }
                    if(food.i==i&&food.j==j+1)
                    {
                        food.i=-1;
                        food.j=-1;
                        pair p=new pair(i,j+1);
                        head.i=i;
                        head.j=j+1;
                        body.add(0,p);
                    }
                    else
                    {
                        pair p=new pair(i,j+1);
                        head.i=i;
                        head.j=j+1;
                        body.add(0,p);
                        body.remove(body.size()-1);
                    }
            }
        }
        else if(dir=='L')
        {
            if(j-1<0)
            {
                return false;
            }
            else
            {
                if(checkselfcollision(head.i,head.j,dir,body))
                {
                    return false;
                }
                if(food.i==i&&food.j==j-1)
                {
                    food.i=-1;
                    food.j=-1;
                    pair p=new pair(i,j-1);
                    head.i=i;
                    head.j=j-1;
                    body.add(0,p);
                }
                else
                {
                    pair p=new pair(i,j-1);
                    head.i=i;
                    head.j=j-1;
                    body.add(0,p);
                    body.remove(body.size()-1);
                }
            }
        }
        else if(dir=='U')
        {
            if(i-1<0)
            {
                return false;
            }
            else
            {
                if(checkselfcollision(head.i,head.j,dir,body))
                {
                    return false;
                }
                if(food.i==i-1&&food.j==j)
                {
                    food.i=-1;
                    food.j=-1;
                    pair p=new pair(i-1,j);
                    head.i=i-1;
                    head.j=j;
                    body.add(0,p);
                }
                else
                {
                    pair p=new pair(i-1,j);
                    head.i=i-1;
                    head.j=j;
                    body.add(0,p);
                    body.remove(body.size()-1);
                }
            }
        }
        else if(dir=='D')
        {
            if(i+1>=board.length)
            {
                return false;
            }
            else
            {
                if(checkselfcollision(head.i,head.j,dir,body))
                {
                    return false;
                }
                if(food.i==i+1&&food.j==j)
                {
                    food.i=-1;
                    food.j=-1;
                    pair p=new pair(i+1,j);
                    head.i=i+1;
                    head.j=j;
                    body.add(0,p);
                }
                else
                {
                    pair p=new pair(i+1,j);
                    head.i=i+1;
                    head.j=j;
                    body.add(0,p);
                    body.remove(body.size()-1);
                }
            }
        }
        return true;
    }

    private boolean checkselfcollision(int i, int j, char dir, ArrayList<pair> body)
    {
        if(dir=='R')
        {
            j+=1;
        }
        else if(dir=='L')
        {
            j-=1;
        }
        else if(dir=='U')
        {
            i-=1;
        }
        else if(dir=='D')
        {
            i+=1;
        }
        for(int k=1;k<body.size();k++)
        {
            pair p=body.get(k);
            if(p.i==i&&p.j==j)
            {
                return true;
            }
        }
        return false;
    }

    private void display(pair head,char direction,char[][] board, pair food, ArrayList<pair> body)
    {
        clean(board);
        if(food.i!=-1&&food.j!=-1)
        {
            board[food.i][food.j]='X';
        }
        for(pair p:body)
        {
            board[p.i][p.j]='\u00B7';
        }
        if(direction=='R')
        {
            board[head.i][head.j]='\u25BA';
        }
        else if(direction=='L')
        {
            board[head.i][head.j]='\u25C4';
        }
        else if(direction=='U')
        {
            board[head.i][head.j]='\u25B2';
        }
        else if(direction=='D')
        {
            board[head.i][head.j]='\u25BC';
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==' ')
                {
                    System.out.print("\u25A0"+" ");
                }
                else
                {
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println();


    }

    private void clean(char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                board[i][j]=' ';
            }
        }
    }

    private pair generatefood(pair head, ArrayList<pair> body)
    {
        Random random=new Random();
        pair food=null;
        while(true)
        {
            int i=random.nextInt(rows);
            int j= random.nextInt(cols);
            if(i== head.i&&j==head.j)
            {
                continue;
            }
            else if(iscelloccupied(body,i,j))
            {
                continue;
            }
            else
            {
                food=new pair(i,j);
                break;
            }
        }
        return food;
    }

    private boolean iscelloccupied(ArrayList<pair> body, int i, int j)
    {
        for(pair p:body)
        {
            if(p.i==i&&p.j==j)
            {
                return true;
            }
        }
        return false;
    }


}
