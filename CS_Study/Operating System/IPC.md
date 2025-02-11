# IPC

: 프로세스 간의 통신 

- 프로세스는 커널이 제공하는 IPC 설비를 이용해 프로세스간 통신을 할 수 있게 된다

<aside>
💡 커널이란? 운영체제의 핵심적인 부분으로, 다른 모든 부분에 여러 기본적인 서비스를 제공해줌

</aside>

## IPC 종류

1. 익명 PIPE
- 파이프는 두개의 프로세스를 연결하는데 하나의 프로세스는 데이터를 쓰기만 하고, 다른 하나는 데이터를 읽기만 할 수 있다.
- 한쪽 방향으로만 통신이 가능한 반 이중 통신
- 양쪽으로 모두 송/수신하고 싶으면 2개의 파이프를 만들어야 한다.
- 간단하다
- 전이중 통신을 위해 2개를 만들때에는 구현이 복잡해진다.

1. Named PIPE
- 익명 파이프는 통신할 프로세스를 명확히 알 수 있는 경우에 사용
- 전혀 모르는 상태의 프로세스들 사이 통신에 사용
- 부모 프로세스와 무관한 다른 프로세스도 통신이 가능
- 읽기 쓰기가 동시에 불가능하다
- 양쪽으로 모두 송/수신하고 싶으면 2개의 파이프를 만들어야 한다.

1. Message Queue
- 입출력 방신은 Named PIPE와 동일
- 다른점은 메세지 큐는 파이프처럼 데이터의 흐름이 아니라 메모리 공간이다.
- 사용할 데이터에 번호를 붙이면서 여러 프로세스가 동시에 데이터를 쉽게 다룰 수 있다.

 

1. 공유 메모리
- 데이터 자체를 공유하도록 지원하는 설비
- 프로세스간 메모리 영역을 공유해서 사용할 수 있도록 허용
- 중계자 없이 곧바로 메모리에 접근할 수 있어서 IPC 중에 가장 빠르게 작동

1. 메모리 맵
- 공유 메모리처럼 메모리를 공유
- 열린파일을 메모리에 맵핑시켜서 공유
- 주로 파일로 대용량 데이터를 공유해야 할 때 사용

1. 소켓
- 네트워크 소켓 통신을 통해 데이터를 공유
- 클라이언트와 서버가 소켓을 통해서 통신하는 구조
- 원격에서 프로세스 간 데이터를 공유할 때 사용
