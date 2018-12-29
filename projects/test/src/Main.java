public class Main {

    public static void main(String[] args) {
        String x = "xyz";
        x = x.toUpperCase(); /* Line 2 */
        String y = x.replace('Y', 'y');
        y = y + "abc";
        System.out.println(y);
    }
}
