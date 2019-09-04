package com.example.fibb1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

        private List<Long> U;
        private RecyclerView rv;
        boolean isScrolling=false;
        int currentItems, totalItems, scrollOutItems;
        LinearLayoutManager llm;
        RVAdapter adapter;
        Fibo f=new Fibo();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            rv=findViewById(R.id.rv);
            llm = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            rv.setHasFixedSize(true);
            initializeData();
            initializeAdapter();
            rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    {
                        isScrolling = true;
                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    currentItems = llm.getChildCount();
                    totalItems = llm.getItemCount();
                    scrollOutItems = llm.findFirstVisibleItemPosition();

                    if(isScrolling && (currentItems + scrollOutItems == totalItems))
                    {
                        isScrolling = false;
                        getData();
                    }
                }
            });
        }

        private void getData() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (int i=1;i<5;i++)
                    {
                       if (f.getU1()!=4)
                       {U.add(f.getU1());
                        f.Next();
                        adapter.notifyDataSetChanged();
                       }
                        else
                       {
                           Toast.makeText(getApplicationContext(),"OverFlow! Ce terme dépasse la capacite d un LONG ",Toast.LENGTH_SHORT).show();
                       }
                    }
                }
            }, 500);
        }

        private void initializeData(){
            U = new ArrayList<>();
            U.add(f.getU1());
            f.Next();
            U.add(f.getU1());
            f.Next();
            U.add(f.getU1());
            f.Next();
            U.add(f.getU1());
            f.Next();
            U.add(f.getU1());
            f.Next();
            U.add(f.getU1());
            f.Next();
            U.add(f.getU1());
            f.Next();
            U.add(f.getU1());
            f.Next();
            U.add(f.getU1());
            f.Next();

        }

        private void initializeAdapter(){
            adapter = new RVAdapter(U);
            rv.setAdapter(adapter);
        }
    }

