package com.anuja.android;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BookListActivity extends Activity implements OnItemClickListener {
	
	private ListView bookListView;
	private TextView rawTextView;
	private ArrayList<Book> bookArray;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_listview);
        
        // To show the books in a list
        bookListView = (ListView) findViewById(R.id.booksListView);
        
        // We pass this bookArray to our CustomAdapter
        bookArray = new ArrayList<Book>();
        
        // Setting values to books
        for( int i=20; i<50; i++){
        	Book aBookDetail = new Book();
        	aBookDetail.setBookIsbn(i);
        	aBookDetail.setBookName("Book name : " + i);
        	aBookDetail.setBookAutorName("Book author : " + i);
        	
        	bookArray.add(aBookDetail);
        }
        
        // Initialize our Adapter and plug it to the ListView
        CustomAdapter customAdapter = new CustomAdapter(bookArray);
        bookListView.setAdapter(customAdapter);     
        
        // Activate the Click even of the List items
        bookListView.setOnItemClickListener(this);
    }
	
    // Regular inner class which act as the Adapter
	public class CustomAdapter extends BaseAdapter{
		private ArrayList<Book> innerClassBookArray;

		public CustomAdapter(ArrayList<Book> paraBookArray) {
			System.out.println("*** 1 CustomAdapter constructor");
			innerClassBookArray = paraBookArray;
		}

		// How many items are in the data set represented by this Adapter.
		@Override
		public int getCount() {
			System.out.println("*** 2 getCount method");
			System.out.println(innerClassBookArray.size());
			return innerClassBookArray.size();
		}

		// Get the data item associated with the specified position in the data set.
		@Override
		public Object getItem(int position) {
			System.out.println("*** ? getItem method");
			System.out.println(innerClassBookArray.get(position));
			return innerClassBookArray.get(position);
		}

		// Get the row id associated with the specified position in the list.
		@Override
		public long getItemId(int position) {
			System.out.println("*** 3 getItemId method");
			System.out.println(innerClassBookArray.get(position).getBookIsbn());
			return innerClassBookArray.get(position).getBookIsbn();
		}

		// Get a View that displays the data at the specified position in the data set.
		// You can either create a View manually or inflate it from an XML layout file. 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			System.out.println("*** 4 getView method");
			System.out.println(position);
			
			if(convertView == null){
				// LayoutInflater class is used to instantiate layout XML file into its corresponding View objects.
				LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				convertView = layoutInflater.inflate(R.layout.one_raw_of_list, null);
			}
			
			rawTextView = (TextView) convertView.findViewById(R.id.rawTextView);			
			rawTextView.setText(innerClassBookArray.get(position).getBookName());
			
			return convertView;
		}		
	}
	

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// arg2 = the id of the item in our view (List/Grid) that we clicked
		// arg3 = the id of the item that we have clicked
		// if we didn't assign any id for the Object (Book) the arg3 value is 0
		// That means if we comment, aBookDetail.setBookIsbn(i); arg3 value become 0
		Toast.makeText(getApplicationContext(), "You clicked on position : " + arg2 + " and id : " + arg3, Toast.LENGTH_LONG).show();
	}
}