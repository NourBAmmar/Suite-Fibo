package com.example.fibb1;

public class Fibo {
    private long U1;
    private long U0;


    Fibo() {
        U0=0;
        this.U1 =0;

    }
    public long getU1() {
        return U1;
    }
    public long Next ()
    {
        if (U0==0) {
            U1=1;
            U0=1;
        }
        else if (U0==4||U0<0)
            U1=4;
        else {
            long x =U1;
            U1 = U0 + U1;
            U0 = x;
            }
        return U1;
    }
}
