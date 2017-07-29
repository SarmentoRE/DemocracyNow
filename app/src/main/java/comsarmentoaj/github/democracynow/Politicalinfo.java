package comsarmentoaj.github.democracynow;

/**
 * Created by devin_000 on 7/29/2017.


public class Politicalinfo extends Application {
 private String Politicalinfo;

 public String getPoliticalinfo() {
        return Politicalinfo;

    }

 public void setPoliticalinfo(String Politcalinfo) {
        this.Politicalinfo = Politcalinfo;
    }
}
 */
public class Politicalinfo {
    private static Politicalinfo mInstance = null;
    public String politicalinfosingleton;

    protected Politicalinfo() {
    }

    public static synchronized Politicalinfo getInstance() {
        if (null == mInstance) {
            mInstance = new Politicalinfo();
        }
        return mInstance;
    }
}
