package app;

public class FrameBatDau {
	public static void main(String[] args) {
		SpalshScreen sc = new SpalshScreen();
		NewSignin sign = new NewSignin();
		sc.setVisible(true);
		try {
			for (int row = 0; row <=100; row++) {
                Thread.sleep(50);
                sc.loadingNumber.setText(Integer.toString(row)+"%");
                sc.loading.setValue(row);
                if (row == 100) {               
                    sc.setVisible(false);
                    sign.setVisible(true);
                }
            }
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
