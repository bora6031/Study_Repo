# PCB& Context Switching

### Process Management

: CPU가 프로세스가 여러개일 때, CPU 스케줄링을 통해 관리하는 것을 말함 

- Process Metadata
    - Process ID
    - Process State
    - Process Priority
    - CPU Registers
    - Owner
    - CPU Usage
    - Memeory Usage
- 이 메타데이텉는 프로세스가 생성되면 PCB라는 곳에 저장됨

### PCB

: 프로세스 메타데이터들을 저장해 놓는 곳

- 한 PCB 안에는 한 프로세스의 정보가 담김
- 프로그램 실행→ 프로세스 생성→ 프로세스 주소공간에 생성→ 이 프로세스의 메타데이터들이 PCB에 저장
- 필요한 이유
    - CPU에서 프로세스의 상태에 따라 교체작업이 이루어 질 때, 앞으로 다시 수행할 대기중인 프로세스에 관한 저장값을 PCB에 저장해 둔다.
- Linked List 방식으로 관리

### Context Switching

: CPU가 이전의 프로세스 상태를 PCB에 보관하고, 또 다른 프로세스의 정보를 PCB에 읽어 레지스터에 적재하는 과정 

- 즉, 프로세스가 Ready → Running, Running → Ready, Running → Waiting처럼 상태 변경 시 발생
- Context Switching의 OverHead
    - 프로세스를 수행하다가 입출력 이벤트가 발생해서 대기 상태로 전환시킨다.
    - 이때, CPU를 그냥 놀게 놔두는 것보다 다른 프로세스를 수행시키는 것이 효율적이다.
    - 즉, Context Switching이란 CPU에 계속 프로세스를 수행시키도록 하기 위해서 다른 프로세스를 실행시키고 Context Swtiching 하는 것
    - CPU가 놀지 않도록 만들고, 사용자에게 바르게 일처리를 제공해 주기 위한 것
