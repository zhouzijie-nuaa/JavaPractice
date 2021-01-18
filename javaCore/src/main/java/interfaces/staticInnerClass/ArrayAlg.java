package interfaces.staticInnerClass;

/**
 * author: zijiezhou
 * Date:   2020/10/17 16:41
 * Description:
 */
public class ArrayAlg {

    public static class pair{
        private double first;
        private double second;

        public pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    public static pair minmax(double[] values){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for(double v:values){
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
    }  return new pair(min,max);
    }

}
