# 가상화(Virtualization)
## 가상화란 무엇이며, 왜 운영 체제에서 중요한가요?
> 가상화
- 물리적인 자원을 논리적으로 분리하거나 통합하여, 가상의 환경에서 효율적으로 사용할 수 있게 하는 기술.
  
> 운영체제에서 중요한 이유 
- 물리적 서버 하나에 여러 운영 체제를 실행할 수 있어서 하드웨어 자원의 사용률을 최적화 할 수 있음
- 가상화를 통해 물리적 하드웨어를 추가하지 않고도 새로운 애플리케이션을 배포하거나 테스트 등 서비스 확장에 유리
- 다양한 애플리케이션 실행 시, 가상화를 통해 각 애플리케이션을 독립된 상황에서 실행할 수 있어서 애플리케이션 간의 격리성 강화

## 운영 체제가 CPU, 메모리, 디스크를 가상화한 것은 무엇인가요?
> CPU 가상화
- 물리적인 CPU 자원을 추상화하여, 여러 가상 머신이 물리적 CPU를 공유할 수 있게 만드는 기술
- 하이퍼바이저에 의해 관리되며, 가상 머신이 독립된 CPU를 사용하는 것처럼 동작하도록 함
  + 하이퍼바이저 : 가상 머신 간의 CPU 자원 사용을 관리하고 스케줄링하며 물리적 CPU에 대한 접근을 중재

> 메모리 가상화 ( 가상메모리 )
- 프로세스가 실제 물리적 메모리(RAM)보다 큰 메모리 공간을 사용하는 것처럼 보이게 하는 메모리 관리 기법
- 주요 키워드
  + 가상 주소 : 각 프로세스가 사용하는 메모리 주소 공간
  + 물리적 주소 : 실제 물리적 메모리에서의 데이터 저장 위치, 운영체제가 가상 주소를 물리적 주소로 변환하여 메모리에 접근
  + 페이징 : 가상 주소 공간과 물리적 메모리 공간을 고정된 크기의 블록으로 나누어 관리하는 방법
  + 페이지 : 가상 메모리의 블록 단위
  + 페이지 프레임 : 물리적 메모리의 블록 단위. 페이지와 동일한 크기로 나누어지며 운영체제는 각 페이지를 페이지 프레임에 매핑
  + 페이지 테이블 : 페이지와 페이지 프레임의 매핑 정보를 저장하는 데이터 구조. 프로세스마다 페이지 테이블은 따로 존재
  + 주소 변환 : OS는 MMU(Memory Management Unit)라는 하드웨어 장치를 통해 가상 주소를 물리적 주소로 변환
  + 프로세스가 특정 가상 주소에 접근하면 MMU는 페이지 테이블을 참조하여 해당 가상 주소에 매핑된 물리적 주소를 찾고, 접근함
  + 페이지 폴트(Page Fault) : 프로세스가 물리적 메모리에 존재하지 않는 페이지를 접근하려고 할때 발생하는 것
  + 운영체제는 페이지 폴트가 발생하면 해당 페이지를 디스크의 스왑(swap) 영역에서 물리적 메모리에 로드
  + 스왑(Swap) 영역 : OS는 물리적 메모리가 부족할때, 사용하지 않는 페이지를 디스크의 스왑영역에 임시로 저장하고 필요할때 다시 물리적 메모리로 호출
- 각 프로세스에게 독립된 메모리 공간을 제공하고 메모리 보호와 자원 관리를 최적화
- 페이지 폴트가 자주 발생하면 디스크I/O가 증가하게 되어 성능 저하 발생 (스래싱, Thrashing). 복잡한 메모리 관리

> 디스크 가상화 ( File system )
- 블록 단위로 물리적 디스크를 나누고, 블록들을 논리적으로 구성하여 파일과 디렉토리를 저장할 수 있는 구조 제공 

## 운영체제에서 커널이란 무엇이며 시스템 콜에 대해서 설명해주세요
> 커널이란? 
- 운영체제의 핵심으로 컴퓨터 자원(CPU, 메모리, 파일, 네트워크 입출력 장치 등)들을 관리하는 역할을 수행 

> 시스템 콜
- 응용 프로그램이 커널의 기능을 요청할 때 사용하는 인터페이스 (사용자가 작성한 프로그램은 커널에 직접 접근이 불가능) 
- 프로세스 제어(프로세스 생성, 종료, 메모리 할당 등 ), 파일 조작(파일 생성, 삭제, 읽기, 쓰기 등), 장치 관리(장치 요청 및 해제, 읽기, 쓰기 등), 정보 유지(시간 확인, 프로세스, 파일, 디바이스 속성 가져오기 등), 통신, 보안 

> 응용 프로그램 동작 예시
- 사용자가 "test.txt" 파일 클릭 -> 메모장 프로그램은 커널의 도움을 받기 위해 시스템 콜(open()) 호출 -> 커널은 받은 요청을 보고 파일 시스템을 통해 "test.txt" 파일이 실제 디스크에 있는지 확인하고, 해당 파일에 접근할 수 있는 파일 디스크립터 반환 -> 이후 메모장 프로그램은 파일의 내용을 읽기위해 시스템 콜(read()) 호출 -> 커널은 디스크에서 파일 내용 읽어서 메모장 프로그램에 반환 
- 즉, 커널은 하드웨어 자원 관리, 사용자와 응용 프로그램이 요청한느 다양한 작업 처리
- 시스템 콜은 응용 프로그램이 커널에 자원을 요청할때 사용하는 인터페이스 

https://goodmilktea.tistory.com/23

## 인터럽트란 무엇이며 인터럽트와 시스템 콜의 차이점에 대해서 설명해주세요.
> 인터럽트(Interrupt)
- CPU가 현재 수행 중인 작업을 일시 중단하고, 외부 하드웨어나 소프트웨어 예외에 대응할 수 있게 하는 메커니즘 

> 인터럽트와 시스템 콜의 차이점
- 인터럽트는 주로 비동기적 이벤트로 CPU가 즉각적으로 현재 작업을 중단하고 처리할 때 사용됨. 키보드 입력, 네트워크 수신 등 예기치 않은 상황에 대응할 수 있도록 시스템의 반응성 향상
- 시스템 콜은 사용자 프로그램이 커널의 기능을 사용하기 위해 명시적으로 요청하는 주로 동기적 이벤트. 프로그램이 파일을 열거나 메모리를 할당할 때 시스템 콜을 호출하여 커널에게 작업을 요청. 

## 멀티프로세싱 시스템에서 스케줄링이 중요한 이유는 무엇인가?
> 멀티 프로세싱이란?
- 다수의 CPU를 사용하여 동시에 여러 작업을 병렬로 처리할 수 있는 시스템
- 성능 향상, 확장성 <-> 복잡한 동기화, 비용 증가

> 스케줄링이 중요한 이유
- 스케줄링 : 여러 개의 CPU가 작업을 효율적으로 수행할 수 있도록 프로세스나 스레드에 CPU 시간을 할당하는 작업
- 여러 CPU에 작업을 효율적으로 분배하여 시스템 성능을 극대화 하기 위함. 스케줄링을 통해 CPU 자원을 최대한 활용하고, 응답 시간과 처리 시간을 최적화하며 자원을 공정하게 배분해야함. 이를 통해 시스템의 처리량을 높이고 프로세스간의 동시성을 관리. 

https://inpa.tistory.com/entry/%F0%9F%91%A9%E2%80%8D%F0%9F%92%BB-multi-programming-tasking-processing

## 컨텍스트 스위칭이란 무엇이며, 컨텍스트 스위칭에 따라 오버헤드가 발생하는 이유가 무엇인가요?
- CPU가 현재 실행 중인 프로세스의 상태를 저장하고, 다른 프로세스의 상태 및 정보를 읽어 실행을 전환하는 과정 

> context switching 과정
1. 현재 프로세스 상태 저장
   - 레지스터 저장 : CPU는 현재 실행중인 프로세스의 레지스터값(프로그램 카운터, 스택 포인터 등)을 해당 프로세스의 PCB에 저장
2. 스케줄러에 의해 새로운 프로세스 선택
   - 스케줄러가 실행되어 다음에 CPU에 사용할 프로세스를 선택. 스케줄러는 우선순위, 대기 시간 등을 기준으로 다음 프로세스 결정
3. 새로운 프로세스의 상태 복원
  - 레지스터 복원 : 스케줄러에 의해 선택된 프로세스의 PCB에 저장되어 있던 레지스터 정보들을 CPU 레지스터에 다시 로드
  - 프로그램 카운터 복원 : 이전에 해당 프로세스가 중단되었던 위치에서부터 명령어 실행을 재개
  - 메모리 매핑 : 프로세스가 사용하는 가상 메모리 주소를 실제 메모리에 매핑하는 페이지 테이블 등의 정보 복원
4. 복원된 상태 정보를 바탕으로 새로운 프로세스 실행 

> context switching에서 오버헤드가 발생하는 이유는?
- 위에 처럼 context switching 과정 중에 CPU가 프로세스간에 전환 수행시에 필요한 추가 작업들로 인해 오버헤드가 발생할 수 있음
1. 현재 프로세스 저장시에도 레지스터 값을 PCB로 저장하는 과정에서 CPU는 실제 작업을 수행하지않고, 저장하는 작업을 하고있으므로 오버헤드 발생
2. 스케줄러 알고리즘이 실행되어 선택하는 과정에도 오버헤드 발생 가능 
3. 캐시미스와 같은 메모리와 관련된 작업 전환시에 오버헤드 발생 가능
   - 캐시미스 : 프로세스 전환 시 이전 프로세스의 데이터가 캐시에 저장되어 있다가 새로운 프로세스가 로드되면 캐시의 기존 데이터는 무효화 되며 이때 캐시 미스가 발생. 이 경우 CPU는 메모리에서 새로운 데이터를 다시 로드해야하므로 추가적인 리소스 소비

## CPU 스케줄링 알고리즘의 종류와 특징은?(라운드 로빈, 우선순위 스케줄링, 멀티 레벨 큐)
> 라운드 로빈 (Round Robin)
- 선점형 스케줄링의 하나로, 프로세스들 사이에 우선순위를 두지않고, 순서대로 시간단위로 CPU를 할당하는 방식의 스케줄링 알고리즘
- 모든 프로세스는 동일한 시간 단위를 할당받으며, 할당 시간이 종료되면 대기열의 맨 뒤로 이동하고 다음 프로세스 실행
- 구현이 간단하지만, 타임 슬라이스 설정이 적절하지 못한 경우 성능이 저하될수 있고, 컨택스트 스위칭 비용이 증가할 수 있음(짧은 타임 슬라이스의 경우 프로세스간의 전환이 자주 발생시) 

> 우선순위 스케줄링 (Priority Scheduling)
- 각 프로세스의 우선순위 값을 할당하고, 우선순위가 높은 프로세스부터 CPU 할당하는 방식
- 우선순위 스케줄링 종류
  + 선점형 우선순위 스케줄링 : 현재 실행 중인 프로세스보다 우선순위가 높은 프로세스가 도착 시 CPU를 강제로 빼앗아 새로운 프로세스에 할당
  + 비선점형 우선순위 스케줄링 : 현재 실행 중인 프로세스가 CPU를 반환할 때까지 대기한 후, 우선순위가 높은 프로세스가 실행
- 응답시간이 중요한 시스템에 유리
- 우선순위가 낮은 프로세스는 우선순위가 높은 프로세스 때문에 오랫동안 CPU를 할당받지 못하는 Starvation 상태가 발생할 수 있음

> 멀티 레벨 큐 스케줄링 (Multi-level Queue Scheduling)
- 프로세스들을 여러 개의 큐로 분류하여, 각각의 큐에 다른 스케줄링 알고리즘을 적용하는 방식
- 대화형 프로세스는 높은 우선순위 큐, 배치 작업은 낮은 우선순위 큐에 넣는 식으로 관리 가능
- 각 큐는 독립적으로 다른 스케줄링 알고리즘을 사용할 수 있어 시스템 요구에 맞게 스케줄링 방식 조정이 가능
- 설정이 복잡하고, 각 큐의 우선순위와 작업 분배를 잘못하면 Starvation 상태가 발생

https://jwprogramming.tistory.com/17

# 프로세스와 쓰레드
## 프로세스와 스레드의 차이점은 무엇인가?
> 프로세스
- 실행 중인 프로그램의 인스터스로, 운영체제로부터 독립적인 메모리 공간을 할당받아 실행(컴퓨터에서 작업중인 프로그램)
- 프로세스 구조 : 코드, 데이터, heap, stack으로 구성된 자체 메모리 공간이며, 다른 프로세스와 메모리를 공유하지않음
- 프로세스는 PCB라는 데이터 구조를 통해 관리 
> 스레드
- 프로세스 내에서 실행되는 작업의 흐름으로, 프로세스의 자원을 공유하며 실행되는 작은 실행 단위
- 하나의 프로세스는 여러개의 스레드를 가질 수 있고, 해당 스레드들은 코드, 데이터, heap은 공유하지만 stack은 개별적으로 관리

https://inpa.tistory.com/entry/%F0%9F%91%A9%E2%80%8D%F0%9F%92%BB-%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4-%E2%9A%94%EF%B8%8F-%EC%93%B0%EB%A0%88%EB%93%9C-%EC%B0%A8%EC%9D%B4

## PCB(Process Control Block)란 무엇이며, 어떤 정보를 포함하나요?
- PCB 란 , 운영체제에서 프로세스를 관리하기 위해 해당 프로세스의 상태 정보를 담고있는 자료구조 ( 프로세스 스케줄링을 위한 프로세스 정보에 대한 임시 저장소 ) 
> PCB에 저장되는 정보
- 포인터 (Pointer): 프로세스의 현재 위치를 저장하는 포인터 정보
- 프로세스 상태 (Process state) : 프로세스의 각 상태를 저장 (생성(New), 준비(Ready), 실행(Running), 대기(Waiting), 종료(Terminated))
- 프로세스 식별자 (Process ID, PID) : 프로세스 고유하게 식별할 수 있는 고유 번호
- 프로그램 카운터 (Program Counter) : 현재 실행 중인 명령어의 위치를 가리키는 주소
- 레지스터 (Register) : CPU 레지스터에 있는 정보
- 메모리 관리 정보 (Memory Limits) : 해당 프로세스의 주소 공간 
- 입출력 상태 정보 : 프로세스에 할당된 입출력장치 목록 등
- CPU 스케줄링 정보 : 우선순위, 최종 실행시간, CPU 점유시간 등

## 프로세스 주소 공간이란 무엇이며, 프로세스마다 고유한 주소 공간을 가지는 이유는?
> 프로세스 주소공간
- 프로세스가 실행되는 동안 접근할 수 있는 메모리 영역
- OS는 프로세스마다 독립적인 주소 공간을 할당

> 주소 공간 구조
- Code
  + 프로그램의 실행 코드(명령어)가 저장되는 영역
  + 실행파일(.exe) 등의 명령어가 로드되며, 읽기 전용으로 설정되고 해당 영역은 수정 불가능 
- Data
  + 초기화된 전역 변수, 정적 변수가 저장되는 영역
  + 프로그램이 실행되기 전 컴파일 시점에 초기화된 데이터들이 해당 영역에 위치 
- Heap
  + 동적으로 할당된 메모리가 저장되는 영역
  + 런타임 동안 크기가 변경될 수 있고, 메모리 할당 및 해제 작업에 따라 동적으로 변경될 수 있음
  + 프로세스가 직접 관리해야하며, 메모리 누수가 발생할 수 있음 
- Stack
  + 함수 호출 시 생성되는 지역변수, 함수 호출 정보(리턴주소, 매개변수 등)가 저정되는 영역
  + 함수가 호출될때마다 쌓이며, 종료되면 할당 공간 해제
 
> 고유한 주소 공간을 가지는 이유
- 프로세스간 메모리 보호 및 보안 : 각 프로세스는 독립된 주소 공간을 가지므로 다른 프로세스 메모리에 접근할 수 없음 -> 프로세스간 메모리 보호 가능하며, 하나의 프로세스에서 발생한 오류가 다른 프로세스에 영향을 미치는 것을 방지
- 프로그램 안정성 및 충돌 방지 : 각 프로세스는 자신의 메모리 영역만을 사용하므로 메모리 충돌이 발생하지 않음
- 여러 프로세스를 동시에 실행할 수 있음  







