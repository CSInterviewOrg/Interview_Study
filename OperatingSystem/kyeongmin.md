## 가상화란 무엇이며, 왜 운영 체제에서 중요한가요?
### 가상화
- 컴퓨터가 하드웨어 리소스를 디지털로 분리된 여러 환경과 공유할 수 있도록 하는 프로세스
- 가상화를 사용하면 하드웨어 리소스와 상호 작용할 때 유연성이 좋음
- 전기를 소비하고 스토리지 공간을 차지하며 유지 관리를 필요로 하는 물리적 서버 기능을 소프트웨어로 추상화함으로써 제한을 제거
- 여러 개의 물리적 서버를 설정하지 않고 단일 물리적 서버에 여러 개의 가상 머신을 생성 → 가상 머신에 대한 운영체제 요구 사항을 지정하고 물리적 서버와 같은 방식으로 사용 가능 (하드웨어 경비는 줄어듬)

## 운영 체제가 CPU, 메모리, 디스크를 가상화한 것은 무엇인가요?
- CPU 가상화: 프로세스가 CPU를 사용할 때 운영체제가 시간 분할 방식으로 CPU 시간을 할당하여 프로세스가 동시 실행되는 것처럼 보이게 함(스케줄링 알고리즘 사용)
- 메모리 가상화: 각 프로세스는 가상 주소 공간을 가지며 운영체제는 물리 메모리와 가상 메모리 간의 매핑 관리
- 디스크 가상화: 운영체제는 디스크 공간을 논리적으로 나누어 각 프로세스가 독립적인 파일 시스템을 사용하는 것처럼 보이게 함

## 운영체제에서 커널이란 무엇이며 시스템 콜에 대해서 설명해주세요
### 커널
- 항상 메모리에 상주하며 컴퓨터 자원을 관리하는 자원 관리자의 역할 - 사용자가 물리적 하드웨어에 접근하고 사용할 수 있도록 해줌
- 역할 4가지
  - 메모리 관리: 각 프로그램의 사용량 추적, 메모리 자원 할당
  - 프로세스 관리 및 CPU 스케줄링: CPU 시간 자원 배분
  - 디바이스 관리: 컴퓨터에 연결된 장치를 드라이버를 통해 관리
  - 시스템 콜 인터페이스 및 보안
### 시스템 콜
- 사용자나 응용 프로그램이 컴퓨터 자원을 사용하기 위해 호출 - 운영체제는 시스템 콜을 통해서만 커널에 접근할 수 있음(컴퓨터 자원 보호)
- 시스템 콜을 사용할 때, 프로그램은 특정함수나 라이브러리 호출을 통해 커널과 상호작용하고 이 과정에서 사용자 모드에서 커널모드로 전환 ⇒ 안정성, 보안성 확보

- 사용자 모드
  - 응용 프로그램이 실행되는 영역
  - 사용자가 접근할 수 있는 영역을 제한적으로 두고 프로그램의 자원에 접근하지 못하도록 설정하는 모드
- 커널 모드
  - 자원에 대한 제어권을 가지고 모든 자원에 접근하여 가능한 모든 명령어 실행
  - 커널모드는 바로 접근할 수 없고 커널모드 내부 함수 시스템 콜을 호출해야 함

## 인터럽트란 무엇이며 인터럽트와 시스템 콜의 차이점에 대해서 설명해주세요.
### 인터럽트
- 하드웨어나 소프트웨어가 CPU의 실행 흐름을 중단하고 특정 작업을 처리하도록 커널에 신호를 보내는 메커니즘
- 종류
  - 하드웨어 인터럽트: 외부장치에서 발생하며 이벤트가 발생했음을 CPU에 알림
  - 소프트웨어 인터럽트: 프로그램 실행 중 발생하여 특정조건이 충족될 때 발생
### 시스템 콜과의 차이점
- 발생 원인
  - 인터럽트: 하드웨어, 소프트웨어 이벤트로 발생
  - 시스템콜: 프로그램이 커널의 특정 기능을 요청할 때 발생
- 목적
  - 인터럽트: CPU가 하드웨어의 요청이나 상태 변화에 즉각적으로 반응
  - 시스템콜: 사용자 프로그램이 커널의 서비스를 이용할 수 있도록 함
- 처리 방식
  - 인터럽트: 커널은 인터럽트 발생시 현재 실행중인 프로세스를 중단하고 인터럽트 처리 후 다시 원래 프로세스 실행
  - 시스템콜: 프로그램이 시스템콜 실행하면 CPU는 사용자 모드에서 커널모드로 전환하여 요청 작업 수행
 
## 멀티프로세싱 시스템에서 스케줄링이 중요한 이유는 무엇인가?
1. 리소스 효율성: 멀티 프로세싱 환경에는 여러 CPU가 존제하므로 각 프로세스가 적절한 CPU에서 실행될 수 있도록 효율적인 리소스 분배 → CPU 활용도 극대화
2. 공정성: 모든 프로세스에게 공정하게 CPU 시간 할당 → 특정 프로세스가 오랜 시간 대기하지 않도록 하여 시스템 안정성 유지
3. 우선순위 관리: 중요한 작업이 우선적으로 신속하게 처리되도록 하여 사용자 경험 향상
4. 작업간 상호작용 관리: 여러 프로세스가 동시에 실행되기 때문에 이들 간 상호작용, 자원 공유 관리
5. 로드 밸런싱: 프로세스들이 여러 CPU에 고르게 분산되도록하여 과부하 방지, 시스템 성능 최적화

## 컨텍스트 스위칭이란 무엇이며, 컨텍스트 스위칭에 따라 오버헤드가 발생하는 이유가 무엇인가요?
### 컨텍스트 스위칭
- 여러개의 프로세스가 실행되고 있을 때 기존에 실행되던 프로세스를 중단하고 다른 프로세스를 실행하는 것 (cpu가 실행할 프로세스를 교체하는 기술)
- 동작 순서
  - A 실행중, B 대기중
  - 스케줄러가 A의 실행을 중단하고 B 실행 요청
  - A는 스택의 데이터 위치를 가리키는 포인터의 값과 다음 실행해야 하는 주소값을 가지고 있는 프로그램 카운터의 값을 PCB에 저장
  - A는 대기중 또는 block 상태로 바뀌고 b 실행(b가 실행 중으로 변경)
- 단점
  - 과도하고 발생할 경우 오버헤드 발생
### 오버헤드 발생 원인
- 상태 정보를 저장하고 복원하는 과정에서 메모리에 접근해야 하고 이때 많은 시간이 소요됨
- 각 프로세스에 대한 정보를 관리하기 위해 프로세스 테이블을 유지해야 함 ⇒ 상태를 계속 업데이트 해야 하기 때문에 추가적인 작업 필요
- 스케줄링 알고리즘에 따라 어떤 프로세스를 실행할지 결정해야 함 ⇒ 결정 과정도 추가적인 연산 필요
- 컨텍스트 스위칭이 빈번하게 발생하면 프로세스 간 전환에 소요되는 시간과 자원이 시스템 성능에 영향을 줄 수 있음

## CPU 스케줄링 알고리즘의 종류와 특징은?(라운드 로빈, 우선순위 스케줄링, 멀티 레벨 큐)
- FCFS(First Come First Served)
  - 비선점 스케줄링: 이미 할당된 cpu를 다른 프로세스가 강제로 뺏어 사용할 수 없는 스케줄링 기법
  - 프로세스 응답 시간 예측 용이, 일괄 처리 방식(여러개의 프로그램을 읽고 한번에 하나의 프로그램만 실행)에 적합
  - 먼저 도착한 프로세스가 먼저 cpu 선점
  - 단점 - Convoy Effect: 실행 시간이 짧은 프로세스들이 실행시간이 긴 프로세스를 계속해서 기다리면서 효율성 저하
- SJF(Shortest Jop First)
  - 실행시간이 가장 짧은 프로세스부터 실행
  - 비선점 스케줄링이기 때문에 이미 실행된 프로세스가 있다면 새로 도착한 프로세스는 더 짧아도 대기 필요
  - 단점 - Starvation: 실행시간이 긴 프로세스가 영원히 CPU를 할당받지 못함
- SRTF(Shortest Remaining Time First)
  - 선점형 스케줄링: 현재 실행 중인 프로세스보다 우선순위가 높은 프로세스가 도착하면 cpu 뺏김
  - 새로운 프로세스가 도착할 때마다 새롭게 스케줄링 진행
  - 새로운 프로세스가 들어온 시점에서 가장 실행시간이 짧은 프로세스 먼저 실행
  - 단점 - Starvation: SJF와 동일
  - 단점 - 새로운 프로세스가 올 때마다 스케줄링을 다시 실행하기 때문에 정확한 CPU burst time 측정 불가
- Priority Scheduling
  - 우선순위가 높은 프로세스가 CPU를 선점하도록 하는 스케줄링
  - 선점, 비선점 스케줄링 방식 모두 사용 가능
  - 단점 - 우선순위가 낮을 수록 계속 밀려 실행 불가
  - 단점 - 무기한 봉쇄: 우선순위가 높은 프로세스가 blocking 되어 있어 cpu가 계속해서 대기하는 상황
  - 해결방법 - 대기 시간이 증가할수록 우선순위를 높여주어 예방 가능
- Round-Robin
  - 각 프로세스는 동일한 할당 시간을 가짐
  - cpu를 할당 받고 할당 시간이 지나면 레디 상태로 돌아가 큐에 들어감
  - 프로세스들이 작업을 완료할 때까지 계속해서 순회
  - 장점 - Response Time이 빨라짐
  - 장점 - 모든 프로세스가 공정하게 cpu 할당 보장
- Multi Level Queue
  - 프로세스를 여러 개의 큐로 나누어 각각의 큐에 따라 서로 다른 스케줄링 알고리즘 적용하는 방법
  - 프로세스는 우선순위, 성격, 요구 자원 등의 기준에 따라 분류
  - 장점 - 서로 다른 특성을 가진 프로세스를 효율적으로 처리 가능, 중요도에 따라 우선순위 정해서 처리 가능
  - 단점 - 프로세스가 특정 큐에 고정되면 우선순위 낮은 프로세스가 오랜 시간 대기해야함, 구현 복잡

## 프로세스와 스레드의 차이점은 무엇인가?
### 프로세스
- 실행 중인 프로그램의 인스턴스
- 독립적인 메모리 공간을 가지며 다른 프로세스와 메모리를 공유하지 않음
- 프로세스 간 컨텍스트 스위칭이 복잡하고 많은 시간 소요됨
- 한 프로세스에서 발생한 오류는 다른 프로세스에 영향을 주지 않음
### 쓰레드
- 프로세스 내에서 실행되는 실행 단위
- 같은 프로세스 내의 여러 스레드는 메모리 공간을 공유함, 쓰레드 간 통신이 더 빠름
- 비교적 컨텍스트 스위칭이 빠름
- 한 스레드 내에서 발생한 오류가 다른 스레드에 영향을 줌

## PCB(Process Control Block)란 무엇이며, 어떤 정보를 포함하나요?
### PCB(Process Control Block)
- 운영체제가 각 프로세스를 관리하기 위해 사용되는 데이터 구조
- 프로세스의 상태와 관련된 정보를 저장하고 프로세스 생성, 실행, 대기, 종료 과정 추적할 때 사용 ⇒ 기반으로 컨텍스트 스위칭 수행(원활하게 여러 프로세스가 동시에 실행되게 해줌)
- 포함하는 정보
  - 프로세스 식별자(PID)
  - 프로세스 상태
  - 프로세스 우선순위(스케줄링에 사용)
  - 프로세스 카운터(PC): 다음에 실행할 명령어 주소 저장
  - CPU 레지스터: 프로세스가 실행 중일 때의 CPU 레지스터 값 포함 → 프로세스 재실행 시 필요
  - 메모리 관리 정보
  - I/O 상태 정보
  - 프로세스의 통계 정보
  - 연결 정보

## 프로세스 주소 공간이란 무엇이며, 프로세스마다 고유한 주소 공간을 가지는 이유는?
### 프로세스 주소 공간
- 각 프로세스가 사용할 수 있는 메모리 주소 범위
- 주소 공간 구성
  - 텍스트 영역: 실행할 프로그램 코드 저장
  - 데이터 영역: 전역 변수와 정적 변수 저장
  - 힙 영역: 동적으로 할당된 메모리 저장
  - 스택 영역: 함수 호출시 지역 변수, 함수의 매개변수, 반환 주소 저장
- 프로세스마다 고유한 주소 공간 가지는 이유
  - 각 프로세스가 독립적인 주소 공간을 갖기 때문에 다른 프로세스가 메모리에 접근 불가 → 프로세스 간 간섭 방지, 시스템 안정성 높임, 데이터 안전하게 보호
  - 프로세스 종료시 해당 주소 공간은 해제되어 다른 프로세스가 사용 가능 → 자원 관리
  - 컨텍스트 스위칭이 간편해짐 → 각 프로세스의 상태를 PCB에 저장하고 복원할 수 있어 프로세스를 효율적으로 스케줄링 가능