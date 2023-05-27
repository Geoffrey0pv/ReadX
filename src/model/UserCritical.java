package model;
import java.util.Date;

public class UserCritical extends UserPremium {
    private String area;
    private int criticsCount;
    private String blog;
    private boolean winSurprise = false;
    Date date;

public UserCritical(String name, TypeID typeId, int id, Date date, String email, String creditCard, String avatar, String area, String blog, int criticsCount){
    super(name, typeId, id, date, email, creditCard, avatar);
    this.area = area;
    this.blog = blog;
    this.criticsCount = criticsCount;
    this.date = date;
}
@Override
public String toString() {
    // TODO Auto-generated method stub
    return super.toString() + "\n* Blog: " + blog +
            "\n* Area: " + area +
            "\n* Critics number: " + criticsCount;
}
@Override
    public String surprise(int moth, char firstletter, int criticsCountsurprise) {
        String message;

        super.surprise(moth, firstletter, criticsCount);

        if(criticsCount >= criticsCountsurprise && !winSurprise){
            message = "\nCongratulations you win a travel to san Andres yeaaahhh body: \n" + getName();
            winSurprise = true;
        } else {
        message = "The user Critical: " + getName() + " No wins";
        }
        return message;
    }
    public int getCriticsCount(){
        return criticsCount;
    }
}
