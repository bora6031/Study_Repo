# ****Garbage Collection****

### Garbage Collection

: 유효하지 않은 메모리(Garbage)를 제거해주는 것

- 메모리 누수 방지를 위해 가비지 컬렉터가 주기적으로 검사하여 메모리를 청소 해준다.

### Minor GC와 Major GC

JVM의 Heap영역은 처음 설계될 때 다음의 2가지를 전제(Weak Generational Hypothesis)로 설계되었다.

- 대부분의 객체는 금방 접근 불가능한 상태(Unreachable)가 된다.
- 오래된 객체에서 새로운 객체로의 참조는 아주 적게 존재한다.

> 즉, 객체는 대부분 일회성되며, 메모리에 오랫동안 남아있는 경우는 드물다
> 

→ 객체의 생존 기간에 따라 물리적인 Heap영역을 나누어 설계되었다. 

- **Young 영역(Young Generation)**
    - 새롭게 생성된 객체가 할당(Allocation)되는 영역
    - 금방 Unreachable 상태가 되기 때문에, 많은 객체가 Young 영역에 생성되었다가 사라진다
    - Young 영역에 대한 가비지 컬렉션(Garbage Collection)을 Minor GC라고 부른다.
- **Old 영역(Old Generation)**
    - Young영역에서 Reachable 상태를 유지하여 살아남은 객체가 복사되는 영역
    - Young 영역보다 크게 할당되며, 영역의 크기가 큰 만큼 가비지는 적게 발생한다.
    - Old 영역에 대한 가비지 컬렉션(Garbage Collection)을 Major GC 또는 Full GC라고 부른다.
    

### Garbage Collection의 동작방식

### 1. stop-the-world

: Gc를 실행하기 위해 JVM이 애플리케이션 실행을 멈추는 것 

- stop-the-world가 발생하면 GC를 실행하는 쓰레드를 제외한 나머지 쓰레드는 모두 작업을 멈춘다.
- GC의 작업이 완료한 이후에야 중단했던 작업을 다시 시작한다.
- GC의 성능 개선을 위해 튜닝을 한다고 했을때 시간을 줄이는 부분

### 2. Mark and Sweep

- Mark: 사용되는 메모리와 사용되지 않는 메모리를 식별하는작업
- Sweep: Mark단계에서 사용되지 않음으로 식별된 메모리를 해제하는 작업

### Garbage Collection의 종류

- Minor GC
    - Young Generation을 대상으로 한다.
    - Eden 영역이 꽉 찬경우 실행된다
    - 빠르다
- Major GC
    - Old Generation을 대상으로 한다.
    - Old 영역이 꽉 찬경우 실행된다
    - 느리다
