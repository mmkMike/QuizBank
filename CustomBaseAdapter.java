package com.example.quizbank;
//This class is for the listview of the questionBank for viewing the question bank.
//guide followed from:
// https://www.youtube.com/watch?v=aUFdgLSEl0g&t=125s
//adjusted to match an arraylist object.
public class CustomBaseAdapter extends BaseAdapter{

    Context context;
    ArrayList<Question> questionBank;
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, ArrayList<Question> a){
        this.context = ctx;
        this.questionBank = a;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount(){
        return questionBank.size();
    }
    @Override
    public Question getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = inflater.inflate(R.layout.questionBank_activity, root: null);
        TextView txtView = (TextView) convertView.findViewById(R.id.textview);
        //unsure if this outputs both question and answer on two seperate lines
        //or if it outputs one line as answer overwrites the question.
        //solve later
        txtView.setText(questionBank.toString(true,position));
        txtView.setText(questionBank.toString(false,position));
        return convertView;
    }
}