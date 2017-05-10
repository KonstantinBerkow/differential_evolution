package me.berkow.diffeval;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.OnComplete;
import akka.pattern.Patterns;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by konstantinberkow on 5/10/17.
 */
public class DEFrontendMain {

    public static void main(String[] args) {
        // Override the configuration of the port when specified as program argument
        final String port = args.length > 0 ? args[0] : "0";
        final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port).
                withFallback(ConfigFactory.parseString("akka.cluster.roles = [frontend]")).
                withFallback(ConfigFactory.load());

        final ActorSystem system = ActorSystem.create("DifferentialEvolution", config);

        final Props taskActorProps = Props.create(DifferentialEvolutionTaskActor.class, port);

        final ActorRef taskActorRef = system.actorOf(taskActorProps, "frontend");

        final MainDETask task = new MainDETask(1, 100, 10, new double[]{-1, -1, -1}, new double[]{1, 1, 1});

        system.scheduler().scheduleOnce(FiniteDuration.apply(10, TimeUnit.SECONDS), new Runnable() {
            @Override
            public void run() {
                Future<Object> result = Patterns.ask(taskActorRef, task, 100000);

                result.onComplete(new OnComplete<Object>() {
                    @Override
                    public void onComplete(Throwable failure, Object success) throws Throwable {
                        if (failure != null) {
                            system.log().error(failure, "Failed to calculate task: {}", task);
                        } else {
                            system.log().info("Result of {} calculations is {}", task, success);
                        }
                    }
                }, system.dispatcher());
            }
        }, system.dispatcher());
    }
}