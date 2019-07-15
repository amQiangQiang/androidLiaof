package xxq.wlxy.dayfive;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    public  static List<Activity> activities = new ArrayList<Activity>();
    public static  void addActivity(Activity activity){
        activities.add(activity);
    }
    public static  void removeActivity(Activity activity){
        activities.remove(activity);

    }
    public static void finishAll(){
        for (Activity activity:activities)
            //isFinishing() 可用来判断Activity是否处于活跃状态（false）还是等待回收状态（true）。
            if(!activity.isFinishing())
                activity.finish();
    }
}
