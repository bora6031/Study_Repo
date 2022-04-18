# Java

### <컴파일 과정>

**자바의 특징**: 자바는 JVM(Java Virtual Machine) 때문에 OS에 독립적이다

1. 개발자가 소스코드를 작성
2. 자바 컴파일러가 자바소스파일을 컴파일→ 바이트 코드(.class) JVM이 이해할 수 있는 코드
    
    바이트 코드- 각 명령어는 1byte크기의 Opcode와 추가 피연산자로 구성
    
3. 컴파일된 바이크 코드를 JVM의 클래스 로더에게 전달
4. `클래스 로더`는 동적로딩을 통해 필요한 클래스를 로딩 및 링크하여 런타임 데이터영역(JVM의 메모리)에 올린다. 
5. 실행엔진은 JVM 메모리에 올라온 바이트 코드들을 명령어 단위로 하나씩 가져와서 실행. 밑의 두가지 방식으로 실행.
    - 인터프리터: 바이트 코드 명령어를 하나씩 읽어서 해석/실행
        - 하나하나의 실행은 빠르나, 전체적인 실행속도가 느림
    - JIT  컴파일러(Just-In-Time Compiler): 인터프리터의 단점을 보완하기 위해 도입된 방식으로 바이트 코드 전체를 컴파일하여 바이너리 코드로 변경하고 이후에 해당 메서드를 더이상 인터프리팅 하지 않고, 바이너리 코드로 직접 실행
        - 인터프리팅 방식보다 전체적인 실행속도는 빠르다.

### 클래스 로더 세부동작

1. 로드: 클래스 파일을 가져와서 JVM 메모리에 로드
2. 검증: 자바 언어명세 및 JVM 명세에 명시된 대로 구성되어 있는지 검사
3. 준비: 클래스가 필요로 하는 메모리를 할당(필드, 메서드, 인터페이스 등)
4. 분석: 클래스의 상수 풀 내 모든 심볼릭 레퍼런스를 다이렉트 레퍼런스로 변경
5. 초기화: 클래스 변수들을 적절한 값으로 초기화(static 필드)

### <Call By Balue& Call by reference>

- call by value: 값에 의한 호출
    - 함수가 호출될 때, 메모리 공간안에서 함수를 위한 별도의 임시공간이 생성
    - 함수 종료시 해당 공간 사라짐
    - 함수 호출 시 전달되는 변수 값을 복사해서 함수 인자로 전달
    - 이때 복사된 인자는 함수안에서 지역적으로 사용→ Local Value
    
    > 즉, 함수 안에서 인자값이 변경되더라도, 외부 변수값은 변경 안됨
    > 
- call by reference: 참조에 의한 호출
    - 함수 호출 시 인자로 전달되는 변수의 레퍼런스를 전달함
    
    > 즉, 함수의 인자값이 변경되면 전달된 객체의 값도 변경됨
    > 
    
    <aside>
    💡 JAVA에서 Call by reference는 해당 객체의 주소값을 직접 넘기는게 아닌 객체를 보는 또 다른 주소 값을 만들어서 넘긴다.
    
    </aside>
    

자바의 메서드 인자 전달 방식은 Call by value

여기서 value란? 객체에 대한 포인터값(레퍼런스) 또는 primitive 타입의 값

### <Primitive type& Reference type>

Java에는 기본형(Primitive type)과 참조형(Reference type)이 있다. 

```java
Java Data Type 
ㄴ Primitive Type
    ㄴ Boolean Type(boolean)
    ㄴ Numeric Type
        ㄴ Integral Type
            ㄴ Integer Type(short, int, long)
            ㄴ Floating Point Type(float, double)
        ㄴ Character Type(char)
ㄴ Reference Type
    ㄴ Class Type
    ㄴ Interface Type
    ㄴ Array Type
    ㄴ Enum Type
    ㄴ etc.
```

### Primitive type(기본형 타입)

- 자바는 8가지의 기본형 타입을 가진다
    - boolean(1byte), char, byte(이진데이터), short, int(정수연산), long, float, double
- 기본 자료형은 반드시 사용하기 전에 선언되어야 한다.
- OS에 비종속적이다(자료형의 길이가 변하지 않는다.)
- 비객체 타입이므로 null값을 가질 수 없다.
    - null값을 넣고 싶으면 Wrapper Class를 활용.
- 스택(Stack)메모리에 저장됨.
- byte ,short의 변수가 연산을 하면 결과는 int형이 됨.
- long 타입의 변수를 초기화 할 때에는 정수값 뒤에 L을 붙여야함
    - 아니면 컴파일 에러 발생
- float 보다 double이 보다 정밀하게 표현할 수  있음
- 실수의 기본타입은 double, float형의 변수 초기화시에는 F를 붙여서 float형임을 명시해 주어야 한다.

### Reference type(참조형 타입)

- primitive type을 제외한 모든 타입들이 Reference type
- Java에서 최상인 java.lang.Object 클래스를 상속하는 모든 클래스들을 말한다.
    - new로 생성하는 것들은 메모리 영역인 Heap영역에 생성
    - Garbage Collector가 돌면서 메모리 해제
- 클래스 타입(class type), 인터페이스 타입(interface type), 배열타입(array type), 열거타입(enum type)
- 빈 객체를 의미하는 null이 존재
- 문법상으로는 에러가 없지만 실행시켰을 때 에러가 나는 런타임 에러가 발생
    - 객체나 배열을 null값으로 받으면 NullPointException발생
- Heap 메모리에 생성된 인스턴스는 메소드나 각종 인터페이스에서 접근하기 위해 JVM의 Stack 영역에 존재하는 Frame에 일종의 포인터인 참조값을 가지고 있어 이를통해  인스턴스를 핸들링 함

### String Class

- 참조형에 속하지만 기본적인 사용은 기본형처럼 사용
- 불변 Immutable하는 객체
- .equals()메소드를 사용해서 비교해야함
- 값을 변경해주는 메소드가 존재하지만 이는 새로운 String클래스 객체를 만들어내는 것이다.

### <오토박싱& 언박싱>

자바에는 기본타입과 `Wrapper클래스` 가 존재한다. 

- 기본: int, long, float, double, boolean
- Wrapper 클래스: Integer, Long, Float, Double, Boolean

**박싱**

:기본 타입 데이터에 대응하는 Wrapper 클래스로 만드는 동작 

**언박싱**

: Wrapper 클래스에서  기본타입으로 변환

- JDK 1.5부터는 자바 컴파일러가 박싱과 언박싱이 필요한 상황에 자동으로 처리를 해준다.
- 성능적으로 오토박싱과 언박싱은 내부적으로 추가 연산작업을 거치므로 동일한 타입연산이 이루어지도록 구현해아한다.
- 불필요한 오토캐스팅으로 성능이 저하될 수 있다.

### <직렬화 _Serialization>

<aside>
💡 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 byte형태로 데이터 변환하는 기술

</aside>

- 각자 PC의 OS마다 서로 다른 가상 메모리 주소공간을 갖기 때문에, Reference Type의 데이터들은 인스턴스를 전달 할 수 없다.
- 즉, 주소값이 아닌 Byte형태로 직렬화된 객체 데이터를 전달해야 한다.
- 직렬화된 데이터는 모두 Primitive Type가 된다.
- 파일저장이나 네트워크 전송 시 파싱이 가능한 유의미한 데이터가 된다
- 전송 및 저장이 가능한 데이터로 만들어주는 것이 `직렬화`
- 자주 변경되는 클래스는 직렬화사용하면 안됨
- 역직렬화에 실패하는 상황 대비 예외처리 필수 구현
- 직렬화 데이터는 타입, 클래스 메타정보를 포함하므로 사이즈가 크다
    - JSON 포멧이 직렬화 데이터 포맷보다 2-10배 효율적

### 직렬화 조건

- java.io.Serializable 인터페이스 구현으로 직렬화/역직렬화가 가능하다.
    - 역직렬화: 직렬화된 데이터를 받는 쪽에서 다시 객체 데이터로 변환하기 위한 작업
- 직렬화 대상: 인터페이스 상속 받은 객체(Primitive타입이 아닌 객체), Primitive타입의 데이터

### 직렬화 상황

- JVM에 상주하는 객체 데이터를 영속화할 때 사용
    - 영속화?
- Servlet Session
- Cache
- Java RMI
