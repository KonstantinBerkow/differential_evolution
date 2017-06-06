package me.berkow.diffeval.problem;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by konstantinberkow on 5/11/17.
 */
public abstract class Problem implements Serializable {

    private final float[] lowerConstraints;
    private final float[] upperConstraints;

    public Problem(float[] lowerConstraints, float[] upperConstraints) {
        this.lowerConstraints = lowerConstraints;
        this.upperConstraints = upperConstraints;
    }

    public float[] getLowerConstraints() {
        return lowerConstraints;
    }

    public float[] getUpperConstraints() {
        return upperConstraints;
    }

    public int getSize() {
        return lowerConstraints.length;
    }

    public abstract float calculate(Member vector);

    @Override
    public String toString() {
        return "Problem{" +
                "lowerConstraints=" + Arrays.toString(lowerConstraints) +
                ", upperConstraints=" + Arrays.toString(upperConstraints) +
                '}';
    }
}
