import java.util.ArrayList;

class QuestionBank {
  ArrayList<qna> questionBank; 
  
  public qna viewBank(int i){
    return questionBank.get(i);
  }
  public void addQuestion(qna q){
    questionBank.add(q);
  }
  public void importQuestion(){
    System.out.println("Debug importQuestion");
  }
}