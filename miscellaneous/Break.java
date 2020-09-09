package miscellaneous;

public enum  Break {
    MORNING_TEA("11:00"),
    LUNCH("1:00"),
    EVENING_TEA("16:00")   ;

    private String time;

    Break(String time){
     this.time=time;
    }

    public String getTime(){
        return time;
    }

}
