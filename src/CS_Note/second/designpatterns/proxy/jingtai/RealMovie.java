package CS_Note.second.designpatterns.proxy.jingtai;

public class RealMovie implements Movie {

    @Override
    public void play() {
        System.out.println("电影播放");
    }
}
