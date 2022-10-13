package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        /*Stream<String[]> image1 = Stream.concat(Arrays.stream(image), Arrays.stream(image));
        //Stream<String> image2 = image1.flatMap(Arrays::stream);
        //Stream<String> image3 = Stream.concat(image2, image2);
        //return image1(user -> Stream.concat(user, user))
        return image1
                .toArray(String[][]::new);*/
        if (Arrays.deepEquals(image, new String[0][0])) {
            return new String[0][0];
        }
        String[][] twoImage = new String[image.length * 2][image[0].length * 2];
        var i = 0;
        var l = 0;
        while (i < twoImage.length) {
            var j = 0;
            var k = 0;
            while (j < twoImage[0].length) {
                twoImage[i][j] = image[l][k];
                twoImage[i][j + 1] = image[l][k];
                j += 2;
                k++;
            }
            i ++;
            if (i % 2 == 0) {
                l++;
            }
        }
        return twoImage;
    }
}
// END
