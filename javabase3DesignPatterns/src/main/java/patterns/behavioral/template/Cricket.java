package patterns.behavioral.template;

public class Cricket extends Game {

	@Override
	void initialize() {
		System.out.println("板球游戏初始化");
	}

	@Override
	void startPlay() {
		System.out.println("板球游戏开始");
	}

	@Override
	void endPlay() {
		System.out.println("板球游戏结束");
	}

}
