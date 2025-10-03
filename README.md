# Desafio: Semáforo com Threads em Java

## Objetivo
Criar uma simulação de semáforo (trânsito) usando **Threads** em Java. O objetivo é exercitar sincronização entre threads, comunicação (wait/notify ou condicionais), e modelagem de concorrência.

## Descrição do problema
Simule um cruzamento simples com duas direções:
- **Norte-Sul (NS)**
- **Leste-Oeste (EO)**

A cada ciclo, **apenas uma direção** pode ter o sinal verde. O semáforo deve alternar entre NS e EO seguindo tempos configuráveis (por exemplo: verde 5s, amarelo 2s, vermelho conforme o outro verde).

Além disso, teremos várias threads representando **carros** que chegam ao cruzamento. Cada carro sabe sua direção (NS ou EO) e deve aguardar até que o sinal esteja favorável para atravessar. Quando o sinal estiver verde para sua direção, o carro atravessa (simulado por `sleep`) e então termina.

## Requisitos mínimos
1. Implementar uma classe `TrafficLight` (semáforo) que controla o estado (GREEN, YELLOW, RED) para cada direção.
2. Implementar uma classe `TrafficController` que alterna os sinais entre as direções em loop, respeitando tempos configuráveis.
3. Implementar uma classe `Car` que representa uma thread que:
    - especifica direção (NS ou EO),
    - aguarda o sinal verde para sua direção,
    - atravessa quando permitido.
4. Usar mecanismos de sincronização Java (`synchronized` + `wait/notify` **ou** `Lock` + `Condition`) para coordenar carros e o controlador.
5. Fornecer um `Main` que:
    - inicia o `TrafficController`,
    - cria várias threads `Car` em intervalos aleatórios para cada direção,
    - roda por um tempo determinado (por exemplo 60 segundos) ou até que todas as threads terminem.

## Critérios de avaliação
- Correta sincronização: nenhum carro deve atravessar quando o sinal está vermelho para sua direção.
- Alternância correta dos sinais seguindo os tempos.
- Código bem organizado e documentado.
- Uso consistente de boas práticas de concorrência.

## Checklist sugerido
- [ ] Modelar estados do semáforo (GREEN/YELLOW/RED).
- [ ] Implementar bloqueio/condição para cada direção.
- [ ] Implementar controlador que alterna sinais.
- [ ] Implementar carros que aguardam apropriadamente.
- [ ] Testar com múltiplas threads simultâneas.
- [ ] Comentários e JavaDoc básicos.

---

## Template inicial (sem solução)

```java
// TrafficLight.java
public class TrafficLight {
    public enum Direction { NS, EO }
    public enum State { GREEN, YELLOW, RED }

    // TODO: campos para estado atual de cada direção e tempos configuráveis

    public TrafficLight(int greenDurationSeconds, int yellowDurationSeconds) {
        // TODO: inicializar tempos e estados (por exemplo, NS green no início)
    }

    // TODO: métodos para o TrafficController alterar estados:
    // void setGreen(Direction d), void setYellow(Direction d), void setRed(Direction d)

    // TODO: método para os carros verificarem se podem atravessar:
    // boolean canCross(Direction d)

    // Opcional: métodos de sincronização (notifyAll/conditions) se usar wait/notify
}
```

```java
// TrafficController.java
public class TrafficController implements Runnable {
    private final TrafficLight light;
    private final int greenDurationSeconds;
    private final int yellowDurationSeconds;
    private volatile boolean running = true;

    public TrafficController(TrafficLight light, int greenDurationSeconds, int yellowDurationSeconds) {
        this.light = light;
        this.greenDurationSeconds = greenDurationSeconds;
        this.yellowDurationSeconds = yellowDurationSeconds;
    }

    public void shutdown() {
        running = false;
    }

    @Override
    public void run() {
        // TODO: loop alternando entre NS e EO:
        // setGreen(NS) -> sleep(green) -> setYellow(NS) -> sleep(yellow) -> setRed(NS) and setGreen(EO) ...
        // Use notify/notifyAll ou Condition.signalAll para acordar carros quando o sinal muda
    }
}
```

```java
// Car.java
public class Car implements Runnable {
    private final int id;
    private final TrafficLight.Direction direction;
    private final TrafficLight light;

    public Car(int id, TrafficLight.Direction direction, TrafficLight light) {
        this.id = id;
        this.direction = direction;
        this.light = light;
    }

    @Override
    public void run() {
        // TODO:
        // - registrar chegada (println)
        // - aguardar até light.canCross(direction) ser true
        // - atravessar (simular com sleep de 500-1500 ms)
        // - registrar saída (println)
    }
}
```

```java
// Main.java
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int green = 5;   // segundos
        int yellow = 2;  // segundos

        TrafficLight light = new TrafficLight(green, yellow);
        TrafficController controller = new TrafficController(light, green, yellow);
        Thread controllerThread = new Thread(controller, "Controller");
        controllerThread.start();

        // TODO: criar um pool de threads para carros e agendar chegadas aleatórias
        // por exemplo, gerar 30 carros em direções aleatórias com delays entre 0 e 500 ms

        // Ao final, chamar controller.shutdown() e aguardar encerramento
    }
}
```