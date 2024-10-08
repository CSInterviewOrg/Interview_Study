## 네트워크에서 서버와 클라이언트는 각각 어떤 역할을 하나요?
- 서버: 네트워크에서 다른 컴퓨터나 소프트웨어와 같은 클라이언트에게 서비스를 제공하는 컴퓨터
- 클라이언트: 네트워크를 이용하여 서버측에 서비스 요청을 하는 컴퓨터
- 클라이언트가 서버에게 어떤 서비스를 요청하면 서버는 요청에 맞게 수행하고 처리 결과를 클라이언트에게 응답

## HTTP와 HTTPS의 차이점은 무엇인가요?
### HTTP
  - 클라이언트와 서버 간 통신을 위한 통신 규칙 또는 프로토콜
  - 사용자가 웹 사이트에 방문하면 웹 서버에 HTTP 요청을 보내고 웹 서버는 HTTP 응답으로 응답
  - HTTP 프로토콜: 네트워크 통신을 작동하게 하는 기본 기술
  - 암호화 되지 않은 데이터 전송 → 브라우저에서 전송된 정보를 가로채서 유출 가능
### HTTPS
- 통신 과정에 보안 계층을 추가
- HTTP 요청및 응답을 SSL 및 TLS 기술에 결합
- 데이터를 교환하기 전에 브라우저와 인증서를 공유 해야 함
- SSL 인증서는 암호화 정보도 포함하기 때문에 서버와 웹 브라우저는 암호화된 데이터 등 교환 가능
- 작동 과정
  1. HTTPS 웹 사이트 방문
  2. 브라우저는 서버의 SSL 인증서를 요청하여 사이트의 신뢰성을 검증
  3. 서버는 퍼블릭 키가 포함된 SSL 인증서를 전송
  4. 브라우저에서 인증 후, 브라우저가 퍼블릭 키를 사용하여 비밀 세션 키가 포함된 메시지 암호화하여 전송
  5. 웹 서버는 개인 키를 사용하여 메시지 해독 후 세션 키 검색 → 세션키를 안호화하여 브라우저에 승인 메시지 전송
  6. 브라우저와 서버 모두 동일한 세션 키를 사용하여 메시지 안전하게 교환
- HTTP 보다 HTTPS 를 사용하는 이유
  - 보안: HTTPS는 모든 데이터를 암호화하여 전송
  - 권위: 사용자 또는 검색 엔진 등이 HTTP의 신뢰성을 더 낮게 평가하기 때문에 HTTPS 선호
  - 성능: 로드 속도가 더 빠름 (예전에는 https가 더 빨랐지만 http/2가 속도 개선됨)
 
## TCP와 UDP의 차이점은 무엇인가요?
### TCP
  - 데이터를 메시지의 형태로 보내기 위해 IP와 함께 사용하는 프로토콜
  - 일반적으로 IP와 함께 사용하는데, IP는 데이터를 전송하는 역할, TCP는 패킷을 추적 관리하는 역할
      - 패킷: 인터넷 내에서 데이터를 보내기 위한 경로 배정을 효율적으로 하기 위해서 데이터를 여러 개의 조각으로 나누어 전송, 이때 조각 = 패킷
  - 연결 지향 프로토콜(클라이언트와 서버가 연결된 상태에서 데이터를 주고받는 프로토콜) 로 패킷 교환 방식 사용 → 패킷을 전송하기 위한 논리적 경로 배정
  - 3-way-handshaking 과정을 통해 연결을 설정하고 4-way-handshaking 을 통해 해제
  - 흐름 제어(데이터 처리 속도를 조절하여 수신자의 버퍼 오버플로우 방지) 및 혼잡 제어(패킷 수가 과도하게 증가하지 않도록 방지)
  - 높은 신뢰성 보장 → UDP 보다 느린 속도
  - 연속성보다 신뢰성 있는 전송이 중요할 때 사용하는 프로토콜

### UDP
  - 데이터를 독립적인 단위(데이터그램 방식)로 처리하는 프로토콜
  - 비연결형 프로토콜: 연결을 위해 할당되는 논리적 경로가 없음 → 각각의 패킷은 다른 경로로 전송되고 독립적으로 처리됨 → 전송 순서 보장 x
  - 정보를 주고 받을 때 정보를 보내고 받는 신호 절차가 없음
  - UCP 헤더의 CheckSum 필드를 통해 최소한의 오류만 검출
  - 신뢰성은 낮지만 속도는 빠름 → 신뢰성 보다는 연속성이 중요한 실시간 서비스에서 많이 사용

## IP 주소란 무엇이며, 어떻게 분류되나요?
### IP 주소
- IP 프로토콜에서 호스트나 네트워크 장비를 식별할 때 사용하는 값
- 인터넷에 접속한 컴퓨터와 라우터에 고유한 IP 주소를 할당하고 IP 주소를 사용하여 컴퓨터를 특정하거나 통신 상대방으로 지정
- IPv4
  - 3자리 숫자가 4마디로 표기되는 방식(32비트)
  - 42억 개의 IP를 할당할 수 있지만 현재 인터넷 환경으로는 한계가 있어 IPv6 체계 등장
- IPv6
  - 16비트씩 8자리로 각 자리를 ‘:’ 로 구분하는 128비트 체계의 인터넷 프로토콜
 
### 클래스 분류
- 대역에 따라 클래스 구분
- A class
    - 대규모 네트워크 환경에서 사용
    - 첫번째 마디의 숫자가 0~127까지 사용
    - 하나의 네트워크가 가질 수 있는 호스트 수가 가장 많은 클래스 (앞 8비트가 네트워크 영역, 뒤 24비트가 호스트 영역)
- B class
    - 중규모 네트워크 환경에서 사용
    - 첫번째 마디의 숫자가 128~191까지 사용
    - 앞 16비트가 네트워크 영역, 뒤 16비트가 호스트 영역
- C class
    - 소규모 네트워크 환경에서 사용
    - 첫번째 마디의 숫자가 192~223까지 사용
    - 앞 24비트가 네트워크 영역, 뒤 8비트가 호스트 영역
- D, E class도 있지만 잘 사용하지 않음

### 공인, 사설 IP
- 공인 IP: 인터넷 상에서 중복되지 않는 전 세계에서 유일한 IP 주소 보장
- 사설 IP: 모든 기기에 IP를 부여할 수 없기 때문에 라우터만 공인 IP를 사용하고 라우터에 연결된 기기는 사설 IP 사용(현재 라우터 내에서만 사용되는 주소)

## OSI 7계층 모델을 설명해주세요.
### OSI 모델
- 네트워크 통신 기능을 7개의 계층으로 나누는 개념적 프레임워크
- OSI 데이터 모델은 컴퓨터 네트워킹을 위한 범용 언어를 제공하기 때문에 다양한 기술이 표준 프로토콜 또는 통신 규칙을 사용하여 통신할 수 있음
### 7계층
1. 물리 계층
  - 케이블, 스위치 등 데이터 전송과 관련된 물리적 장비 포함
  - 1과 0의 문자열인 비트 스트림으로 변환되는 계층
2. 데이터 링크 계층
  - 동일한 네트워크에 있는 두개의 장치간 데이터 전송을 용이하게 해주는 역할
  - 네트워크 계층에서 패킷을 가져와 프레임이라는 더 작은 단위로 세분화
  - 네트워크 간 통신에 대해서만 흐름 제어 및 오류 제어 담당
3. 네트워크 계층
  - 서로 다른 네트워크 간 데이터 전송 용이하게 해주는 역할
  - 전송 계층의 세그먼트를 송신자의 장치에서 패킷이라는 더 작은 단위로 세분화하여 수신 장치에서 재조립
  - 라우팅: 데이터가 표적에 도달하기 위한 최상의 물리적 경로를 찾는 과정
  - IP, ICMP(인터넷 제어 메시지 프로토콜), IGMP(인터넷 그룹 메시지 프로토콜), IPsec 포함
4. 전송 계층
  - 두 기기 간의 종단 간 통신 담당
  - 세션 계층에서 데이터를 가져와서 네트워크 계층으로 보내기 전에 세그먼트라는 조각으로 분할하는 일 담당
  - 흐름 제어(연결 속도가 다른 경우 최적의 전송 속도 결정) 및 오류 제어(수신된 데이터 완료 여부를 확인하고 수신되지 않은 경우 재전송 요청) 기능의 역할
  - TCP, UDP 포함
5. 세션 계층
  - 두 기기 사이의 통신을 시작하고 종료하는 일 담당
  - 통신 시작부터 종료까지의 시간을 세션이라 하고, 모든 데이터를 전송할 수 있도록 세션을 개발하고 리소스를 낭비하지 않기 위해 세션을 즉시 닫을 수 있도록 보장
  - 데이터 전송을 체크포인트와 동기화하여 오류나 충돌 발생시 전체 데이터를 처음부터 다시 전송하지 않아도 되도록 해줌
6. 프레젠테이션 계층
  - 애플리케이션에서 사용할 수 있도록 데이터를 준비하는 계층
  - 데이터의 변환, 암호화, 압축 담당
  - 데이터의 변환: 통신하는 두개의 장치가 서로 다른 인코딩 방식을 사용하는 경우 수신 장치의 애플리케이션 계층이 이해할 수 있는 구문으로 데이터를 변환
  - 암호화: 암호화된 연결을 통해 통신해야 하는 경우, 최종 송신자에게 암호화를 추가하고 최종 수신자에게 암호화를 디코딩하여 읽기 쉬운 데이터로 제시
  - 압축: 애플리케이션 계층에서 수신한 데이터를 세션 계층으로 전송하기 전에 압축하는 일 담당, 전송할 데이터의 양을 최소화하여 통신의 속도, 효율 높임
7. 애플리케이션 계층
  - 사용자의 데이터와 직접 상호 작용하는 유일한 계층
  - 소프트웨어가 사용자에게 의미 있는 데이터를 제공하기 위해 의존하는 프로토콜과 데이터를 조작하는 역할
  - HTTP, SMTP(이메일 통신을 위한 프로토콜) 포함

## TCP/IP 모델을 OSI 모델과 비교하여 설명해주세요.
- TCP/IP 모델
    - 4개 계층
    - 특정 컴퓨터를 인터넷에 연결하는 방법, 컴퓨터 간에 전송하는 방법을 결정하는 데에 사용
    - 수평적 접근 방식
    - 연결 지향적인 TCP 트래픽을 위해 설계
    - 서로 다른 유형의 컴퓨터 간의 연결을 설정하는 데 사용
- OSI 모델
    - 7개 계층
    - 다른 시스템과 상호 연결 및 통신이 가능한 시스템에서 사용되는 네트워크 통신을 정의하는 개념적 모델
    - 연결 지향 및 연결이 없는 네트워크 트래픽을 모두 지원하는 모델
    - 수직적 접근 방식
    - 라우터, 스위치, 기타 하드웨어를 표준화하는 데 사용

## DNS의 역할은 무엇이며, 작동 방식은 어떻게 되나요?
### DNS(Domain Name System)
사람이 읽을 수 있는 도메인 이름을 머신이 읽을 수 있는 IP 주소로 변환하여 네트워크 트래픽이 올바른 IP 주소를 찾을 수 있도록 하는 역할
### 작동 방식
1. 사용자가 브라우저를 통해 웹 사이트 URL 입력
2. 브라우저가 입력된 도메인의 IP 주소를 알아 내기 위해 운영체제를 거쳐 DNS Resolver에 요청을 보냄
3. DNS Resolver는 로컬 DNS 캐시에 이전에 방문한 도메인 정보가 있는지 확인 후 기록이 있다면 바로 IP 주소 응답
4. 캐시에 정보가 없는 경우, 루트 DNS 서버에서 최상위 도메인 DNS 서버의 IP 주소 정보 조회
5. 최상위 도메인 DNS 서버에 연결하여 권한 네임 서버의 IP 주소 요청하여 받아냄
6. 최종적으로 권한 네임 서버에서 도메인의 최종 IP 주소를 알아내고 해당 IP 주소를 로컬 DNS 캐시에 저장
7. 받아온 최종 IP 주소를 브라우저에 전달

## ARP(주소 결정 프로토콜)란 무엇이며, 어떻게 작동하나요?
### ARP(Address Resolution Protocol)
- IP 주소를 MAC 주소와 매칭시키기 위한 프로토콜
> MAC 주소: 데이터 링크 계층에서 통신을 위한 네트워크 인터페이스에 할당된 고유 식별자, LAN에서 목적지와 통신하기 위한 실질적인 주소
- 단말간 통신에서 양쪽 단말은 IP를 이용하여 목적지를 지정하지만 실제 데이터 이동을 위해 MAC 주소를 함께 이용하기 위해 필요한 개념
- IP주소와 MAC주소를 일대일 매칭하여 LAN에서 목적지를 제대로 찾아갈 수 있도록 도와주는 역할
- ARP Table: IP주소와 MAC 주소를 일대일 대응하여 테이블로 정리하고 목적지 IP에 맞는 목적지 MAC 주소로 전달
- ARP 캐시: 각 단말에서 통신한 IP 주소의 MAC 주소를 일정 시간 동안 보관하여 사용
### 동작 순서
- 같은 네트워크에 있을 때
  1. 중계장치가 MAC 주소 테이블 정보를 저장하고 관리하고 있으므로 내부에서 단말들이 MAC 주소를 가지고 통신할 수 있게 해줌
  2. A가 B와 통신하기 위해 같은 네트워크 대역에 있는 모든 단말에 ARP 요청 전송(B의 IP 주소를 갖는 단말이 있는지 확인
  3. 네트워크 스위치 장비는 A의 MAC 주소를 자신의 MAC 주소 테이블에 저장
  4. 네트워크 스위치 장비가 ARP 요청을 받은 후 MAC 테이블에 B의 주소가 있다면 A에게 B의 IP주소의 MAC 주소 전달
  5. 네트워크 스위치 장비가 ARP 요청을 받은 후 MAC 테이블에 B의 주소가 없다면 반대편의 B까지 ARP 요청 전달 → B가 요청을 받은 후 자신의 MAC 주소를 응답 → 네트워크 스위치는 MAC 주소 테이블에 MAC 주소 저장
  6. A와 B 통신
- 같은 네트워크에 없을 때
  1. 다른 네트워크 대역에 있는 단말과 통신해야 하는 경우, ARP 프로토콜을 통해 IP 주소와 MAC 주소 간 변환을 통해 통신
  2. A가 B와 통신하기 위해 같은 네트워크 대역에 ARP 요청 전송
  3. 라우터는 해당 요청을 받고 B의 IP주소가 같은 네트워크에 있지 않기 때문에 같은 네트워크 대역에 있는 라우트의 인터페이스 MAC 주소로 응답
  4. A는 다시 라우터에게 B의 IP 주소와 같은 네트워크 대역의 라우터 인터페이스 MAC 주소로 ARP 요청 전송
  5. 라우터는 해당 네트워크 대역까지 패킷 전송
  6. B가 자신의 IP 주소가 목적지인 패킷을 확인 후 라우터에게 자신의 MAC 주소 응답
  7. 라우터를 통해 A, B 통신

## NAT(Network Address Translation)란 무엇인가요?
### NAT (Network Address Translation, 네트워크 주소 변환)
- IP 패킷의 TCP/UDP 포트 숫자와 소스 및 목적지의 IP 주소를 재기록하며 라우터를 통해 네트워크 트래픽을 주고 받는 기술
- 사설 네트워크에 속한 여러 개의 호스트가 하나의 공인 IP 주소를 사용하여 인터넷에 접속하기 위해 사용

## 네트워크에서 CORS(Cross-Origin Resource Sharing)는 무엇인가요?
### CORS
- 한 도메인에서 로드되어 다른 도메인에 있는 리소스와 상호 박용하는 클라이언트 웹 애플리케이션에 대한 방법
- 브라우저에서는 보안의 이유로 cross-origin HTTP 요청을 제한하기 때문에 cross-origin 요청을 하려면 서버의 동의가 필요함 → HTTP 헤더를 통해 동의를 구하고 거절하는 과정을 CORS라 한다.
- cross-origin: 프로토콜, 도메인, 포트번호 중 하나라도 다른 경우
- 외부에서 공격할 수 없도록 브라우저에서 보호하고 필요한 경우에만 서버와 협의하여 요청할 수 있도록 사용
- 작동 과정
  - 현재 브라우저 URL - 현재 오리진 ↔ 서드파티 URL - 크로스 오리진
  - 브라우저는 현재 오리진의 프로토콜, 호스트 및 포트에 대한 정보가 포함된 오리진 헤더를 요청에 추가
  - 서버는 현재 오리진 헤더를 확인하고 요청된 데이터와 Access-Control-Allow-Origin 헤더로 응답
  - 브라우저는 엑세스 제어 요청 헤더를 확인 후 반환된 데이터를 클라이언트 애플리케이션과 공유
  - 서버에서 크로스 오리진 엑세스를 허용하지 않으면 오류 메시지로 응답

## TCP 3-way 핸드셰이크 과정은 무엇인가요?
### TCP 3-way 핸드셰이크
데이터 전송 전에 클라이언트와 서버를 연결하는 데 사용되는 기본 프로세스
- 과정
  1. SYN: 연결을 설정하기 위해 클라이언트가 서버에게 SYN을 전송
  2. SYN + ACK: 서버는 요청 수락 후 SYN(세그먼트를 시작한 시퀀스 번호)+ACK(수신한 세크먼트의 응답) 응답
  3. ACK: 서버에게 응답을 받아 다시 서버에게 ACK 패킷 보내 수립 완료
- TCP 3-way-handshake 가 필요한 이유
  - 클라이언트와 서버 간의 안정적인 통신 보장
  - 무단 연결 방지(악의적으로 적절한 동기화 없이 연결 설정 방지)
 
## 4-way 종료 과정(TCP 연결 종료)은 어떻게 이루어지나요?
### 4-way-handshake
tcp 연결을 해제 하는 프로세스
- 과정
  1. FIN: 클라이언트가 서버에 연결 종료 요청
  2. ACK: 서버가 클라이언트 요청에 응답
  3. FIN: 모든 데이터 전송 완료 후 전송
  4. ACK: 클라이언트는 서버의 응답을 받아 전송
- 필요한 이유
  - 클라이언트는 데이터 전송을 완료하고 싶어도 아직 서버에 전송할 데이터가 남아있을 수 있기 때문에 필요

## 데이터 전송 중 손실이 발생할 때 TCP는 어떻게 처리하나요?
- 데이터 유실 원인
  - 네트워크 혼잡
  - 전송 경로 오류
  - 패킷 크기 초과
- 데이터 유실 처리
  - 순서 번호 및 ACK
    - tcp는 전송된 세그먼트에 순서 번호를 부여 → 수신 측은 세그먼트를 수신한 후 다음으로 수신할 세그먼트의 순서 번호를 포함한 ACK 패킷을 송신 측에 전송
  - 재전송 타이머
    - 송신 측은 세그먼트를 전송하고 ACK 를 기다림, 받지 못하고 타이머가 완료되면 세그먼트 재전송
  - 중복 ACK 및 빠른 재전송
    - 수신측에서 손실된 세그먼트 뒤에 세그먼트를 수신했지만 손실된 세그먼트가 수신되지 않으면 수신측은 마지막으로 정상적으로 수신한 세그먼트에 대해 중복 ACK 송신
  - 빠른 재전송
    - 송신 측은 중복 ACK를 연속하여 받으면 손실된 세그먼트가 발생했다 판단하고 해당 세그먼트를 즉시 재전송 → 대기 시간을 줄이고 신속하게 데이터 복구
  - 혼잡 제어
    - 혼잡 상태를 감지하여 데이터 전송 속도 조절
    - 혼잡 제어 알고리즘을 통해 네트워크 상태에 맞게 전송 속도 조절 및 속도 줄임

## TCP에서 슬라이딩 윈도우 프로토콜의 역할은 무엇인가요?
- tcp가 흐름 제어를 위해 사용하는 프로토콜
- 전송 측이 전송한 데이터에 대해 ACK를 받지 않고도 여러 패킷 전송 가능
- 수신 측에서 제대로 수신한 바이트에 대해 확인 응답을 전송할 때 마다 버퍼의 범위가 이동
- 호스트는 연결마다 하나의 윈도우 사용
> 윈도우: 호스트가 다른 호스트로부터 확인을 수신하기 위해 전송할 수 있는 버퍼의 범위
- 매커니즘
  - 열림: 수신 측으로부터 ACK를 받아 윈도우 오른쪽 경계를 오른쪽으로 이동 (윈도우 크기가 커지기 때문에 더 많은 데이터 전송 가능)
  - 닫힘: 데이터가 전송된 후 윈도우의 왼쪽 경계가 오른쪽으로 이동 (전송 측은 더이상 데이터에 대해 관여하지 않아도됨)
> Stop-and-Wait: ACK를 받고나서 다음 데이터를 전송하기 때문에 비효율적

## HTTP 상태 코드 200, 301, 404, 500의 차이점을 설명해주세요.
### HTTP 상태 코드
클라이언트가 보낸 HTTP 요청에 대한 서버의 응답 코드
- 1xx Informational(조건부 응답): 클라이언트가 서버에 정보를 요청했지만 해당 요청이 여전히 처리 중임을 나타내는 상태
- 2xx Successful(성공): 서버가 클라이언트의 요청을 수신하고 성공적으로 처리한 상태
  - 200 OK: 모든 것이 정상적으로 작동되었다는 의미
- 3xx Redirection(리다이랙션): 요청된 페이지가 일시적, 영구적으로 이동됐음을 클라이언트에게 알리는 상태
  - 301 Moved Permanently: URL이 영구적으로 다른 위치로 이동했다는 의미 (이후의 모든 요청은 다른 URL로 리다이랙션 되어야 함
- 4xx Client Error(요청 오류): 클라이언트의 잘못된 요청으로 서버가 요청을 수행하지 못하는 상태
  - 404 Not Founde: 손상된 링크를 클릭할 때 표시, 통신은 할 수 있지만 요청을 찾을 수 없음을 의미
- 5xx Server Error(서버 오류): 클라이언트의 요청이 성공했지만 서버 오류로 인해 서버가 요청을 정상 처리하지 못한 상태
  - 500 Server Error: 서버가 사용자의 리소스 요청을 처리할 수 없음을 의미
 
## HTTP/1.1과 HTTP/2의 주요 차이점은 무엇인가요?
- HTTP/1.1: HTTP의 첫번째 버전
- HTTP/2: HTTP/1.1의 문제점을 개선한 새로운 버전, 로드 프로세스 중에 콘텐츠의 우선순위 지정하여 더 빠르고 효율적으로 동작
> 우선순위 지정
>   - 콘텐츠가 로드되는 순서 → 웹 페이지 로드 시간에 영향을 미침
>   - 사용자에게 중요한 컨텐츠가 먼저 로드되어야 페이지가 더 빨리 로드되는 것처럼 인식
- HTTP/3
  - 다음 버전, 아직 많이 사용되진 않지만 사용량 증가 중
  - tcp 대신 QUIC를 통해 실행
  - QUIC: 최신 인터넷 요구에 맞게 설계된 더 빠르고 안전한 전송 계층 프로토콜
### HTTP/2와 HTTP/1.1 차이점
1. 멀티 플렉싱: 1.1은 리소스를 차례대로 로드하기 때문에 한 리소스를 로드할 수 없는 경우 그 뒤에 있는 모든 리소스를 차단함 ↔ 2는 단일 tcp 연결을 사용하여 한번에 여러 데이터 스트림을 보낼 수 있기 때문에 다른 리소스가 차단되지 않음
2. 서버 푸시: 클라이언트가 요청하는 경우에만 서버가 클라이언트 장치에 콘텐츠 제공 - 클라이언트가 요청해야 하는 여러 개별 리소스를 포함하는 최신 웹 페이지에서 효율성이 떨어질 수 있음 ↔ 2는 클라이언트가 요청 하기 전에 서버가 콘텐츠를 푸시하여 문제 해결 (예상되는 콘텐츠를 푸시한 내용을 클라이언트에게 알려주는 메시지 발송)
3. 헤더 압축: 작은 파일보다 큰 파일이 더 빨리 로드됨, 2는 HTTP 헤더 패킷에서 중복 정보를 제거하는 HPACK 방법을 사용하여 로드 속도 향상

## REST API와 SOAP의 차이점은 무엇인가요?
- 데이터 형식이 다른 다양한 기술 간에 데이터를 공유하기 위한 인터넷 데이터 교환 매커니즘
- 둘다 HTTP를 사용
- 둘다 SSL/TLS 지원
### SOAP
- 엄격한 통신 규칙을 정의하는 프로토콜
- 엄격하고 애플리케이션간 XML 메시징만 허용
- 서버는 클라이언트의 상태를 유지해야 하기 때문에 새요청을 할 때 이전 요청을 모두 알아야 함
- 더 크고 복잡하기 때문에 전송 및 처리 속도가 느려짐 → 페이지 로드 시간 늘어남
- 애플리케이션이 요청 간에 상태를 저장해야 하기 때문에 대역폭, 메모리 요구사항 증가 → 비용 증가, 확장 어려움
- HTTPS와 함께 사용하려면 WS-Security 계층 필요
> WS-Security: 추가 헤더 콘텐츠를 사용하여 지정된 서버의 지정된 프로세스만 콘텐츠를 읽도록 함(오버헤드 추가 발생 - 성능에 부정적인 영향 줌)
- 오류 처리 로직이 내장되어 있어 높은 신뢰성 제공
### REST
- API 작동 방식에 대한 소프트웨어 아키텍처 스타일
- 더 유연하고 애플리케이션에서 일반 텍스트, HTML, XML, JSON 으로 데이터 전송 가능
- stateless하기 때문에 새요청은 이전 요청과 독립적으로 처리
- 메시지 크기가 작아 더 빠르고 효율적, 캐시도 가능하기 때문에 로드 시간 단축 가능
- 무상태 및 계층화된 아키텍처를 허용하기 때문에 확장성이 좋음 (요청을 다른 서버로 전달하거나 콘텐츠 전송 네트워크와 같은 중개자가 요청 처리 허용 가능)
- 오버헤드 없이 HTTPS 지원
- 통신 장애 발생시 다시 시도 해야 하고 안정성 떨어짐
   
## 웹소켓(WebSocket)이란 무엇이며, HTTP와의 차이점은 무엇인가요?
### 웹 소켓
- 클라이언트와 서버를 연결하고 실시간으로 통신 가능하도록 하는 프로토콜(전이중 채널에서 통신)
- Socket Connection을 유지한 채로 실시간으로 양방향 통신이 가능한 프로토콜
- HTTP 와의 차이
  - HTTP는 단방향 통신으로 클라이언트에서 서버로 요청을 보내고 서버는 응답을 보냄 ↔ 양방향 통신으로 클라이언트가 요청하지 않아도 서버로부터 데이터를 받을 수 있음
  - HTTP는 stateless 하기 때문에 상태 저장 x ↔ stateful 프로토콜: 클라이언트와 서버가 한번 연결되면 같은 연결을 통해 통신하여 tcp 커넥션 비용 감소
  - HTTP는 클라이언트는 주기적으로 서버에 새로운 데이터 요청 필요 → 대기 시간 발생 ↔ 데이터가 사용 가능한 즉시 전달되기 때문에 계속 요청을 보내지 않아도 되므로 오버헤드 및 네트워크 트래픽이 최소화 되어 대기 시간 단축

## MQTT 프로토콜은 무엇이며, 어떤 상황에서 사용되나요?
### MQTT
- 머신 대 머신 통신에 사용되는 표준 기반 메시징 프로토콜
- 리소스 제약이 있는 네트워크를 통해 제한된 대역폭으로 데이터를 전송하고 수신하는 IoT 디바이스는 MQTT를 데이터 전송에 사용하여 더 효율적으로 데이터 전달
- 디바이스에서 클라우드, 클라우드에서 디사이스로의 메시징 지원
- 중요한 이유
  - 구현시 최소한의 리소스가 필요하여 가볍고 효율적
  - 구현에는 최소량의 코드가 필요하고 많은 수의 디바이스와의 통신을 지원하기 때문에 수백만개의 디바이스 연결 가능하여 확장성이 좋음
  - 메시지를 쉽게 암호화하고 최신 인증 프로토콜을 사용하여 디바이스와 사용자 인증 가능
- 구성 요소
  - 클라이언트
    - 서버부터 MQTT 라이브러리를 실행하는 마이크로 컨트롤러에 이르는 모든 디바이스
    - 메시지를 보내는 경우 게시자 역할, 수신하는 경우 수신자 역할
    - 네트워크를 통해 MQTT를 사용하여 통신하는 모든 디바이스 → MQTT 클라이언트 디바이스
  - 브로커
    - 여러 클라이언트 간의 메시지를 조정하는 백엔드 시스템
    - 메시지 수신 및 필터링, 각 메시지를 구독하는 클라이언트 식별, 메시지 전송, 클라이언트 권한 부여 및 인증, 누락된 메시지 및 클라이언트 세션 처리 등의 작업 담당
  - 연결
    - 클라이언트와 브로커는 MQTT 연결을 사용하여 통신 시작
    - 클라이언트는 CONNECT 메시지를 MQTT 브로커로 보내 연결 시작
    - 브로커는 CONNACK 메시지로 응답해서 연결 설정 확인
- 작동 방식
    1. 클라이언트가 브로커와의 연결 설정
    2. 연결되면 클라이언트에서 메시지 게시 및 구독 가능
    3. 브로커는 메시지를 수신한 후 메시지에 관심 있는 구독자에게 메시지 전달
 
## FTP와 SFTP의 차이점을 설명해주세요.
### FTP(File Transfer Protocol)
  - 파일을 전송하는 통신 규약
  - 보안이 좋지 않아 실무에서 사용하지 않음(예전 버전)
  - 액티브 모드: 클라이언트가 서버에게 포트 번호를 알려줘서 서버가 동작
  - 패시브 모드: 서버가 클라이언트에게 포트 번호를 알려줘서 클라이언트가 동작
  - 암호화되지 않기 때문에 패킷 공격을 통해 쉽게 데이터 읽을 수 있어 보안에 취약
### SFTP
  - FTP에 보안이 추가됨
  - ssh 기반으로 동작하는 것이 아니고 국제 인터넷 표준화 기구(IETF)에 의해 처음부터 설계된 새로운 프로토콜 (SSH의 확장 프로토콜)
  - 파일을 다운로드하거나 인터넷에 업로드할 때 사용
  - 압축 여부와 상관없이 4gb를 넘지 않아야 함
  - FTP와 달리 브라우저와 서버 간의 데이터 전송을 암호화하기 때문에 보안의 문제를 방지 가능
