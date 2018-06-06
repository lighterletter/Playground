package john.lighterletter.com.galileo;

import android.app.Application;

import com.facebook.soloader.SoLoader;

public class GalileoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
    }
}
