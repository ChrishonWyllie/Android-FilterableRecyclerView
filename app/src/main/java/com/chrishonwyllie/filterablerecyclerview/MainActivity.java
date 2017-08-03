package com.chrishonwyllie.filterablerecyclerview;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare new ArrayList object to hold data that will be shown in recyclerview
    // In Twitter, this likely holds some Custom Object such as "Twitter-Feed-Item"
    private List<ListObject> recyclerViewData;

    // Declare RecyclerView widget that is present in this fragment
    private RecyclerView recyclerView;

    // Declare RecyclerViewAdapter object. This is a custom RecyclerView.Adapter
    // It could have been named anything, such as "TwitterHomeFeedAdapter"
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate ArrayList
        recyclerViewData = new ArrayList<ListObject>();

        // This function does what its method signature says, creates some dummy data to be displayed in recycler view
        createSomeDummyDataForRecyclerView();

        // Instantiate RecyclerView from rootView (fragment_one.xml)
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // Instantiate adapter to display data
        adapter = new RecyclerViewAdapter(recyclerViewData, this);

        // Set the adapter for the recyclerview
        recyclerView.setAdapter(adapter);

        // Set which kind of layout this recycler view will display.
        // A GridLayoutManager is capable of displaying rows with multiple columns like an image gallery
        // A StaggeredGridLayoutManager does what the above does as well, but with uneven row heights
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void createSomeDummyDataForRecyclerView() {

        // These strings are generated from this website: https://randomwordgenerator.com/sentence.php


        ListObject listObject1 = new ListObject("The memory we used to share is no longer coherent.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject1);
        ListObject listObject2 = new ListObject("I'd rather be a bird than a fish.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject2);
        ListObject listObject3 = new ListObject("Italy is my favorite country; in fact, I plan to spend two weeks there next year.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject3);
        ListObject listObject4 = new ListObject("When I was little I had a car door slammed shut on my hand. I still remember it quite vividly.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject4);
        ListObject listObject5 = new ListObject("Writing a list of random sentences is harder than I initially thought it would be.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject5);
        ListObject listObject6 = new ListObject("I often see the time 11:11 or 12:34 on clocks.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject6);
        ListObject listObject7 = new ListObject("What was the person thinking when they discovered cow’s milk was fine for human consumption… and why did they do it in the first place!?", UUID.randomUUID().toString());
        recyclerViewData.add(listObject7);
        ListObject listObject8 = new ListObject("Let me help you with your baggage.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject8);
        ListObject listObject9 = new ListObject("Check back tomorrow; I will see if the book has arrived.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject9);
        ListObject listObject10 = new ListObject("He ran out of money, so he had to stop playing poker.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject10);
        ListObject listObject11 = new ListObject("If the Easter Bunny and the Tooth Fairy had babies would they take your teeth and leave chocolate for you?", UUID.randomUUID().toString());
        recyclerViewData.add(listObject11);
        ListObject listObject12 = new ListObject("I will never be this young again. Ever. Oh damn… I just got older", UUID.randomUUID().toString());
        recyclerViewData.add(listObject12);
        ListObject listObject13 = new ListObject("The river stole the gods.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject13);
        ListObject listObject14 = new ListObject("Rock music approaches at high velocity.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject14);
        ListObject listObject15 = new ListObject("When I was little I had a car door slammed shut on my hand. I still remember it quite vividly.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject15);
        ListObject listObject16 = new ListObject("I really want to go to work, but I am too sick to drive.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject16);
        ListObject listObject17 = new ListObject("There were white out conditions in the town; subsequently, the roads were impassable.", UUID.randomUUID().toString());
        recyclerViewData.add(listObject17);
        ListObject listObject18 = new ListObject("This is the last random sentence I will be writing and I am going to stop mid-sent", UUID.randomUUID().toString());
        recyclerViewData.add(listObject18);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        //adapter.filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //adapter.filter(newText);
        adapter.getFilter().filter(newText);
        return false;
    }
}
