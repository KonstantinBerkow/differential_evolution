package me.berkow.diffeval.message;

import me.berkow.diffeval.problem.Population;
import me.berkow.diffeval.Problem;
import me.berkow.diffeval.problem.ProblemsKt;

import java.io.Serializable;


public class SubResult implements Serializable {
    private final Population population;
    private final float amplification;
    private final float crossoverProbability;
    private final Problem problem;
    private final String type;
    private final int iterationsCount;
    private float value = Float.NaN;

    public SubResult(Population population, float amplification, float crossoverProbability, Problem problem,
                     String type, int iterationsCount) {
        this.population = population;
        this.amplification = amplification;
        this.crossoverProbability = crossoverProbability;
        this.problem = problem;
        this.type = type;
        this.iterationsCount = iterationsCount;
    }

    public SubResult(Population population, float amplification, float crossoverProbability, Problem problem,
                     String type, int iterationsCount, float value) {
        this(population, amplification, crossoverProbability, problem, type, iterationsCount);
        this.value = value;
    }

    public Population getPopulation() {
        return population;
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

    public float getValue() {
        if (Float.isNaN(value)) {
            value = ProblemsKt.averageValue(population, problem);
        }
        return value;
    }

    public String getType() {
        return type;
    }

    public int getIterationsCount() {
        return iterationsCount;
    }
}
