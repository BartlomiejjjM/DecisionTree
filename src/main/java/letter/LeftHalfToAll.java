package letter;

public class LeftHalfToAll implements Trait {
    @Override
    public double calculate(Letter value) {
        boolean[][] image = value.getImage();
        int matchingPixels = 0;
        int otherPixels = 0;
        int center = image.length/2;

        for (int i = 0; i < image.length ; i++) {
            for (int j = 0; j <image[0].length ; j++) {
                if (image[i][j]){
                    if (j < center){
                        matchingPixels++;
                    }
                    else {otherPixels++; }
                }
            }
        }
        if (matchingPixels == 0){return 0;}
        return (double) matchingPixels/(matchingPixels+otherPixels);
    }
}
