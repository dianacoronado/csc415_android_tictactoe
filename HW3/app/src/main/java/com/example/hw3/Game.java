package com.example.hw3;

class Game {

    char[] mBoard = new char[9];

    public void newGame()
    {
        for(char i=0;i<9;i++)
        {
            mBoard[i]=i;
        }
    }

    public void setPlayerMove(int index)
    {
        mBoard[index]='X';
    }

    public int getComputerMove()
    {
        int index = 0;
        int tries = 0;
        while((mBoard[index]=='X'|| mBoard[index]=='O') && tries<mBoard.length)
        {
            index = (int)(Math.random()*((8)+1));
            tries++;
        }
        mBoard[index] = 'O';

        return index;
    }

    public int checkForWinner()
    {
        int result = 0;
        if(mBoard[0]=='O'&&mBoard[1]=='O'&& mBoard[2]=='O' ||
                mBoard[3]=='O'&&mBoard[4]=='O'&& mBoard[5]=='O' ||
                mBoard[6]=='O'&&mBoard[7]=='O'&& mBoard[8]=='O' ||
                mBoard[0]=='O'&&mBoard[3]=='O'&& mBoard[6]=='O' ||
                mBoard[1]=='O'&&mBoard[4]=='O'&& mBoard[7]=='O' ||
                mBoard[2]=='O'&&mBoard[5]=='O'&& mBoard[8]=='O' ||
                mBoard[0]=='O'&&mBoard[4]=='O'&& mBoard[8]=='O' ||
                mBoard[2]=='O'&&mBoard[4]=='O'&& mBoard[6]=='O')
            return  -1;

        if(mBoard[0]=='X'&&mBoard[1]=='X'&& mBoard[2]=='X' ||
                mBoard[3]=='X'&&mBoard[4]=='X'&& mBoard[5]=='X' ||
                mBoard[6]=='X'&&mBoard[7]=='X'&& mBoard[8]=='X' ||
                mBoard[0]=='X'&&mBoard[3]=='X'&& mBoard[6]=='X' ||
                mBoard[1]=='X'&&mBoard[4]=='X'&& mBoard[7]=='X' ||
                mBoard[2]=='X'&&mBoard[5]=='X'&& mBoard[8]=='X' ||
                mBoard[0]=='X'&&mBoard[4]=='X'&& mBoard[8]=='X' ||
                mBoard[2]=='X'&&mBoard[4]=='X'&& mBoard[6]=='X')
            return  1;

        return result;
    }


}
