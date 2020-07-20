package CS_Note.second.designpatterns.proxy.jingtai;

public class Cinema implements Movie {
    RealMovie movie;

    public Cinema(RealMovie movie) {
        this.movie = movie;
    }

    @Override
    public void play() {
        add(true);
        movie.play();
        add(false);
    }

    public void add(boolean isStart) {
        if (isStart) {
            System.out.println("通知: 电影马上开始");
        } else {
            System.out.println("通知: 电影马上结束");
        }
    }
}
