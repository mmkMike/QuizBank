import java.util.ArrayList;

class QuestionBank {
  ArrayList<questionAnswer> questionBank; 
  
  public questionAnswer viewBank(int i){
    return questionBank.get(i);
  }
  public void addQuestion(questionAnswer q){
    questionBank.add(q);
  }
  public void importQuestion(){
    System.out.println("Debug importQuestion");
  }
}