package me.berkow.diffeval.message;

import me.berkow.diffeval.problem.Population;
import me.berkow.diffeval.problem.Problem;

import java.io.Serializable;


public class DETask implements Serializable {

    private final int maxIterationsCount;
    private final Population initialPopulation;
    private final float amplification;
    private final float crossoverProbability;
    private final Problem problem;
    private final float precision;

    public DETask(int maxIterationsCount, Population initialPopulation, float amplification, float convergence,
                  Problem problem, float precision) {
        this.maxIterationsCount = maxIterationsCount;
        this.initialPopulation = initialPopulation;
        this.amplification = amplification;
        this.crossoverProbability = convergence;
        this.problem = problem;
        this.precision = precision;
    }

    public int getMaxIterationsCount() {
        return maxIterationsCount;
    }

    public Population getInitialPopulation() {
        return initialPopulation;
    }

    public float getAmplification() {
        return amplification;
    }

    public float getCrossoverProbability() {
        return crossoverProbability;
    }

    public Problem getProblem() {
        return problem;
    }

    public int getPopulationSize() {
        return initialPopulation.size();
    }

    public float getPrecision() {
        return precision;
    }

    @Override
    public String toString() {
        return "DETask{" +
                "maxIterationsCount=" + maxIterationsCount +
                ", initialPopulation=" + initialPopulation +
                ", amplification=" + amplification +
                ", crossoverProbability=" + crossoverProbability +
                ", problem=" + problem +
                ", precision=" + precision +
                '}';
    }
}
