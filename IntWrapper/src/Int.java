public class Int {
    int val;

    void setValue(int val) {
        this.val = val;
    }

    public static Int valueOf(int val) {
        Int instance = new Int();
        instance.setValue(val);
        return instance;
    }

    public short shortValue() {
        short sval = (short)(val % (1 << 15));
        if (0 > val &&  0 == sval) {
            sval = -(1 << 15);
        }

        return sval;
    }

    public int intValue() {
        return val;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Int i = (Int)o;
        return val == i.intValue();
    }

    public String toString() {
        return String.valueOf(val);
    }
}