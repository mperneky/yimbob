package object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Matyas_Perneky
 */
@Entity
@Table(name="QuestionsDB")
public class SqlQuestion {
    @Id
    @Column(name="id")
    private int id;
    @Id
    @Column(name="Question")
    private String question;
    @Id
    @Column(name="Answer")
    private String answer;

    public SqlQuestion() {
    }

    public SqlQuestion(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
